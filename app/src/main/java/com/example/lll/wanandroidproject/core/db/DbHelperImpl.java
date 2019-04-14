package com.example.lll.wanandroidproject.core.db;

import com.example.lll.wanandroidproject.app.WanAndroidApp;

import javax.inject.Inject;

import json.chao.com.wanandroid.core.dao.DaoSession;

public class DbHelperImpl implements DbHelper {

    private DaoSession daoSession;
    @Inject
    DbHelperImpl() {
        daoSession = WanAndroidApp.getInstance().getDaoSession();
    }
}
