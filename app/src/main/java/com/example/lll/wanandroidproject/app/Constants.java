package com.example.lll.wanandroidproject.app;

import android.graphics.Color;

import java.io.File;

public class Constants {

    static final String  BUGLY_ID = "7a95c21064";
    static final String DB_NAME = "aws_wan_android.db";
    public static final String MY_SHARED_PREFERENCE = "my_shared_preference";
    /**
     * Tab colors
     */
    public static final int[] TAB_COLORS = new int[]{
            Color.parseColor("#90C5F0"),
            Color.parseColor("#91CED5"),
            Color.parseColor("#F88F55"),
            Color.parseColor("#C0AFD0"),
            Color.parseColor("#E78F8F"),
            Color.parseColor("#67CCB7"),
            Color.parseColor("#F6BC7E")
    };
    public static final int MODE_PRIVATE = 0;

    /**
     * Path
     */
    public static final String PATH_DATA = WanAndroidApp.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + "/NetCache";
}
