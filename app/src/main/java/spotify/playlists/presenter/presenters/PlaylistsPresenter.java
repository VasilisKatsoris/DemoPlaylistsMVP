package spotify.playlists.presenter.presenters;


import java.util.ArrayList;

import javax.inject.Inject;

import spotify.playlists.R;
import spotify.playlists.api.responses.events.PlaylistsResponseEvent;
import spotify.playlists.model.daos.PlaylistsDao;
import spotify.playlists.model.daos.PlaylistsDao.PlaylistDao;
import spotify.playlists.model.localdaos.Playlist;
import spotify.playlists.model.models.PlaylistsModel;
import spotify.playlists.model.models.interfaces.PlaylistsPresenterInterface;
import spotify.playlists.presenter.presenters.interfaces.PlaylistsViewInterface;


public class PlaylistsPresenter extends BasePresenter<PlaylistsViewInterface, PlaylistsModel> implements PlaylistsPresenterInterface {
    private ArrayList<Playlist> playlists;
    String lastSearchQuery;
    public ArrayList<Playlist> getCachedPlaylists(){
        return playlists;
    }

    @Inject
    public PlaylistsPresenter(PlaylistsViewInterface playlistsViewInterface, PlaylistsModel model)  {
         super(playlistsViewInterface, model);
    }

    public void getPlaylists(String userId) {
        this.lastSearchQuery = userId;
        getModel().getPlaylists(userId);
    }

    @Override
    public void onGetPlaylistsResponseEvent(PlaylistsResponseEvent getPlaylistsResponseEvent) {
         if (getPlaylistsResponseEvent == null || !getPlaylistsResponseEvent.validate() )  {
            if(getPlaylistsResponseEvent !=null){
                getViewInterface().onGetPlaylistsFailure(getPlaylistsResponseEvent.getNetworkError());
            }
        }
        else{
            playlists = preparePlaylistsForView(getPlaylistsResponseEvent.getResponseDao());
             if(playlists !=null){
                 getViewInterface().onGetPlaylistsSuccess(playlists);
             }
             else{
                 getViewInterface().onGetPlaylistsFailure(getString(R.string.Unknown_error));
             }
        }
    }

    @Override
    public void onLocalPlaylistsFetched(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
        getViewInterface().onGetPlaylistsSuccess(playlists);
    }

    private ArrayList<Playlist> preparePlaylistsForView(PlaylistsDao playlistsDao) {
        if(playlistsDao.getItems()==null){
            return null;
        }
        ArrayList<Playlist> playlists = new ArrayList<>();
        for(PlaylistDao playlistDao:playlistsDao.getItems()){
            playlists.add(new Playlist(playlistDao));
        }
        return playlists;
    }

    public String getCurrentSearch() {
        return lastSearchQuery;
    }
}
