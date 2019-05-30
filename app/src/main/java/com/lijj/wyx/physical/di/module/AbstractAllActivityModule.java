package com.lijj.wyx.physical.di.module;


import com.lijj.wyx.physical.MainActivity;
import com.lijj.wyx.physical.di.component.BaseActivityComponent;
import com.lijj.wyx.physical.ui.main.LoginActivity;
import com.lijj.wyx.physical.ui.main.RegisterActivity;
import com.lijj.wyx.physical.ui.main.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(subcomponents = {BaseActivityComponent.class})
public abstract class AbstractAllActivityModule {
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributesMainActivityInjector();

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity contributesSplashActivityInjector();

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity contributesLoginActivityInjector();

    @ContributesAndroidInjector(modules = RegisterActivityModule.class)
    abstract RegisterActivity contributesRegisterActivityInjector();
}
