package com.example.lll.wanandroidproject.presenter.main;

import com.example.lll.wanandroidproject.base.presenter.BasePresenter;
import com.example.lll.wanandroidproject.contract.main.MainContract;
import com.example.lll.wanandroidproject.core.DataManager;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private DataManager mDataManager;


    @Override
    public void attachView(MainContract.View view) {
        super.attachView(view);

    }

    @Inject
    public MainPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void setCurrentPage(int page) {

    }

    @Override
    public void setNightModeState(boolean b) {

    }

    @Override
    public void logout() {

    }
}
