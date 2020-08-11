package spotify.playlists;

import android.app.Application;

import spotify.playlists.dagger.AppComponent;
import spotify.playlists.dagger.DaggerAppComponent;

public class SpotifyPlaylistsApp extends Application {

    public static AppComponent appComponent;

    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
    }

}
