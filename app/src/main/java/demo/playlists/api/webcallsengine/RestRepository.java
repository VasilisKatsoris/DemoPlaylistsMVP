package demo.playlists.api.webcallsengine;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Inject;
import javax.inject.Singleton;

import demo.playlists.api.requests.GetPlaylistContentRequest;
import demo.playlists.api.responses.events.PlaylistContentResponseEvent;
import demo.playlists.api.responses.events.PlaylistsResponseEvent;
import demo.playlists.api.responses.interfaces.PlaylistContentResponseCallback;
import demo.playlists.api.responses.interfaces.PlaylistsResponseCallback;
import demo.playlists.model.daos.PlaylistContentDao;
import demo.playlists.model.daos.PlaylistsDao;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class RestRepository implements Repository {

    private ApiCalls apiCalls;

    @Inject
    public RestRepository() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Gson localGson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiCalls.BASE_URL).
                client(new OkHttpClient.Builder()
                        .addInterceptor(interceptor).build())
                .addConverterFactory(GsonConverterFactory.create(localGson))
                .build();
        apiCalls = retrofit.create(ApiCalls.class);
    }

    @Override
    public void getPlaylists(PlaylistsResponseCallback callback)  {
        Call<PlaylistsDao> call = apiCalls.getPlaylists();
        call.enqueue(new RetrofitCallback<>(callback, new PlaylistsResponseEvent()));
    }

    @Override
    public void getPlaylistContent(PlaylistContentResponseCallback callback, GetPlaylistContentRequest getPlaylistContentRequest) {
        Call<PlaylistContentDao> call = apiCalls.getPlaylistContent(getPlaylistContentRequest.getPlaylistId());
        call.enqueue(new RetrofitCallback<>(callback, new PlaylistContentResponseEvent()));
    }


}
