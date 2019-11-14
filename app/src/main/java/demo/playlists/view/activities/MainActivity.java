package demo.playlists.view.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import demo.playlists.R;
import demo.playlists.model.localdaos.Playlist;
import demo.playlists.view.fragments.PlaylistContentFragment;
import demo.playlists.view.fragments.PlaylistsFragment;

public class MainActivity extends AppCompatActivity implements PlaylistsFragment.PlaylistsFragmentCallback {
    public static final String PLAYLISTS_FRAGMENT_TAG ="PLAYLISTS_FRAGMENT_TAG",
            PLAYLIST_CONTENT_FRAGMENT_TAG ="PLAYLIST_CONTENT_FRAGMENT_TAG";
    String TITLE = "TITLE";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TITLE, getTitle().toString());
    }

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
        FragmentManager fm = getSupportFragmentManager();
        int stackLevel = fm.getBackStackEntryCount() - 1;
        if (stackLevel > 0) {
            getSupportFragmentManager().popBackStackImmediate();
        } else {
            finish();
        }
        if(getCurrentFragment() instanceof PlaylistsFragment){
            setTitle(getString(R.string.Playlists));
        }

    }

    public Fragment getCurrentFragment(){
        return getSupportFragmentManager().findFragmentById(R.id.fragment_container);
    }

    public void loadFragment(Fragment fragment, String tag){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        int stackLevel = getSupportFragmentManager().getBackStackEntryCount() - 1;
        if(stackLevel>=0) {
            //first fragment loaded instantly and the rest with animation
            transaction.setCustomAnimations(R.anim.fragment_enter_from_right, R.anim.fragment_exit_to_left,
                    R.anim.fragment_enter_from_left, R.anim.fragment_exit_to_right);
        }
        transaction.addToBackStack(tag).replace(R.id.fragment_container, fragment, tag).commit();
    }

}