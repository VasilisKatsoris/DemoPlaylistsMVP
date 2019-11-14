package demo.playlists.dagger;

import dagger.Module;
import dagger.Provides;
import demo.playlists.DemoPlaylistsApp;
import demo.playlists.api.webcallsengine.RestRepository;
import demo.playlists.view.interfaces.BaseViewInterface;
import demo.playlists.view.interfaces.PlaylistContentViewInterface;
import demo.playlists.view.interfaces.PlaylistsViewInterface;

@Module
public class BasePresenterIntefaceModule {

    BaseViewInterface view;

    public BasePresenterIntefaceModule(BaseViewInterface view) {
        this.view = view;
    }

    //Playlists
    @Provides
    PlaylistsViewInterface providePlaylistsViewInteface() {
        return (PlaylistsViewInterface) view;
    }

    //Playlist content
    @Provides
    PlaylistContentViewInterface providePlaylistContentViewInteface() {
        return (PlaylistContentViewInterface) view;
    }

    //Rest repository
    @Provides
    RestRepository provideRestRepository(){
        return DemoPlaylistsApp.appComponent.getRestRepository();
    }
}