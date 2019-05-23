package com.lijj.wyx.physical.ui.main;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.jakewharton.rxbinding2.view.RxView;
import com.lijj.wyx.physical.R;
import com.lijj.wyx.physical.app.Constants;
import com.lijj.wyx.physical.base.activity.BaseActivity;
import com.lijj.wyx.physical.contract.main.LoginContract;
import com.lijj.wyx.physical.presenter.main.LoginPresenter;
import com.lijj.wyx.physical.utils.CommonUtils;
import com.lijj.wyx.physical.utils.StatusBarUtil;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {


    @BindView(R.id.login_group)
    RelativeLayout mLoginGroup;
    @BindView(R.id.login_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.login_account_edit)
    EditText mAccountEdit;
    @BindView(R.id.login_password_edit)
    EditText mPasswordEdit;
    @BindView(R.id.login_btn)
    Button mLoginBtn;
    @BindView(R.id.login_register_btn)
    Button mRegisterBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.login_register_btn})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_register_btn:
                startRegisterPager();
                break;
        }
    }

    private void startRegisterPager() {
        ActivityOptions options = ActivityOptions.makeScaleUpAnimation(mRegisterBtn,
                mRegisterBtn.getWidth() / 2, mRegisterBtn.getHeight() / 2,
                0, 0);
        startActivity(new Intent(this, RegisterActivity.class), options.toBundle());
    }

    @Override
    protected void initToolbar() {
        StatusBarUtil.immersive(this);
        StatusBarUtil.setPaddingSmart(this, mToolbar);
        mToolbar.setNavigationOnClickListener(view -> {
            onBackPressedSupport();
        });
    }

    @Override
    protected void initEventAndData() {
        subscribeLoginClickEvent();
    }

    @Override
    public void showLoginSuccess() {
        CommonUtils.showMessage(this, getString(R.string.login_success));
        onBackPressedSupport();
    }

    @Override
    public void showLoginError(String error) {
        showSnackBar(error);
    }

    /**
     * throttleFirst 防止按钮重复点击
     */
    private void subscribeLoginClickEvent() {

        mPresenter.addRxBindingSubscribe(RxView.clicks(mLoginBtn)
                .throttleFirst(Constants.CLICK_TIME_AREA, TimeUnit.MILLISECONDS)
                .filter(o -> mPresenter != null)
                .subscribe(o -> mPresenter.getLoginData(
                        mAccountEdit.getText().toString().trim(),
                        mPasswordEdit.getText().toString().trim()
                ))


        );

    }
}
