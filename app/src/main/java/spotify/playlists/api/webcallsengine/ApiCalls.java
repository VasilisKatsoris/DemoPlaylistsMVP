package spotify.playlists.api.webcallsengine;

import java.util.List;
import java.util.Map;

import spotify.playlists.model.daos.PlaylistImageDao;
import spotify.playlists.model.daos.PlaylistContentDao;
import spotify.playlists.model.daos.PlaylistsDao;
import spotify.playlists.model.daos.SpotifyTokenDao;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface ApiCalls{

    @GET("users/{user_id}/playlists")
    Call<PlaylistsDao> getPlaylists(@Path("user_id") String userId);

    @GET("playlists/{playlist_id}/tracks")
    Call<PlaylistContentDao> getPlaylistContent(@Path("playlist_id") String playlistId);

    @POST("https://accounts.spotify.com/api/token")
    @FormUrlEncoded
    Call<SpotifyTokenDao> getSpotifyToken(@Header("Authorization") String auth,  @FieldMap Map<String, String> body);

    @GET("playlists/{playlist_id}/images")
    Call<List<PlaylistImageDao>> getPlaylistCoverImageInfo(@Path("playlist_id") String playlistId);

    @GET
    @Streaming
    Call<ResponseBody> downloadImage(@Url String url);
}
