package spotify.playlists.view.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import javax.inject.Inject;

import spotify.playlists.dagger.BasePresenterComponent;
import spotify.playlists.model.localdaos.Playlist;
import spotify.playlists.model.localdaos.Song;
import spotify.playlists.presenter.presenters.PlaylistContentPresenter;
import spotify.playlists.presenter.presenters.interfaces.PlaylistContentViewInterface;
import spotify.playlists.view.adapters.SongsAdapter;
import spotify.playlists.view.adapters.baseadapter.RecyclerViewClickListener;

public class PlaylistContentFragment extends BaseRecyclerViewFragment<PlaylistContentPresenter, SongsAdapter> implements PlaylistContentViewInterface, RecyclerViewClickListener<Song>{

    private static final String PLAYLIST = "PLAYLIST";
    private Playlist playlist;

    public static PlaylistContentFragment newInstance(Playlist playlist) {
        PlaylistContentFragment f = new PlaylistContentFragment();
        Bundle args = new Bundle();
        args.putParcelable(PLAYLIST,playlist);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            playlist = getArguments().getParcelable(PLAYLIST);
        }
    }

    @Override
    public void performPresenterInjection(BasePresenterComponent injector) {
        injector.injectPlaylistContentPresenter(this);
    }

    @Override
    @Inject
    public void onPresenterInjection(PlaylistContentPresenter presenter) {
        setPresenter(presenter);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        setRecyclerAdapter(new SongsAdapter(new ArrayList<Song>(), this));
        if(getPresenter().getCachedSongs()!=null){
            hideProgressBar();
            getAdapter().setData(getPresenter().getCachedSongs());
            notifyDataSetChanged();
        }
        else{
            showProgressBar();
            getSongs();
        }
    }

    @Override
    public void onRefresh() {
        if(getPresenter()!=null) {
            getAdapter().clearData();
            getSongs();
        }
    }

    @Override
    public void onGetPlaylistContentFailure(String errorMessage) {
        if(getActivity()!=null) {
            swipeRefreshLayout.setRefreshing(false);
            fadeProgressBar(false);
            if (errorMessage != null) {
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onGetPlaylistContentSuccess(final ArrayList<Song> songs) {
        if(songs !=null && getActivity()!=null){
            swipeRefreshLayout.setRefreshing(false);
            getAdapter().setData(songs);
            notifyDataSetChanged();
            fadeProgressBar(false);
            animateRecyclerViewWhenLayoutIsReady();
        }
    }

    private void getSongs(){
        if(playlist!=null) {
            getPresenter().getPlaylistContent(playlist.getPlaylistId());
        }
    }

    @Override
    public void onItemClicked(Song data, int position) {

    }

}
