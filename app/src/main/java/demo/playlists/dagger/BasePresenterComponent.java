package demo.playlists.dagger;

import javax.inject.Singleton;

import dagger.Component;
import demo.playlists.view.fragments.PlaylistContentFragment;
import demo.playlists.view.fragments.PlaylistsFragment;

@Singleton
@Component(modules = {BasePresenterIntefaceModule.class})
public interface BasePresenterComponent {
    void injectPlaylistsPresenter(PlaylistsFragment playlistsFragment);
    void injectPlaylistContentPresenter(PlaylistContentFragment playlistContentFragment);
}
