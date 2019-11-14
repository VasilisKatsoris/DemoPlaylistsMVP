package demo.playlists.api.webcallsengine;

import demo.playlists.model.daos.PlaylistContentDao;
import demo.playlists.model.daos.PlaylistsDao;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCalls{
    String BASE_URL = "http://akazoo.com/services/Test/TestMobileService.svc/";

    @GET("playlists")
    Call<PlaylistsDao> getPlaylists();

    @GET("playlist?")
    Call<PlaylistContentDao> getPlaylistContent(@Query("playlistid") String cryptoSymbol);


}
