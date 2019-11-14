package demo.playlists.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.ColorInt;

public class ViewUtils {
    public static boolean isOrientationLandscape(Context context){
        return context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    public static int dpToPx(float dp) {
        return Math.round(dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int applyAlphaToColor(@ColorInt int color, float alphaFactor) {
        int alpha = Math.round(Color.alpha(color) * alphaFactor);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return Color.argb(alpha, red, green, blue);
    }
}
