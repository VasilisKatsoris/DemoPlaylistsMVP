package demo.playlists;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import demo.playlists.api.webcallsengine.Repository;
import demo.playlists.api.webcallsengine.RestRepository;
import demo.playlists.dagger.AppComponent;
import demo.playlists.dagger.ModelComponent;
import demo.playlists.presenter.presenters.BasePresenter;
import demo.playlists.view.interfaces.BaseViewInterface;

import static org.junit.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * This is the base class for presenter testing
 * @param <T> the mvp presenter
 */
public abstract class BasePresenterTest<T extends BasePresenter, V extends BaseViewInterface>{

    /* the presenter to be tested */
    @InjectMocks
    T presenter;
    /* the mvp view **/
    V view;

    @Mock
    ModelComponent daggerModelComponent;
    @Mock
    AppComponent appComponent;
    @Mock
    Repository repository;
    @Mock
    RestRepository restRepository;

    /* the error response event factory */
    private ResponseEventMockFactory factory;

    @Before
    public void setUp() {
        mockStatic(DemoPlaylistsApp.class);
        appComponent = Mockito.mock(AppComponent.class);
        restRepository = Mockito.mock(RestRepository.class);
        when(DemoPlaylistsApp.getAppCompontent()).thenReturn(appComponent);
        when(appComponent.getRestRepository()).thenReturn(restRepository);
        daggerModelComponent = Mockito.mock(ModelComponent.class);
        factory = new ResponseEventMockFactory();
        repository = Mockito.mock(Repository.class);
        initMocks();
        initPresenter();

    }

    /* this is where you should init your mocks : Note @Mock annotation is not used on purpose due
       to inheritance */
    abstract void initMocks();
    /* this is where you should set up your presenter */
    abstract void initPresenter();

    ResponseEventMockFactory getFactory() {
        return factory;
    }

    @Test
    public void testAttachView() {
        presenter.onDestroy();
        assertTrue("View attached", presenter.getViewInterface() == null);
        assertTrue("model attached", presenter.getModel() == null);
    }

}