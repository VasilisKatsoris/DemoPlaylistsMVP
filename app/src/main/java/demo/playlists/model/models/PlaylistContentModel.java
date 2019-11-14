package demo.playlists.model.models;


import javax.inject.Inject;

import demo.playlists.api.requests.GetPlaylistContentRequest;
import demo.playlists.api.responses.events.PlaylistContentResponseEvent;
import demo.playlists.api.responses.interfaces.PlaylistContentResponseCallback;
import demo.playlists.api.webcallsengine.RestRepository;
import demo.playlists.model.interfaces.PlaylistContentModelInterface;
import demo.playlists.presenter.interfaces.PlaylistContentPresenterInterface;


public class PlaylistContentModel extends BaseModel<PlaylistContentPresenterInterface> implements PlaylistContentModelInterface, PlaylistContentResponseCallback {


    @Inject
    public PlaylistContentModel(RestRepository restRepository) {
        super(restRepository);
    }


    @Override
    public void getPlaylistContent(String playlistId) {
        getRepository().getPlaylistContent(this, new GetPlaylistContentRequest(playlistId));
    }

    @Override
    public void onResponse(PlaylistContentResponseEvent responseEvent) {
        getPresenterInterface().onGetPlaylistContentResponseEvent(responseEvent);
    }
}
