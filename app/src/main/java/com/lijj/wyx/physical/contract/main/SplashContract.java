package com.lijj.wyx.physical.contract.main;

import com.lijj.wyx.physical.base.presenter.AbstractPresenter;
import com.lijj.wyx.physical.base.view.AbstractView;

public interface SplashContract {

    interface View extends AbstractView {
        void jumpToMain();
    }

    interface Presenter extends AbstractPresenter<View> {

    }
}
