package com.lijj.wyx.physical.presenter.mainpager;

import com.lijj.wyx.physical.base.presenter.BasePresenter;
import com.lijj.wyx.physical.contract.mainpager.MainPagerContract;
import com.lijj.wyx.physical.core.DataManager;
import com.lijj.wyx.physical.core.bean.BaseResponse;
import com.lijj.wyx.physical.core.bean.main.collect.FeedArticleData;
import com.lijj.wyx.physical.core.bean.main.login.LoginData;


import javax.inject.Inject;

import io.reactivex.Observable;

public class MainPagerPresenter extends BasePresenter<MainPagerContract.View> implements MainPagerContract.Presenter {

    private DataManager mDataManager;
    private boolean isRefresh = true;
    private int mCurrentPage;

    @Inject
    MainPagerPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void attachView(MainPagerContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    private void registerEvent() {
        //addSubScribe();
    }

    @Override
    public String getLoginPassword() {
        return null;
    }

    @Override
    public void loadMainPagerData() {
        Observable<BaseResponse<LoginData>> mLoginObserbable ;

    }

    @Override
    public void getFeedArticleList(boolean isShowError) {

    }

    @Override
    public void loadMoreData() {

    }

    @Override
    public void addCollectArticle(int position, FeedArticleData feedArticleData) {

    }

    @Override
    public void cancelCollectArticle(int position, FeedArticleData feedArticleData) {

    }

    @Override
    public void getBannerData(boolean isShowError) {

    }

    @Override
    public void autoRefresh(boolean isShowError) {

    }

    @Override
    public void loadMore() {

    }
}
