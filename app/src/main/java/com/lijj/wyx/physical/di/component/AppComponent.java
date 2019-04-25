package com.lijj.wyx.physical.di.component;

import com.lijj.wyx.physical.app.WanAndroidApp;
import com.lijj.wyx.physical.core.DataManager;
import com.lijj.wyx.physical.di.module.AbstractAllActivityModule;
import com.lijj.wyx.physical.di.module.AppModule;
import com.lijj.wyx.physical.di.module.HttpModule;

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
