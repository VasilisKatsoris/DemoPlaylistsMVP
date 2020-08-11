package spotify.playlists.model.models.interfaces;

import spotify.playlists.api.responses.events.PlaylistContentResponseEvent;


public interface PlaylistContentPresenterInterface extends BasePresenterInterface {
    void getPlaylistContent(String playlistId);
    void onGetPlaylistContentResponseEvent(PlaylistContentResponseEvent responseEvent);
}
