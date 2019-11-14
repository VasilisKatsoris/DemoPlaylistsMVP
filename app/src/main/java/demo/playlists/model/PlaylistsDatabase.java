package demo.playlists.model;


import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = PlaylistsDatabase.NAME, version = PlaylistsDatabase.VERSION)
public class PlaylistsDatabase {
    public static final String NAME = "PlaylistsDatabase";
    static final int VERSION = 1;
}

