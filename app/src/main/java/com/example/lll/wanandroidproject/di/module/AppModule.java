package com.example.lll.wanandroidproject.di.module;


import com.example.lll.wanandroidproject.app.WanAndroidApp;
import com.example.lll.wanandroidproject.core.DataManager;
import com.example.lll.wanandroidproject.core.db.DbHelper;
import com.example.lll.wanandroidproject.core.db.DbHelperImpl;
import com.example.lll.wanandroidproject.core.http.HttpHelper;
import com.example.lll.wanandroidproject.core.http.HttpHelperImpl;
import com.example.lll.wanandroidproject.core.prfs.PreferenceHelper;
import com.example.lll.wanandroidproject.core.prfs.PreferenceHelperImpl;

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


    @Provides
    @Singleton
    HttpHelper provideHttpHelper(HttpHelperImpl httpHelperImpl) {
        return httpHelperImpl;
    }

    @Provides
    @Singleton
    DbHelper provideDBHelper(DbHelperImpl realmHelper) {
        return realmHelper;
    }

    @Provides
    @Singleton
    PreferenceHelper providePreferencesHelper(PreferenceHelperImpl implPreferencesHelper) {
        return implPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, DbHelper dbhelper, PreferenceHelper preferencesHelper) {
        return new DataManager(httpHelper, dbhelper, preferencesHelper);
    }
}
