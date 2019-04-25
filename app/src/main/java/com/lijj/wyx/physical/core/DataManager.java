package com.lijj.wyx.physical.core;

import com.lijj.wyx.physical.core.db.DbHelper;
import com.lijj.wyx.physical.core.http.HttpHelper;
import com.lijj.wyx.physical.core.prfs.PreferenceHelper;

public class DataManager implements HttpHelper, DbHelper, PreferenceHelper{

    private HttpHelper mHttpHelper;
    private DbHelper mDbHelper;
    private PreferenceHelper mPreferenceHelper;

    public DataManager(HttpHelper httpHelper, DbHelper dbHelper, PreferenceHelper preferencesHelper) {
        mHttpHelper = httpHelper;
        mDbHelper = dbHelper;
        mPreferenceHelper = preferencesHelper;
    }

    @Override
    public void setLoginAccount(String account) {

    }

    @Override
    public void setLoginPassword(String password) {

    }

    @Override
    public String getLoginAccount() {
        return null;
    }

    @Override
    public String getLoginPassword() {
        return null;
    }

    @Override
    public void setLoginStatus(boolean isLogin) {

    }

    @Override
    public boolean getLoginStatus() {
        return false;
    }

    @Override
    public void setCookie(String domain, String cookie) {

    }

    @Override
    public String getCookie(String domain) {
        return null;
    }

    @Override
    public void setCurrentPage(int position) {

    }

    @Override
    public int getCurrentPage() {
        return 0;
    }

    @Override
    public void setProjectCurrentPage(int position) {

    }

    @Override
    public int getProjectCurrentPage() {
        return 0;
    }

    @Override
    public boolean getAutoCacheState() {
        return false;
    }

    @Override
    public boolean getNoImageState() {
        return false;
    }

    @Override
    public boolean getNightModeState() {
        return false;
    }

    @Override
    public void setNightModeState(boolean b) {

    }

    @Override
    public void setNoImageState(boolean b) {

    }

    @Override
    public void setAutoCacheState(boolean b) {

    }
}
