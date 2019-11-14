package demo.playlists.model.models;


import android.os.AsyncTask;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import demo.playlists.api.responses.events.PlaylistsResponseEvent;
import demo.playlists.api.responses.interfaces.PlaylistsResponseCallback;
import demo.playlists.api.webcallsengine.RestRepository;
import demo.playlists.model.interfaces.PlaylistsModelInterface;
import demo.playlists.model.localdaos.Playlist;
import demo.playlists.model.localdaos.Playlist_Table;
import demo.playlists.presenter.interfaces.PlaylistsPresenterInterface;


public class PlaylistsModel extends BaseModel<PlaylistsPresenterInterface> implements PlaylistsModelInterface, PlaylistsResponseCallback {

    @Inject
    public PlaylistsModel(RestRepository restRepository) {
        super(restRepository);
    }

    @Override
    public void getPlaylists(boolean forceUpdate){
        if(forceUpdate){
            getRepository().getPlaylists(this);
        }
        else{
            ArrayList<Playlist> playlists = getLocalPlaylists();
            if(playlists!=null && playlists.size()>0){
                getPresenterInterface().onLocalPlaylistsFetched(playlists);
            }
            else {
                getRepository().getPlaylists(this);
            }
        }
    }

    private void deleteLocalPlaylists(){
        FlowManager.getModelAdapter(Playlist.class).deleteAll(getLocalPlaylists());
    }


    private ArrayList<Playlist> getLocalPlaylists() {
        List<Playlist> playlists = new Select().from(Playlist.class)
                .orderBy(Playlist_Table.localId, true).queryList();
        return (ArrayList<Playlist>) playlists;
    }

    public void savePlaylistsLocalyInTheBackground(final ArrayList<Playlist> playlists){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                deleteLocalPlaylists();
                FlowManager.getModelAdapter(Playlist.class).saveAll(playlists);
            }
        });
    }

    @Override
    public void onResponse(PlaylistsResponseEvent responseEvent) {
        getPresenterInterface().onGetPlaylistsResponseEvent(responseEvent);
    }
}
