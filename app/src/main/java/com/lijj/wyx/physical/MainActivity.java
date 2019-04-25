package com.lijj.wyx.physical;

import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.lijj.wyx.physical.app.Constants;
import com.lijj.wyx.physical.base.activity.BaseActivity;
import com.lijj.wyx.physical.base.fragment.BaseFragment;
import com.lijj.wyx.physical.contract.main.MainContract;
import com.lijj.wyx.physical.presenter.main.MainPresenter;
import com.lijj.wyx.physical.utils.StatusBarUtil;
import com.xuexiang.xupdate.XUpdate;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.common_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.common_toolbar_title_tv)
    TextView mTitleTv;
    @BindView(R.id.main_floating_action_btn)
    FloatingActionButton mFloatingActionButton;
    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView mBottomNavigationView;
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;
    @BindView(R.id.fragment_group)
    FrameLayout mFrameGroup;

    private ArrayList<BaseFragment> mFragment;
    private TextView mUsTv;
    private int mLastFgIndex;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowTitleEnabled(false);
        mTitleTv.setText(getString(R.string.home_pager));
        StatusBarUtil.setStatusColor(getWindow(), ContextCompat.getColor(this, R.color.main_status_bar_blue), 1f);
        mToolbar.setNavigationOnClickListener(view -> onBackPressedSupport());
    }

    @Override
    protected void initEventAndData() {
//        //更新
//        XUpdate.newBuild(mActvitiy)
//                .updateUrl(Constants.UPDATE_URL)
//                .update();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragment = new ArrayList<>();
        if (savedInstanceState == null) {
            mPresenter.setNightModeState(false);
        }
    }
    private void initPager(boolean isRecreate,int position){
    }

    @Override
    public void showSwitchProject() {

    }

    @Override
    public void showSwitchNavigation() {

    }

    @Override
    public void showAutoLoginView() {

    }

    @Override
    public void showLogoutSuccess() {

    }
}
