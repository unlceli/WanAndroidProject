package com.lijj.wyx.physical.presenter.main;

import com.lijj.wyx.physical.base.presenter.BasePresenter;
import com.lijj.wyx.physical.contract.main.SplashContract;
import com.lijj.wyx.physical.core.DataManager;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter {

    @Inject
    SplashPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void attachView(SplashContract.View view) {
        super.attachView(view);
        long splashTime = 2000;
        addSubscribe(Observable.timer(splashTime, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> view.jumpToMain()));
    }
}
