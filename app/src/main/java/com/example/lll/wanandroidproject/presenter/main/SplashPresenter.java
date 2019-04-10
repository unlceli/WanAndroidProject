package com.example.lll.wanandroidproject.presenter.main;

import com.example.lll.wanandroidproject.base.presenter.BasePresenter;
import com.example.lll.wanandroidproject.contract.main.SplashContract;
import com.example.lll.wanandroidproject.core.DataManager;

import javax.inject.Inject;

public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter {

    @Inject
    SplashPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void attachView(SplashContract.View view) {
        super.attachView(view);

    }
}
