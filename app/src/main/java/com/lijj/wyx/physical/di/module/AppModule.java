package com.lijj.wyx.physical.di.module;


import com.lijj.wyx.physical.app.WanAndroidApp;
import com.lijj.wyx.physical.core.DataManager;
import com.lijj.wyx.physical.core.db.DbHelper;
import com.lijj.wyx.physical.core.db.DbHelperImpl;
import com.lijj.wyx.physical.core.http.HttpHelper;
import com.lijj.wyx.physical.core.http.HttpHelperImpl;
import com.lijj.wyx.physical.core.prfs.PreferenceHelper;
import com.lijj.wyx.physical.core.prfs.PreferenceHelperImpl;

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
