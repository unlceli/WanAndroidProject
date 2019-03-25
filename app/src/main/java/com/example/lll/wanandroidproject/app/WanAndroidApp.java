package com.example.lll.wanandroidproject.app;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

public class WanAndroidApp extends Application  {


    private static WanAndroidApp instance;

    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance =this;
    }

    public static synchronized WanAndroidApp getInstance(){
        return instance;
    }
}
