package spotify.playlists.model.models;


import javax.inject.Inject;

import spotify.playlists.api.responses.events.PlaylistsResponseEvent;
import spotify.playlists.api.responses.interfaces.PlaylistsResponseCallback;
import spotify.playlists.api.webcallsengine.RestRepository;
import spotify.playlists.model.models.interfaces.PlaylistsPresenterInterface;


public class PlaylistsModel extends BaseModel<PlaylistsPresenterInterface> implements PlaylistsResponseCallback {

    @Inject
    public PlaylistsModel(RestRepository restRepository) {
        super(restRepository);
    }

    public void getPlaylists(String userId){
        getRepository().getPlaylists(this, userId);
    }


    @Override
    public void onResponse(PlaylistsResponseEvent responseEvent) {
        getPresenterInterface().onGetPlaylistsResponseEvent(responseEvent);
    }
}
