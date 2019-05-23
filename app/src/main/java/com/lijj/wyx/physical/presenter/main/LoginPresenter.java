package com.lijj.wyx.physical.presenter.main;

import android.text.TextUtils;
import android.view.TextureView;

import com.lijj.wyx.physical.R;
import com.lijj.wyx.physical.app.WanAndroidApp;
import com.lijj.wyx.physical.base.presenter.BasePresenter;
import com.lijj.wyx.physical.component.RxBus;
import com.lijj.wyx.physical.contract.main.LoginContract;
import com.lijj.wyx.physical.core.DataManager;
import com.lijj.wyx.physical.core.bean.main.login.LoginData;
import com.lijj.wyx.physical.core.event.LoginEvent;
import com.lijj.wyx.physical.utils.RxUtils;
import com.lijj.wyx.physical.widget.BaseObserver;

import org.w3c.dom.Text;

import javax.inject.Inject;

public class LoginPresenter extends BasePresenter<LoginContract.View>
        implements LoginContract.Presenter {


    private DataManager mDataManager;

    @Inject
    public LoginPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void getLoginData(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            mView.showSnackBar(WanAndroidApp.getInstance().getString(R.string.account_password_null_tint));
            return;
        }
        addSubscribe(mDataManager.getLoginData(username, password)
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleResult())
                .subscribeWith(new BaseObserver<LoginData>(mView,
                        WanAndroidApp.getInstance().getString(R.string.login_fail)) {
                    @Override
                    public void onNext(LoginData loginData) {
                        setLoginAccount(loginData.getUsername());
                        setLoginPassword(loginData.getPassword());
                        setLoginStatus(true);
                        RxBus.getDefault().post(new LoginEvent(true));
                        mView.showLoginSuccess();
                    }
                }));


        addSubscribe(mDataManager.getLoginData(username, password)
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleResult())
                .subscribeWith(new BaseObserver<LoginData>(mView, WanAndroidApp.getInstance().getString(R.string.login_fail)) {
                    @Override
                    public void onNext(LoginData loginData) {
                        setLoginAccount(loginData.getUsername());
                        setLoginPassword(loginData.getPassword());
                        setLoginStatus(true);
                        RxBus.getDefault().post(new LoginEvent(true));
                        mView.showLoginSuccess();
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        mView.showLoginError(e.getMessage());
                    }
                })


        );
    }
}
