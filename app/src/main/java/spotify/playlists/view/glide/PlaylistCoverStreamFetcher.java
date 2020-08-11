package spotify.playlists.view.glide;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import spotify.playlists.SpotifyPlaylistsApp;
import spotify.playlists.api.webcallsengine.RestRepository;
import spotify.playlists.model.daos.PlaylistImageDao;
import okhttp3.Call;
import okhttp3.ResponseBody;
import retrofit2.Response;

public final class PlaylistCoverStreamFetcher implements DataFetcher {
   private InputStream stream;
   private ResponseBody responseBody;
   private volatile Call imageCall;
   private final String mediaId;
   retrofit2.Call mediaCall;

   public void loadData(@NotNull Priority priority, @NotNull final DataFetcher.DataCallback callback) {

      RestRepository restRepository = SpotifyPlaylistsApp.appComponent.getRestRepository();
      retrofit2.Response<List<PlaylistImageDao>> coverInfo = restRepository.getCoverImageInfo(mediaId);
      PlaylistImageDao selectedPlaylistImageDao = null;
      if(coverInfo!=null && coverInfo.body()!=null){
         List<PlaylistImageDao> list = coverInfo.body();
         for(PlaylistImageDao playlistImageDao :list){
            if(playlistImageDao.getHeight()>60 && playlistImageDao.getHeight()<600){
               selectedPlaylistImageDao = playlistImageDao;
            }
         }
         if(selectedPlaylistImageDao == null){
            selectedPlaylistImageDao = list.get(0);
         }
         String imageUrl = selectedPlaylistImageDao !=null ? selectedPlaylistImageDao.getUrl() : null;
         if(imageUrl!=null) {
            Response<ResponseBody> imageResponse = restRepository.downloadImage(imageUrl);
            if (imageResponse != null && imageResponse.body() != null) {
               callback.onDataReady(imageResponse.body().byteStream());
               return;
            }
         }
      }

      callback.onLoadFailed(new Exception("did not find cover info"));

   }

   public void cleanup() {
      if (stream != null) {
         try {
            stream.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }

      if (responseBody != null) {
         responseBody.close();
      }

   }

   public void cancel() {
      if(mediaCall!=null){
         mediaCall.cancel();
      }
      if (imageCall != null) {
         imageCall.cancel();
      }

   }

   @NotNull
   public Class getDataClass() {
      return InputStream.class;
   }

   @NotNull
   public DataSource getDataSource() {
      return DataSource.REMOTE;
   }

   public PlaylistCoverStreamFetcher(@NotNull String url) {
      super();
      this.mediaId = url;
   }
}
