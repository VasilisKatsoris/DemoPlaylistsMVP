package spotify.playlists.util;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public class AnimationUtils {

    public static Animation getRightToLeftAnimation(int relativeTo){
        return new TranslateAnimation(relativeTo, 1, relativeTo, 0, relativeTo, 0, relativeTo, 0);
    }

    public static class AnimationInterface implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

}
