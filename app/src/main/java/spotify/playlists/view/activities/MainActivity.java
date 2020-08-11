package spotify.playlists.view.activities;

import android.os.Bundle;

import spotify.playlists.R;
import spotify.playlists.model.localdaos.Playlist;
import spotify.playlists.view.fragments.PlaylistContentFragment;
import spotify.playlists.view.fragments.PlaylistsFragment;
import spotify.playlists.view.fragments.interfaces.PlaylistsFragmentCallback;

public class MainActivity extends BaseActivity implements PlaylistsFragmentCallback {

    public static final String PLAYLISTS_FRAGMENT_TAG ="PLAYLISTS_FRAGMENT_TAG",
                               PLAYLIST_CONTENT_FRAGMENT_TAG ="PLAYLIST_CONTENT_FRAGMENT_TAG";
    final String TITLE = "TITLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if(savedInstanceState==null) {
            loadFragment(new PlaylistsFragment(), PLAYLISTS_FRAGMENT_TAG);
            setTitle(R.string.Playlists);
        }
        else{
            setTitle(savedInstanceState.getString(TITLE));
        }
    }

    @Override
    public void onPlaylistRowClicked(Playlist playlist) {
        PlaylistContentFragment playlistContentFragment = PlaylistContentFragment.newInstance(playlist);
        setTitle(playlist.getName());
        loadFragment(playlistContentFragment, PLAYLIST_CONTENT_FRAGMENT_TAG);
    }

    @Override
    public void onBackPressed() {
        //if has more than one fragments pop back stack
        //else finish
        if (getFragmentsCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
        } else {
            finish();
        }
        if(getCurrentFragment() instanceof PlaylistsFragment){
            setTitle(getString(R.string.Playlists));
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TITLE, getTitle().toString());
    }



}