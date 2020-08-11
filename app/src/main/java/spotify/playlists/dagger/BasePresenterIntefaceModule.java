package spotify.playlists.dagger;

import dagger.Module;
import dagger.Provides;
import spotify.playlists.SpotifyPlaylistsApp;
import spotify.playlists.api.webcallsengine.RestRepository;
import spotify.playlists.presenter.presenters.interfaces.BaseViewInterface;
import spotify.playlists.presenter.presenters.interfaces.PlaylistContentViewInterface;
import spotify.playlists.presenter.presenters.interfaces.PlaylistsViewInterface;

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
        return SpotifyPlaylistsApp.appComponent.getRestRepository();
    }
}