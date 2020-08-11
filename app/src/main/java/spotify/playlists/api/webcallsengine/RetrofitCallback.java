package spotify.playlists.api.webcallsengine;

import androidx.annotation.Nullable;

import java.lang.ref.WeakReference;

import spotify.playlists.api.responses.events.BaseResponseEvent;
import spotify.playlists.api.responses.interfaces.BaseResponseCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RetrofitCallback<T extends BaseDAO, V extends BaseResponseEvent<T>>  implements Callback<T> {

    private V event;
    private WeakReference<BaseResponseCallback> responseCallbackWeakRef;

    RetrofitCallback(BaseResponseCallback responseCallback,  @Nullable V event) {
        this.event = event;
        this.responseCallbackWeakRef = new WeakReference<>(responseCallback);
    }

    private void postResponseEvent(){
        if(responseCallbackWeakRef!=null && responseCallbackWeakRef.get()!=null){
            responseCallbackWeakRef.get().onResponse(event);
            responseCallbackWeakRef.clear();
        }
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (event != null) {
            event.setResponseDao(response.body());
            event.setResponseHTTPStatusCode(response.code());
            postResponseEvent();
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (event != null) {
            event.setNetworkError(t.getMessage());
            event.setNetworkErrorThrowable(t);
            postResponseEvent();
        }
    }
 }