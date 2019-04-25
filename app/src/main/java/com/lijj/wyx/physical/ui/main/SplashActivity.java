package com.lijj.wyx.physical.ui.main;

import android.content.Intent;

import com.airbnb.lottie.LottieAnimationView;
import com.lijj.wyx.physical.MainActivity;
import com.lijj.wyx.physical.R;
import com.lijj.wyx.physical.app.WanAndroidApp;
import com.lijj.wyx.physical.base.activity.BaseActivity;
import com.lijj.wyx.physical.contract.main.SplashContract;
import com.lijj.wyx.physical.presenter.main.SplashPresenter;
import com.lijj.wyx.physical.utils.StatusBarUtil;

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
        startAnimation(mOneAnimation, "W.json");
        startAnimation(mTwoAnimation, "A.json");
        startAnimation(mThreeAnimation, "N.json");
        startAnimation(mFourAnimation, "A.json");
        startAnimation(mFiveAnimation, "N.json");
        startAnimation(mSixAnimation, "D.json");
        startAnimation(mSevenAnimation, "R.json");
        startAnimation(mEightAnimation, "I.json");
        startAnimation(mNineAnimation, "O.json");
        startAnimation(mTenAnimation, "D.json");
    }

    @Override
    public void jumpToMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }


    private void cancelAnimation() {
        cancelAnimation(mOneAnimation);
        cancelAnimation(mTwoAnimation);
        cancelAnimation(mThreeAnimation);
        cancelAnimation(mFourAnimation);
        cancelAnimation(mFiveAnimation);
        cancelAnimation(mSixAnimation);
        cancelAnimation(mSevenAnimation);
        cancelAnimation(mEightAnimation);

        cancelAnimation(mNineAnimation);
        cancelAnimation(mTenAnimation);
    }


    private void startAnimation(LottieAnimationView mLottieAnimationView, String animationName) {
        mLottieAnimationView.setAnimation(animationName);
        mLottieAnimationView.playAnimation();
    }

    private void cancelAnimation(LottieAnimationView mLottieAnimationView) {
        if (mLottieAnimationView != null) {
            mLottieAnimationView.cancelAnimation();
        }
    }
}
