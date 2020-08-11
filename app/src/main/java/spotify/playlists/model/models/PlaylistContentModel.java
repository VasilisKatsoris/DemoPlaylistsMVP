package spotify.playlists.model.models;


import javax.inject.Inject;

import spotify.playlists.api.requests.GetPlaylistContentRequest;
import spotify.playlists.api.responses.events.PlaylistContentResponseEvent;
import spotify.playlists.api.responses.interfaces.PlaylistContentResponseCallback;
import spotify.playlists.api.webcallsengine.RestRepository;
import spotify.playlists.model.models.interfaces.PlaylistContentPresenterInterface;


public class PlaylistContentModel extends BaseModel<PlaylistContentPresenterInterface> implements  PlaylistContentResponseCallback {


    @Inject
    public PlaylistContentModel(RestRepository restRepository) {
        super(restRepository);
    }


    public void getPlaylistContent(String playlistId) {
        getRepository().getPlaylistContent(this, new GetPlaylistContentRequest(playlistId));
    }

    @Override
    public void onResponse(PlaylistContentResponseEvent responseEvent) {
        getPresenterInterface().onGetPlaylistContentResponseEvent(responseEvent);
    }
}
