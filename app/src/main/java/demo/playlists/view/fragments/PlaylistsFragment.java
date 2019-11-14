package demo.playlists.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import demo.playlists.R;
import demo.playlists.dagger.BasePresenterComponent;
import demo.playlists.model.localdaos.Playlist;
import demo.playlists.presenter.presenters.PlaylistsPresenter;
import demo.playlists.view.adapters.PlaylistsAdapter;
import demo.playlists.view.adapters.baseadapter.RecyclerViewClickListener;
import demo.playlists.view.interfaces.PlaylistsViewInterface;

public class PlaylistsFragment extends BaseRecyclerViewFragment<PlaylistsPresenter, PlaylistsAdapter> implements PlaylistsViewInterface,
        SwipeRefreshLayout.OnRefreshListener, RecyclerViewClickListener<Playlist> {

    PlaylistsFragmentCallback callbackToActivity;

    @Override
    public void onRefresh() {
        getPlaylists(true);
    }

    @Override
    public void onItemClicked(Playlist data, int position) {
        callbackToActivity.onPlaylistRowClicked(data);
    }


    public interface PlaylistsFragmentCallback {
        void onPlaylistRowClicked(Playlist playlist);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof PlaylistsFragmentCallback){
            callbackToActivity = (PlaylistsFragmentCallback)context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Override
    public void performPresenterInjection(BasePresenterComponent injector) {
        injector.injectPlaylistsPresenter(this);
    }

    @Override
    @Inject
    public void onPresenterInjection(PlaylistsPresenter presenter) {
        setPresenter(presenter);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        setRecyclerAdapter(new PlaylistsAdapter(new ArrayList<Playlist>(), this));

        if(getPresenter().getCachedPlaylists()!=null){
            hideProgressBar();
            getAdapter().setData(getPresenter().getCachedPlaylists());
        }
        else{
            showProgressBar();
            getPlaylists(false);
        }

     }

    @Override
    public void onGetPlaylistsFailure(String errorMessage) {
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
    public void onGetPlaylistsSuccess(ArrayList<Playlist> playlists) {
        if(playlists !=null){
            swipeRefreshLayout.setRefreshing(false);
            getAdapter().setData(playlists);
            notifyDataSetChanged();
            fadeOutProgressBar();
            animateRecyclerViewWhenLayoutIsReady();
        }
        else{
            getAdapter().setData(new ArrayList<Playlist>());
            notifyDataSetChanged();
        }
    }

    void getPlaylists(boolean forceUpdate){
        if(getPresenter()!=null) {
            if(forceUpdate){
                getAdapter().clearData();
            }
            getPresenter().getPlaylists(forceUpdate);
        }
    }




}
