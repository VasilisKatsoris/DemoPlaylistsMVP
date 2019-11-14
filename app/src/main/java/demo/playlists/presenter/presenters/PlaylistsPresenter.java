package demo.playlists.presenter.presenters;


import java.util.ArrayList;

import javax.inject.Inject;

import demo.playlists.R;
import demo.playlists.api.responses.events.PlaylistsResponseEvent;
import demo.playlists.model.daos.PlaylistsDao;
import demo.playlists.model.daos.PlaylistsDao.PlaylistDao;
import demo.playlists.model.localdaos.Playlist;
import demo.playlists.model.models.PlaylistsModel;
import demo.playlists.presenter.interfaces.PlaylistsPresenterInterface;
import demo.playlists.view.interfaces.PlaylistsViewInterface;


public class PlaylistsPresenter extends BasePresenter<PlaylistsViewInterface, PlaylistsModel> implements PlaylistsPresenterInterface {
    private ArrayList<Playlist> playlists;

    public ArrayList<Playlist> getCachedPlaylists(){
        return playlists;
    }

    @Inject
    public PlaylistsPresenter(PlaylistsViewInterface playlistsViewInterface, PlaylistsModel model)  {
         super(playlistsViewInterface, model);
    }

    @Override
    public void getPlaylists(boolean forceUpdate) {
        getModel().getPlaylists(forceUpdate);
    }

    @Override
    public void onGetPlaylistsResponseEvent(PlaylistsResponseEvent getPlaylistsResponseEvent) {
         if (getPlaylistsResponseEvent == null || !getPlaylistsResponseEvent.validate() )  {
            if(getPlaylistsResponseEvent !=null){
                String error = getPlaylistsResponseEvent.getNetworkError();
                getViewInterface().onGetPlaylistsFailure(error!=null ? error : getString(R.string.Unknown_error));
            }
        }
        else{
            playlists = preparePlaylistsForView(getPlaylistsResponseEvent.getResponseDao());
             if(playlists !=null){
                 getModel().savePlaylistsLocalyInTheBackground(playlists);
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
        if(playlistsDao.getPlaylists()==null){
            return null;
        }
        ArrayList<Playlist> playlists = new ArrayList<>();
        for(PlaylistDao playlistDao:playlistsDao.getPlaylists()){
            playlists.add(new Playlist(playlistDao));
        }
        return playlists;
    }

}
