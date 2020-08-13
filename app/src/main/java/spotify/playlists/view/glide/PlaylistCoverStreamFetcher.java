package spotify.playlists.view.glide;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import spotify.playlists.SpotifyPlaylistsApp;
import spotify.playlists.api.webcallsengine.RestRepository;
import spotify.playlists.model.daos.PlaylistImageDao;

public final class PlaylistCoverStreamFetcher implements DataFetcher {
   private InputStream stream;
   private ResponseBody responseBody;
   private volatile Call imageFileCall;
   private final String mediaId;
   retrofit2.Call coverImagesCall;


   public void loadData(@NotNull Priority priority, @NotNull final DataFetcher.DataCallback callback) {

      RestRepository restRepository = SpotifyPlaylistsApp.appComponent.getRestRepository();
      coverImagesCall = restRepository.getCoverImageInfo(mediaId, coverInfoResponseEvent -> {

         String imageUrl = selectImageUrlFromList(coverInfoResponseEvent.getResponseDao());

         if (imageUrl != null) {
            imageFileCall = restRepository.downloadImage(imageUrl, imageFileResponseEvent -> {
               if (imageFileResponseEvent.validate()) {
                  responseBody = imageFileResponseEvent.getResponseDao();
                  stream = responseBody.byteStream();
                  callback.onDataReady(stream);
               }
               else{
                  callback.onLoadFailed(new Exception("failed to load image"));
               }
            });
         }
         else{
            callback.onLoadFailed(new Exception("image url not found"));
         }
      });


   }

   @Override
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

   @Override
   public void cancel() {
      if(coverImagesCall !=null){
         coverImagesCall.cancel();
      }
      if (imageFileCall != null) {
         imageFileCall.cancel();
      }

   }

   @NotNull
   @Override
   public Class getDataClass() {
      return InputStream.class;
   }

   @NotNull
   @Override
   public DataSource getDataSource() {
      return DataSource.REMOTE;
   }

   public PlaylistCoverStreamFetcher(@NotNull String url) {
      super();
      this.mediaId = url;
   }


   String selectImageUrlFromList(List<PlaylistImageDao> list){
      if(list == null){
         return null;
      }
      PlaylistImageDao selectedPlaylistImageDao = null;
      for (PlaylistImageDao playlistImageDao : list) {
         if (playlistImageDao.getHeight() > 60 && playlistImageDao.getHeight() < 600) {
            selectedPlaylistImageDao = playlistImageDao;
         }
      }
      if (selectedPlaylistImageDao == null && list.size() > 0) {
         selectedPlaylistImageDao = list.get(0);
      }
      return selectedPlaylistImageDao != null ? selectedPlaylistImageDao.getUrl() : null;
   }
}
