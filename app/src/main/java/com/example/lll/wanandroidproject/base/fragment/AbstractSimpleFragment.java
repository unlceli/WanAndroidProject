package com.example.lll.wanandroidproject.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lll.wanandroidproject.R;
import com.example.lll.wanandroidproject.app.Constants;
import com.example.lll.wanandroidproject.app.WanAndroidApp;
import com.example.lll.wanandroidproject.utils.CommonUtils;
import com.squareup.leakcanary.RefWatcher;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public abstract class AbstractSimpleFragment extends SupportFragment {
    private Unbinder unbinder;
    private long clickTime;
    public boolean isInnerFragment;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null && unbinder != Unbinder.EMPTY) {
            unbinder.unbind();
            unbinder = null;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = WanAndroidApp.getRefWatcher(_mActivity);
        refWatcher.watch(this);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initEventAndData();
    }

    @Override
    public boolean onBackPressedSupport() {
        if (getChildFragmentManager().getBackStackEntryCount() > 1) {
            popChild();
        } else {
            if (isInnerFragment) {
                _mActivity.finish();
                return true;
            }
        }
        long currentTime = System.currentTimeMillis();
        if ((currentTime - clickTime) > Constants.DOUBLE_INTERVAL_TIME) {
            CommonUtils.showSnackMessage(_mActivity, getString(R.string.double_click_exit_tint));
            clickTime = System.currentTimeMillis();
        } else {
            _mActivity.finish();
        }
        return true;
    }

    /**
     * 有些初始化必须在onCreateView中，例如setAdapter,
     * 否则，会弹出 No adapter attached; skipping layout
     */
    protected void initView() {

    }

    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据
     */
    protected abstract void initEventAndData();
}
