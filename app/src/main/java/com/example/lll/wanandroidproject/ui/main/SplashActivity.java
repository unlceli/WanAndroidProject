package com.example.lll.wanandroidproject.ui.main;

import com.airbnb.lottie.LottieAnimationView;
import com.example.lll.wanandroidproject.R;
import com.example.lll.wanandroidproject.app.WanAndroidApp;
import com.example.lll.wanandroidproject.base.activity.BaseActivity;
import com.example.lll.wanandroidproject.contract.main.SplashContract;
import com.example.lll.wanandroidproject.presenter.main.SplashPresenter;
import com.example.lll.wanandroidproject.utils.StatusBarUtil;

import butterknife.BindView;

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View {

    @BindView(R.id.one_animation)
    LottieAnimationView mOneAnimation;
    @BindView(R.id.two_animation)
    LottieAnimationView mTwoAnimation;
    @BindView(R.id.three_animation)
    LottieAnimationView mThreeAnimation;
    @BindView(R.id.four_animation)
    LottieAnimationView mFourAnimation;
    @BindView(R.id.five_animation)
    LottieAnimationView mFiveAnimation;
    @BindView(R.id.six_animation)
    LottieAnimationView mSixAnimation;
    @BindView(R.id.seven_animation)
    LottieAnimationView mSevenAnimation;
    @BindView(R.id.eight_animation)
    LottieAnimationView mEightAnimation;
    @BindView(R.id.nine_animation)
    LottieAnimationView mNineAnimation;
    @BindView(R.id.ten_animation)
    LottieAnimationView mTenAnimation;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initToolbar() {
        if (!WanAndroidApp.isFirstRun) {
            jumpToMain();
            return;
        }
        WanAndroidApp.isFirstRun = false;
        StatusBarUtil.immersive(this);
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void jumpToMain() {

    }
}
