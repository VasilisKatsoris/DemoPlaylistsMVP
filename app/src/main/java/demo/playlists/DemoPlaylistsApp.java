package demo.playlists;

import android.app.Application;
import android.os.Build;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.FlowSQLiteOpenHelper;

import demo.playlists.dagger.AppComponent;
import demo.playlists.dagger.DaggerAppComponent;
import demo.playlists.model.PlaylistsDatabase;


public class DemoPlaylistsApp extends Application {

    public static AppComponent appComponent;

    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.create();

        FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);

        //initialize the local database
        FlowManager.init(new FlowConfig.Builder(this).build());
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN) {
            ((FlowSQLiteOpenHelper)FlowManager.getDatabase(PlaylistsDatabase.NAME).getHelper()).setWriteAheadLoggingEnabled(false);
        }

    }

}
