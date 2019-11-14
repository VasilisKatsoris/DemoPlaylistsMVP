package demo.playlists;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import demo.playlists.dagger.AppComponent;
import demo.playlists.model.models.PlaylistsModel;
import demo.playlists.presenter.interfaces.PlaylistsPresenterInterface;

import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DemoPlaylistsApp.class)
public class BaseModelTest {
    PlaylistsModel model;
    @Mock
    PlaylistsPresenterInterface playlistsPresenterInterface;
    AppComponent appComponent;

    @Before
    public void setUp(){
        model = new PlaylistsModel(playlistsPresenterInterface);
    }


    @Test
    public void lalala(){
        appComponent = Mockito.mock(AppComponent.class);
        when(DemoPlaylistsApp.getAppCompontent()).thenReturn(appComponent);
        model.getPlaylists(true);
    }

}
