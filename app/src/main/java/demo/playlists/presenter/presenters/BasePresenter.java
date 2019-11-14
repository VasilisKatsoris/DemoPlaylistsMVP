package demo.playlists.presenter.presenters;

import android.support.annotation.StringRes;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import demo.playlists.model.models.BaseModel;
import demo.playlists.presenter.interfaces.BasePresenterInterface;
import demo.playlists.view.interfaces.BaseViewInterface;

public class BasePresenter<ViewInteface extends BaseViewInterface, Model extends BaseModel> implements BasePresenterInterface {
    public WeakReference<ViewInteface> viewInterface;
    public Model model;

    @Inject
    public BasePresenter(ViewInteface viewInterface, Model model) {
        this.viewInterface = new WeakReference<>(viewInterface);
        this.model = model;
        this.model.setPresenterInterface(this);
    }


    ViewInteface getViewInterface(){
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
