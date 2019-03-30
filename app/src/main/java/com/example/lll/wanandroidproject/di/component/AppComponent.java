package com.example.lll.wanandroidproject.di.component;

import com.example.lll.wanandroidproject.app.WanAndroidApp;
import com.example.lll.wanandroidproject.di.module.AppModule;
import com.example.lll.wanandroidproject.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    /**
     * 注入WanAndroidApp实例
     *
     * @param wanAndroidApp
     */
    void inject(WanAndroidApp wanAndroidApp);

    /**
     * 提供 app的Context
     *
     * @return
     */
    WanAndroidApp getContext();



}
