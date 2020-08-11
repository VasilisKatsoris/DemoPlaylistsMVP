package spotify.playlists.presenter.presenters;


import androidx.annotation.StringRes;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import spotify.playlists.model.models.BaseModel;
import spotify.playlists.model.models.interfaces.BasePresenterInterface;
import spotify.playlists.presenter.presenters.interfaces.BaseViewInterface;

public class BasePresenter<ViewInterface extends BaseViewInterface, Model extends BaseModel> implements BasePresenterInterface {
    public WeakReference<ViewInterface> viewInterface;
    public Model model;

    @Inject
    public BasePresenter(ViewInterface viewInterface, Model model) {
        this.viewInterface = new WeakReference<>(viewInterface);
        this.model = model;
        this.model.setPresenterInterface(this);
    }


    public ViewInterface getViewInterface(){
        return viewInterface.get();
    }

    public Model getModel(){
        return model;
    }

    public void onDestroy(){
        viewInterface.clear();
        if(getModel()!=null) {
            getModel().onDestroy();
        }
    }

    public String getString(@StringRes int stringResId){
        return getViewInterface().getString(stringResId);
    }
}
