package demo.playlists.api.requests;

public class GetPlaylistContentRequest extends BaseRequest {
    String playlistId;

    public GetPlaylistContentRequest(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistId() {
        return playlistId;
    }

}
