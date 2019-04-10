package com.example.lll.wanandroidproject.contract.main;

import com.example.lll.wanandroidproject.base.presenter.AbstractPresenter;
import com.example.lll.wanandroidproject.base.view.AbstractView;

public interface SplashContract {

    interface View extends AbstractView {
        void jumpToMain();
    }

    interface Presenter extends AbstractPresenter<View> {

    }
}
