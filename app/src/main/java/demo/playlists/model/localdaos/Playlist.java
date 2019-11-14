package demo.playlists.model.localdaos;

import android.os.Parcel;
import android.os.Parcelable;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import demo.playlists.model.PlaylistsDatabase;
import demo.playlists.model.daos.PlaylistsDao;

@Table(database = PlaylistsDatabase.class)
public class Playlist extends BaseModel implements Parcelable {

    @Column
    @PrimaryKey(autoincrement = true)
    int localId;

    @Column
    private String playlistId;
    @Column
    private String name;
    @Column
    private int itemCount;

    public Playlist() {
    }

    public Playlist(PlaylistsDao.PlaylistDao playlistDao) {
        this.playlistId = playlistDao.getPlaylistId();
        this.name = playlistDao.getName();
        this.itemCount = playlistDao.getItemCount();
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
        localId = in.readInt();
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
        dest.writeInt(localId);
        dest.writeString(playlistId);
        dest.writeString(name);
        dest.writeInt(itemCount);
    }
}
