package spotify.playlists.view.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import spotify.playlists.dagger.BasePresenterComponent;
import spotify.playlists.dagger.BasePresenterIntefaceModule;
import spotify.playlists.dagger.DaggerBasePresenterComponent;
import spotify.playlists.presenter.presenters.BasePresenter;
import spotify.playlists.presenter.presenters.interfaces.BaseViewInterface;

/**
 * PresenterFragment is made to make the injection code simpler.
 * @param <Presenter> class of the presenter this fragment uses
 *
 */
public abstract class PresenterFragment<Presenter extends BasePresenter> extends Fragment implements BaseViewInterface {

    private Presenter presenter;

    Presenter getPresenter(){
        return presenter;
    }

    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //instead of doing this in every fragment across the app we do it once here.
        //developer cannot forget to implement injection because the abstract methods
        //will have to be implemented. They are autocompleted by IDE
        //making the injection process easier and impossible to forget or misplace.
        BasePresenterComponent injector = DaggerBasePresenterComponent.builder()
                .basePresenterIntefaceModule(new BasePresenterIntefaceModule(this))
                .build();
        performPresenterInjection(injector);

    }

    /**
     *
     * @param injector just call injector.inject...(); to inject the presenter that
     *                 this fragment needs. After that onPresenterInjection will be called
     */
    public abstract void performPresenterInjection(BasePresenterComponent injector);

    /**
     * this method must always be annotated with inject when overriden
     * and the body must always be setPresenter(presenter);
     */
    public abstract void onPresenterInjection(Presenter presenter);
}
