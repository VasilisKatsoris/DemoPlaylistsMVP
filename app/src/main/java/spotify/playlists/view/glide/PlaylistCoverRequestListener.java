package spotify.playlists.view.glide;

import android.graphics.drawable.Drawable;

import androidx.annotation.Nullable;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.DrawableCrossFadeTransition;

import org.jetbrains.annotations.NotNull;

public final class PlaylistCoverRequestListener implements RequestListener<Drawable> {
   private final PlaylistCoverRequestListener.Callback callback;

   public boolean onLoadFailed(@Nullable GlideException e, @NotNull Object model, @NotNull Target target, boolean isFirstResource) {
     if(callback!=null){
        callback.onFailure(e!=null ? e.getMessage():"");
     }
      return false;
   }

   public boolean onResourceReady(@NotNull Drawable resource, @NotNull Object model, @NotNull Target<Drawable> target, @NotNull DataSource dataSource, boolean isFirstResource) {
      if(callback!=null){
         callback.onSuccess(dataSource.toString());
      }
      target.onResourceReady(resource, new DrawableCrossFadeTransition(1000, isFirstResource));
      return true;
   }

   public PlaylistCoverRequestListener(@Nullable PlaylistCoverRequestListener.Callback callback) {
      this.callback = callback;
   }

   public interface Callback {
      void onFailure(@Nullable String var1);
      void onSuccess(@NotNull String var1);
   }
}