package com.lijj.wyx.physical.contract.main;

import com.lijj.wyx.physical.base.presenter.AbstractPresenter;
import com.lijj.wyx.physical.base.view.AbstractView;

public interface RegisterContract {

    interface View extends AbstractView {
        void showRegisterSuccess();
    }

    interface Presenter extends AbstractPresenter<View> {
        void getRegisterData(String username, String password, String rePassword);
    }
}
