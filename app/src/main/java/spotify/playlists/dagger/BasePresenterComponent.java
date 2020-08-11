package spotify.playlists.dagger;

import javax.inject.Singleton;

import dagger.Component;
import spotify.playlists.view.fragments.PlaylistContentFragment;
import spotify.playlists.view.fragments.PlaylistsFragment;

@Singleton
@Component(modules = {BasePresenterIntefaceModule.class})
public interface BasePresenterComponent {
    void injectPlaylistsPresenter(PlaylistsFragment playlistsFragment);
    void injectPlaylistContentPresenter(PlaylistContentFragment playlistContentFragment);
}
