package com.lijj.wyx.physical.core.db;

import com.lijj.wyx.physical.app.WanAndroidApp;

import javax.inject.Inject;

import json.chao.com.wanandroid.core.dao.DaoSession;

public class DbHelperImpl implements DbHelper {

    private DaoSession daoSession;
    @Inject
    DbHelperImpl() {
        daoSession = WanAndroidApp.getInstance().getDaoSession();
    }
}
