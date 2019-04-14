package com.example.lll.wanandroidproject.di.module;


import com.example.lll.wanandroidproject.di.component.BaseActivityComponent;
import com.example.lll.wanandroidproject.ui.main.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(subcomponents = {BaseActivityComponent.class})
public abstract class AbstractAllActivityModule {

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity contributesSplashActivityInjector();
}
