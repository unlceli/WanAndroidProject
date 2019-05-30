package com.lijj.wyx.physical.presenter.main;

import android.Manifest;

import com.lijj.wyx.physical.R;
import com.lijj.wyx.physical.app.WanAndroidApp;
import com.lijj.wyx.physical.base.presenter.BasePresenter;
import com.lijj.wyx.physical.contract.main.ArticleDetailContract;
import com.lijj.wyx.physical.core.DataManager;
import com.lijj.wyx.physical.core.bean.main.collect.FeedArticleListData;
import com.lijj.wyx.physical.utils.RxUtils;
import com.lijj.wyx.physical.widget.BaseObserver;
import com.tbruyelle.rxpermissions2.RxPermissions;

import javax.inject.Inject;

public class ArticleDetailPresenter extends BasePresenter<ArticleDetailContract.View> implements ArticleDetailContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public ArticleDetailPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public boolean getAutoCacheState() {
        return mDataManager.getAutoCacheState();
    }

    @Override
    public boolean getNoImageState() {
        return mDataManager.getNoImageState();
    }

    @Override
    public void addCollectArticle(int id) {
        addSubscribe(mDataManager.addCollectArticle(id)
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleCollectResult())
                .subscribeWith(new BaseObserver<FeedArticleListData>(mView, WanAndroidApp.getInstance().getString(R.string.collect_fail)) {
                    @Override
                    public void onNext(FeedArticleListData feedArticleListData) {
                        mView.showCollectArticleData(feedArticleListData);
                    }
                })


        );
    }

    @Override
    public void cancelCollectArticle(int id) {
        addSubscribe(mDataManager.cancelCollectArticle(id)
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleCollectResult())
                .subscribeWith(new BaseObserver<FeedArticleListData>(mView, WanAndroidApp.getInstance().getString(R.string.cancel_collect_fail)) {
                    @Override
                    public void onNext(FeedArticleListData feedArticleListData) {
                        mView.showCancelCollectArticleData(feedArticleListData);
                    }
                })

        );
    }

    @Override
    public void cancelCollectPageArticle(int id) {
        addSubscribe(mDataManager.cancelCollectPageArticle(id)
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleCollectResult())
                .subscribeWith(new BaseObserver<FeedArticleListData>(mView, WanAndroidApp.getInstance().getString(R.string.cancel_collect_fail)) {
                                   @Override
                                   public void onNext(FeedArticleListData feedArticleListData) {
                                       mView.showCancelCollectArticleData(feedArticleListData);
                                   }
                               }
                ));
    }

    @Override
    public void shareEventPermissionVerify(RxPermissions rxPermissions) {
        addSubscribe(rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(aBoolean -> {
                    if (aBoolean) {
                        mView.shareEvent();
                    } else {
                        mView.shareError();
                    }
                })
        );
    }
}
