package spotify.playlists.view.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;


import org.jetbrains.annotations.NotNull;

import java.io.InputStream;

@GlideModule
public final class PlaylistCoverGlideModule extends AppGlideModule {
   public void registerComponents(@NotNull Context context, @NotNull Glide glide, @NotNull Registry registry) {
      super.registerComponents(context, glide, registry);
      registry.append(PlaylistCoverModel.class, InputStream.class, new PlaylistCoverStreamLoader.Factory());
   }

   public boolean isManifestParsingEnabled() {
      return false;
   }
}
