package com.lijj.wyx.physical.contract.main;

import com.lijj.wyx.physical.base.presenter.AbstractPresenter;
import com.lijj.wyx.physical.base.view.AbstractView;

public interface LoginContract {

    interface View extends AbstractView {
        void showLoginSuccess();

        void showLoginError(String error);
    }

    interface Presenter extends AbstractPresenter<LoginContract.View> {
        void getLoginData(String username, String password);
    }

}
