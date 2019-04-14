package com.example.lll.wanandroidproject.di.component;

import com.example.lll.wanandroidproject.app.WanAndroidApp;
import com.example.lll.wanandroidproject.core.DataManager;
import com.example.lll.wanandroidproject.di.module.AbstractAllActivityModule;
import com.example.lll.wanandroidproject.di.module.AppModule;
import com.example.lll.wanandroidproject.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AbstractAllActivityModule.class,
        AppModule.class, HttpModule.class})
public interface AppComponent {

    /**
     * 注入WanAndroidApp实例
     *
     * @param wanAndroidApp
     */
    void inject(WanAndroidApp wanAndroidApp);

    /**
     * 提供App的Context
     *
     * @return GeeksApp context
     */
    WanAndroidApp getContext();

    /**
     * 数据中心
     *
     * @return DataManager
     */
    DataManager getDataManager();
}
