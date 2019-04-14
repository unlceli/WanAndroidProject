package com.example.lll.wanandroidproject.ui.main;

import com.example.lll.wanandroidproject.R;
import com.example.lll.wanandroidproject.base.activity.BaseActivity;
import com.example.lll.wanandroidproject.contract.main.SplashContract;
import com.example.lll.wanandroidproject.presenter.main.SplashPresenter;

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void jumpToMain() {

    }
}
