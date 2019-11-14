package demo.playlists.dagger;

import javax.inject.Singleton;

import dagger.Component;
import demo.playlists.api.webcallsengine.RestRepository;

@Singleton
@Component
public interface AppComponent {
    RestRepository getRestRepository();
}
