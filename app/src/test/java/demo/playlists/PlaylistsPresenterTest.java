package demo.playlists;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import demo.playlists.model.interfaces.PlaylistsModelInterface;
import demo.playlists.presenter.presenters.PlaylistsPresenter;
import demo.playlists.view.interfaces.PlaylistsViewInterface;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DemoPlaylistsApp.class)
public class PlaylistsPresenterTest extends BasePresenterTest<PlaylistsPresenter, PlaylistsViewInterface>{

    @Mock
    PlaylistsViewInterface playlistsViewInterface;
    @Mock
    PlaylistsModelInterface playlistsModelInterface;


    PlaylistsPresenter playlistsPresenter;

    @Override
    void initMocks() {
        playlistsViewInterface = Mockito.mock(PlaylistsViewInterface.class);
    }

    @Override
    void initPresenter() {
        presenter = new PlaylistsPresenter(playlistsViewInterface);
    }

    @Test
    public void testlala(){
        playlistsPresenter.getPlaylists(true);
    }
}
