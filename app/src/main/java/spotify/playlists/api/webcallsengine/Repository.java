package spotify.playlists.api.webcallsengine;

import spotify.playlists.api.requests.GetPlaylistContentRequest;
import spotify.playlists.api.responses.interfaces.PlaylistContentResponseCallback;
import spotify.playlists.api.responses.interfaces.PlaylistsResponseCallback;

public interface Repository {
    void getPlaylists(PlaylistsResponseCallback callback, String userId);
    void getPlaylistContent(PlaylistContentResponseCallback callback, GetPlaylistContentRequest getPlaylistContentRequest);
}
