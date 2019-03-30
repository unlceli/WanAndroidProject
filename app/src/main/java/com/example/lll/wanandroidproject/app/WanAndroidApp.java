package com.example.lll.wanandroidproject.app;

import android.app.Activity;
import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.example.lll.wanandroidproject.di.component.AppComponent;
import com.example.lll.wanandroidproject.di.component.DaggerAppComponent;
import com.example.lll.wanandroidproject.di.module.AppModule;
import com.example.lll.wanandroidproject.di.module.HttpModule;
import com.squareup.leakcanary.RefWatcher;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class WanAndroidApp extends Application implements HasActivityInjector {


    @Inject
    DispatchingAndroidInjector<Activity> mAndroidInjector;
    private static WanAndroidApp instance;
    private RefWatcher refWatcher;
    public static boolean isFirstRun = true;
    private static volatile AppComponent appComponent;

    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance =this;

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .httpModule(new HttpModule())
                .build();

    }

    public static synchronized WanAndroidApp getInstance(){
        return instance;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mAndroidInjector;
    }
}
