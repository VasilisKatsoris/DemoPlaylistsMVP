package spotify.playlists.model.daos;

import com.google.gson.annotations.SerializedName;

import spotify.playlists.api.webcallsengine.BaseDAO;

public class PlaylistImageDao extends BaseDAO {


    @SerializedName("height")
    private int height;
    @SerializedName("url")
    private String url;
    @SerializedName("width")
    private int width;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
