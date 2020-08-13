package spotify.playlists.api.webcallsengine;

import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Authenticator;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import spotify.playlists.api.requests.GetPlaylistContentRequest;
import spotify.playlists.api.responses.events.PlaylistContentResponseEvent;
import spotify.playlists.api.responses.events.PlaylistImagesResponseEvent;
import spotify.playlists.api.responses.events.PlaylistsResponseEvent;
import spotify.playlists.api.responses.events.ResponseBodyResponseEvent;
import spotify.playlists.api.responses.interfaces.PlaylistContentResponseCallback;
import spotify.playlists.api.responses.interfaces.PlaylistImagesResponseCallback;
import spotify.playlists.api.responses.interfaces.PlaylistsResponseCallback;
import spotify.playlists.api.responses.interfaces.ResponseBodyResponseCallback;
import spotify.playlists.model.daos.PlaylistContentDao;
import spotify.playlists.model.daos.PlaylistImageDao;
import spotify.playlists.model.daos.PlaylistsDao;
import spotify.playlists.model.daos.SpotifyTokenDao;

@Singleton
public class RestRepository implements Repository {

    public static final String AUTHORIZATION = "Authorization";
    public static final String BASE_URL = "https://api.spotify.com/v1/";
    public static final String CLIENT_ID = "a2891897f0374a45897b08b34cfa16ca";
    public static final String CLIENT_SECRET = "8151b92acf1a472c828c4a5a8e3056b3";
    public static String ACCESS_TOKEN;

    private ApiCalls apiCalls;
    OkHttpClient okHttpClient;
    public class TokenAuthenticator implements Authenticator {

        @Override
        public Request authenticate(Route route, okhttp3.Response response) throws IOException {
            // Refresh your access_token using a synchronous api request
            Response<SpotifyTokenDao> tokenResponse = getSpotifyToken();
            if(tokenResponse!=null && tokenResponse.body()!=null) {
                ACCESS_TOKEN = tokenResponse.body().getAccessToken();
            }
            // Add new header to rejected request and retry it
            return response.request().newBuilder()
                    .header(AUTHORIZATION, getBearerToken())
                    .build();
        }
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    @Inject
    public RestRepository() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Interceptor authInterceptor = new Interceptor() {

            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder requestBuilder = request.newBuilder();
                if(ACCESS_TOKEN!=null) {
                    HttpUrl url = request.url().newBuilder()
                            .addQueryParameter(AUTHORIZATION, getBearerToken())
                            .build();
                    requestBuilder.url(url);
                }
                request = requestBuilder.build();
                return chain.proceed(request);
            }
        };

        okHttpClient = new OkHttpClient.Builder()
                .authenticator(new TokenAuthenticator())
                .addInterceptor(authInterceptor)
                .addInterceptor(interceptor).build();

        Gson localGson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(localGson))
                .build();
        apiCalls = retrofit.create(ApiCalls.class);
    }

    String getBearerToken(){
        return "Bearer "+ ACCESS_TOKEN;
    }

    String getBasicAuthenticationToken(){
        return "Basic "+ Base64.encodeToString((CLIENT_ID+":"+ CLIENT_SECRET).getBytes(), Base64.NO_WRAP);
    }

    public Response<SpotifyTokenDao> getSpotifyToken() {
        Map<String, String> body = new HashMap<>();
        body.put("grant_type","client_credentials");
        Call<SpotifyTokenDao> call = apiCalls.getSpotifyToken(getBasicAuthenticationToken(), body);
        try {
            return call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void getPlaylists(PlaylistsResponseCallback callback, String userId)  {
        Call<PlaylistsDao> call = apiCalls.getPlaylists(userId);
        call.enqueue(new RetrofitCallback<>(callback, new PlaylistsResponseEvent()));
    }

    @Override
    public void getPlaylistContent(PlaylistContentResponseCallback callback, GetPlaylistContentRequest getPlaylistContentRequest) {
        Call<PlaylistContentDao> call = apiCalls.getPlaylistContent(getPlaylistContentRequest.getPlaylistId());
        call.enqueue(new RetrofitCallback<>(callback, new PlaylistContentResponseEvent()));
    }

    public Call<List<PlaylistImageDao>> getCoverImageInfo(String userId, PlaylistImagesResponseCallback callback) {
        Call<List<PlaylistImageDao>> call = apiCalls.getPlaylistCoverImageInfo(userId);
        call.enqueue(new RetrofitCallback<>(callback, new PlaylistImagesResponseEvent()));
        return call;
    }

    public Call<ResponseBody> downloadImage(String filename, ResponseBodyResponseCallback callback){
        Call<ResponseBody> call = apiCalls.downloadImage(filename);
        call.enqueue(new RetrofitCallback<>(callback, new ResponseBodyResponseEvent()));
        return call;
    }

}
