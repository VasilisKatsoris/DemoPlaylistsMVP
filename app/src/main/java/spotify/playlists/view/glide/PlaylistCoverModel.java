package spotify.playlists.view.glide;

public class PlaylistCoverModel {

    String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public PlaylistCoverModel setMediaId(String mediaId) {
        this.mediaId = mediaId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaylistCoverModel that = (PlaylistCoverModel) o;
        return mediaId.equals(that.mediaId);
    }

    @Override
    public int hashCode() {
        return mediaId.hashCode();
    }
}
