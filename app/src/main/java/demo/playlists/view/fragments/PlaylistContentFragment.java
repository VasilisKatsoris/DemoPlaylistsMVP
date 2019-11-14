package demo.playlists.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import demo.playlists.R;
import demo.playlists.dagger.BasePresenterComponent;
import demo.playlists.model.localdaos.Playlist;
import demo.playlists.model.localdaos.Song;
import demo.playlists.presenter.presenters.PlaylistContentPresenter;
import demo.playlists.view.adapters.baseadapter.RecyclerViewClickListener;
import demo.playlists.view.adapters.SongsAdapter;
import demo.playlists.view.interfaces.PlaylistContentViewInterface;

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
            if (errorMessage != null) {
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getActivity(), R.string.Unknown_error, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onGetPlaylistContentSuccess(final ArrayList<Song> songs) {
        if(songs !=null && getActivity()!=null){
            swipeRefreshLayout.setRefreshing(false);
            getAdapter().setData(songs);
            notifyDataSetChanged();
            fadeOutProgressBar();
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
