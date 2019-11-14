package demo.playlists.api.webcallsengine;

import demo.playlists.api.requests.GetPlaylistContentRequest;
import demo.playlists.api.responses.interfaces.PlaylistContentResponseCallback;
import demo.playlists.api.responses.interfaces.PlaylistsResponseCallback;

public interface Repository {
    void getPlaylists(PlaylistsResponseCallback callback);
    void getPlaylistContent(PlaylistContentResponseCallback callback, GetPlaylistContentRequest getPlaylistContentRequest);
}
