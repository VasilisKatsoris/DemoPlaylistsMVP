package spotify.playlists.model.localdaos;

import android.os.Parcel;
import android.os.Parcelable;

import spotify.playlists.model.daos.PlaylistsDao;

public class Playlist  implements Parcelable {

    private String playlistId;
    private String name;
    private int itemCount;

    public Playlist() {
    }

    public Playlist(PlaylistsDao.PlaylistDao playlistDao) {
        this.playlistId = playlistDao.getId();
        this.name = playlistDao.getName();
        if(playlistDao.getTracks()!=null) {
            this.itemCount = playlistDao.getTracks().getTotal();
        }
    }


    //setters getters
    public String getPlaylistId() {
        return playlistId;
    }

    void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemCount() {
        return itemCount;
    }

    void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    //Parcelable implementation
    protected Playlist(Parcel in) {
        playlistId = in.readString();
        name = in.readString();
        itemCount = in.readInt();
    }

    public static final Creator<Playlist> CREATOR = new Creator<Playlist>() {
        @Override
        public Playlist createFromParcel(Parcel in) {
            return new Playlist(in);
        }

        @Override
        public Playlist[] newArray(int size) {
            return new Playlist[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(playlistId);
        dest.writeString(name);
        dest.writeInt(itemCount);
    }
}
