package spotify.playlists.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;

import javax.inject.Inject;

import spotify.playlists.R;
import spotify.playlists.dagger.BasePresenterComponent;
import spotify.playlists.model.localdaos.Playlist;
import spotify.playlists.presenter.presenters.PlaylistsPresenter;
import spotify.playlists.view.adapters.PlaylistsAdapter;
import spotify.playlists.view.adapters.baseadapter.RecyclerViewClickListener;
import spotify.playlists.presenter.presenters.interfaces.PlaylistsViewInterface;
import spotify.playlists.view.fragments.interfaces.PlaylistsFragmentCallback;

public class PlaylistsFragment extends BaseRecyclerViewFragment<PlaylistsPresenter, PlaylistsAdapter>
        implements PlaylistsViewInterface, SwipeRefreshLayout.OnRefreshListener, RecyclerViewClickListener<Playlist> {

    PlaylistsFragmentCallback callbackToActivity;
    SearchView searchView;

    @Override
    public void onRefresh() {
        getPlaylists();
    }

    @Override
    public void onItemClicked(Playlist data, int position) {
        callbackToActivity.onPlaylistRowClicked(data);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof PlaylistsFragmentCallback){
            callbackToActivity = (PlaylistsFragmentCallback)context;
        }
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

        setRecyclerAdapter(new PlaylistsAdapter(new ArrayList<>(), this));

        View header = getLayoutInflater().inflate(R.layout.search_layout, null, false);
        addHeader(header);

        searchView = header.findViewById(R.id.searchview);
        searchView.setIconifiedByDefault(false);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                fadeProgressBar(true);
                getPresenter().getPlaylists(searchView.getQuery().toString());
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {  return false; }
        });

        if(getPresenter().getCachedPlaylists()!=null){
            hideProgressBar();
            getAdapter().setData(getPresenter().getCachedPlaylists());
        }

     }

    @Override
    public void onGetPlaylistsFailure(String errorMessage) {
        if(getActivity()!=null) {
            showEmptyList();
            swipeRefreshLayout.setRefreshing(false);
            fadeProgressBar(false);
            if (errorMessage != null) {
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onGetPlaylistsSuccess(ArrayList<Playlist> playlists) {
        if(playlists !=null && playlists.size()>0){
            swipeRefreshLayout.setRefreshing(false);
            getAdapter().setData(playlists);
            notifyDataSetChanged();
            animateRecyclerViewWhenLayoutIsReady();
        }
        else{
            getAdapter().setData(new ArrayList<>());
            notifyDataSetChanged();
        }
        fadeProgressBar(false);
        showNoResultsView(playlists ==null || playlists.size()==0);
    }

    void showEmptyList(){
        getAdapter().setData(new ArrayList<>());
        notifyDataSetChanged();
        showNoResultsView(true);
    }

    void getPlaylists(){
        if(getPresenter()!=null) {
            getAdapter().clearData();
            getPresenter().getPlaylists(getPresenter().getCurrentSearch());
        }
    }

}
