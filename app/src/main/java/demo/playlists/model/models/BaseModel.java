package demo.playlists.model.models;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import demo.playlists.api.webcallsengine.Repository;
import demo.playlists.api.webcallsengine.RestRepository;
import demo.playlists.presenter.interfaces.BasePresenterInterface;

public class BaseModel<PresenterInterface extends BasePresenterInterface> {

    Repository repository;
    WeakReference<PresenterInterface> presenterInterface;

    @Inject
    public BaseModel(RestRepository restRepository) {
        this.repository = restRepository;
    }

    public void setPresenterInterface(PresenterInterface presenterInterface){
        this.presenterInterface = new WeakReference<>(presenterInterface);
    }

    public PresenterInterface getPresenterInterface() {
        return presenterInterface.get();
    }

    public Repository getRepository(){
        return repository;
    }

    public void onDestroy(){
        presenterInterface.clear();
    }
}
