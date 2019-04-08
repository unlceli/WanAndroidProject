package com.example.lll.wanandroidproject.di.module;


import com.example.lll.wanandroidproject.app.WanAndroidApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final WanAndroidApp application;

    public AppModule(WanAndroidApp androidApp) {
        this.application = androidApp;
    }

    @Provides
    @Singleton
    WanAndroidApp provideApplicationContext() {
        return application;
    }

}
