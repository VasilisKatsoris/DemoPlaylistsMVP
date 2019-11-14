package demo.playlists.presenter.interfaces;

import demo.playlists.api.responses.events.PlaylistContentResponseEvent;


public interface PlaylistContentPresenterInterface extends BasePresenterInterface {
    void getPlaylistContent(String playlistId);
    void onGetPlaylistContentResponseEvent(PlaylistContentResponseEvent responseEvent);
}
