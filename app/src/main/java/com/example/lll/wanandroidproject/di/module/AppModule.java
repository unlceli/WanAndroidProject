package com.example.lll.wanandroidproject.di.module;


import com.example.lll.wanandroidproject.app.WanAndroidApp;

import dagger.Module;

@Module
public class AppModule {
    private final WanAndroidApp androidApp;

    public AppModule(WanAndroidApp androidApp) {
        this.androidApp = androidApp;
    }
}
