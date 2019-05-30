package com.lijj.wyx.physical.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.lijj.wyx.physical.R;
import com.lijj.wyx.physical.app.Constants;
import com.lijj.wyx.physical.base.activity.BaseActivity;
import com.lijj.wyx.physical.contract.main.RegisterContract;
import com.lijj.wyx.physical.presenter.main.RegisterPresenter;
import com.lijj.wyx.physical.utils.CommonUtils;
import com.lijj.wyx.physical.utils.StatusBarUtil;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;

public class RegisterActivity extends BaseActivity<RegisterPresenter>
        implements RegisterContract.View {

    @BindView(R.id.common_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.common_toolbar_title_tv)
    TextView mTitleTv;
    @BindView(R.id.register_account_edit)
    EditText mAccountEdit;
    @BindView(R.id.register_password_edit)
    EditText mPasswordEdit;
    @BindView(R.id.register_confirm_password_edit)
    EditText mConfirmPasswordEdit;
    @BindView(R.id.register_btn)
    Button mRegisterBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    protected void initToolbar() {
        StatusBarUtil.immersive(this);
        StatusBarUtil.setPaddingSmart(this, mToolbar);
        mToolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.register_bac));
        mTitleTv.setText(getString(R.string.register));
        mTitleTv.setTextColor(ContextCompat.getColor(this, R.color.white));
        mTitleTv.setTextSize(20);
        mToolbar.setNavigationOnClickListener(view -> onBackPressedSupport());
    }

    @Override
    protected void initEventAndData() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            mAccountEdit.requestFocus();
            inputMethodManager.showSoftInput(mAccountEdit, 0);
        }
        mPresenter.addRxBindingSubscribe(RxView.clicks(mRegisterBtn)
                .throttleFirst(Constants.CLICK_TIME_AREA, TimeUnit.MILLISECONDS)
                .filter(o -> mPresenter != null)
                .subscribe(o -> register())

        );
    }

    @Override
    public void showRegisterSuccess() {
        CommonUtils.showSnackMessage(this, getString(R.string.register_success));
        onBackPressedSupport();
    }


    private void register() {
        mPresenter.getRegisterData(mAccountEdit.getText().toString().trim(), mPasswordEdit.getText().toString().trim(), mConfirmPasswordEdit.getText().toString().trim());
    }
}
