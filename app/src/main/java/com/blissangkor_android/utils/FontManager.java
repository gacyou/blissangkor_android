package com.blissangkor_android.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Gacyou on 2017/11/28.
 */

public class FontManager {

    public static final String ROOT = "fonts/",
            FONTAWESOME = ROOT + "fontawesome-webfont.ttf";

    public static Typeface getTypeface(Context context, String font) {
        return Typeface.createFromAsset(context.getAssets(), font);
    }

}
