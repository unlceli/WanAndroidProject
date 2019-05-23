package com.lijj.wyx.physical.presenter.main;

import android.text.TextUtils;

import com.lijj.wyx.physical.R;
import com.lijj.wyx.physical.app.Constants;
import com.lijj.wyx.physical.app.WanAndroidApp;
import com.lijj.wyx.physical.base.presenter.BasePresenter;
import com.lijj.wyx.physical.contract.main.RegisterContract;
import com.lijj.wyx.physical.core.DataManager;
import com.lijj.wyx.physical.core.bean.main.login.LoginData;
import com.lijj.wyx.physical.utils.RxUtils;
import com.lijj.wyx.physical.widget.BaseObserver;

import javax.inject.Inject;

public class RegisterPresenter extends BasePresenter<RegisterContract.View> implements RegisterContract.Presenter {


    private DataManager mDataManager;

    @Inject
    public RegisterPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void getRegisterData(String username, String password, String rePassword) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(rePassword)) {
            mView.showSnackBar(WanAndroidApp.getInstance().getString(R.string.account_password_null_tint));
            return;
        }
        if (!password.equals(rePassword)) {
            mView.showSnackBar(WanAndroidApp.getInstance().getString(R.string.register_fail));
            return;
        }
        addSubscribe(mDataManager.getRegisterData(username, password, rePassword)
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleResult())
                .filter(loginData -> !TextUtils.isEmpty(username) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(rePassword))
                .subscribeWith(new BaseObserver<LoginData>(mView, WanAndroidApp.getInstance().getString(R.string.register_fail)) {
                    @Override
                    public void onNext(LoginData loginData) {
                        mView.showRegisterSuccess();
                    }
                })

        );
    }
}
