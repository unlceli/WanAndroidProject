package com.lijj.wyx.physical.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lijj.wyx.physical.component.ActivityCollector;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

public abstract class AbstractSimpleActvitiy extends SupportActivity {
    private Unbinder unbinder;
    protected AbstractSimpleActvitiy mActvitiy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        mActvitiy = this;
        ActivityCollector.getInstance().addActivity(this);
        onViewCreated();
        initToolbar();
        initEventAndData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.getInstance().removeActivity(this);
        if (unbinder != null && unbinder != Unbinder.EMPTY) {
            unbinder.unbind();
            unbinder = null;
        }
    }


    /**
     * 在initEventAndData()之前执行
     */
    protected abstract void onViewCreated();

    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化ToolBar
     */
    protected abstract void initToolbar();

    /**
     * 初始化数据
     */
    protected abstract void initEventAndData();
}
