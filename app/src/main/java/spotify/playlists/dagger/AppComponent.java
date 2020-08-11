package spotify.playlists.dagger;

import javax.inject.Singleton;

import dagger.Component;
import spotify.playlists.api.webcallsengine.RestRepository;

@Singleton
@Component
public interface AppComponent {
    RestRepository getRestRepository();
}
