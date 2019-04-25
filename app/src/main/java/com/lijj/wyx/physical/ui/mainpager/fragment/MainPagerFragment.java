package com.lijj.wyx.physical.ui.mainpager.fragment;

import com.lijj.wyx.physical.base.fragment.BaseRootFragment;
import com.lijj.wyx.physical.contract.mainpager.MainPagerContract;
import com.lijj.wyx.physical.core.bean.main.banner.BannerData;
import com.lijj.wyx.physical.core.bean.main.collect.FeedArticleData;
import com.lijj.wyx.physical.core.bean.main.collect.FeedArticleListData;
import com.lijj.wyx.physical.presenter.mainpager.MainPagerPresenter;

import java.util.List;

public class MainPagerFragment  extends BaseRootFragment<MainPagerPresenter> implements MainPagerContract.View {
    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    public void showAutoLoginSuccess() {

    }

    @Override
    public void showAutoLoginFail() {

    }

    @Override
    public void showArticleList(FeedArticleListData feedArticleListData, boolean isRefresh) {

    }

    @Override
    public void showCollectArticleData(int position, FeedArticleData feedArticleData, FeedArticleListData feedArticleListData) {

    }

    @Override
    public void showCancelCollectArticleData(int position, FeedArticleData feedArticleData, FeedArticleListData feedArticleListData) {

    }

    @Override
    public void showBannerData(List<BannerData> bannerDataList) {

    }
}
