package spotify.playlists.view.glide;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PlaylistCoverStreamLoader implements ModelLoader {

   @Nullable
   public ModelLoader.LoadData buildLoadData(@NotNull PlaylistCoverModel displayImage, int width, int height, @NotNull Options options) {
      String url = displayImage.getMediaId();
      return new LoadData((Key)(new ObjectKey(url)), (DataFetcher)(new PlaylistCoverStreamFetcher(url)));
   }

   // $FF: synthetic method
   // $FF: bridge method
   public LoadData buildLoadData(Object var1, int var2, int var3, Options var4) {
      return this.buildLoadData((PlaylistCoverModel)var1, var2, var3, var4);
   }

   public boolean handles(@NotNull PlaylistCoverModel displayImage) {
      return true;
   }

   public boolean handles(Object var1) {
      return this.handles((PlaylistCoverModel)var1);
   }

   public PlaylistCoverStreamLoader() {
      super();
   }

   public static final class Factory implements ModelLoaderFactory {

      @NotNull
      public ModelLoader build(@NotNull MultiModelLoaderFactory multiFactory) {
         return (ModelLoader)(new PlaylistCoverStreamLoader());
      }

      public void teardown() {
      }

      public Factory() {
         super();
      }
   }
}
