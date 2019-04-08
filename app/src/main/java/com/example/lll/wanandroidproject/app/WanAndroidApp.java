package com.example.lll.wanandroidproject.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.multidex.MultiDex;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatDelegate;

import com.bumptech.glide.Glide;
import com.example.lll.wanandroidproject.BuildConfig;
import com.example.lll.wanandroidproject.R;
import com.example.lll.wanandroidproject.di.component.AppComponent;
import com.example.lll.wanandroidproject.di.component.DaggerAppComponent;
import com.example.lll.wanandroidproject.di.module.AppModule;
import com.example.lll.wanandroidproject.di.module.HttpModule;
import com.example.lll.wanandroidproject.utils.CommonUtils;
import com.example.lll.wanandroidproject.utils.logger.TxtFormatStrategy;
import com.facebook.stetho.Stetho;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.scwang.smartrefresh.header.DeliveryHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tencent.bugly.crashreport.CrashReport;
import com.xuexiang.xupdate.XUpdate;
import com.xuexiang.xupdate.entity.UpdateError;
import com.xuexiang.xupdate.listener.OnUpdateFailureListener;
import com.xuexiang.xupdate.utils.UpdateUtils;


import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import json.chao.com.wanandroid.core.dao.DaoMaster;
import json.chao.com.wanandroid.core.dao.DaoSession;

public class WanAndroidApp extends Application implements HasActivityInjector {


    @Inject
    DispatchingAndroidInjector<Activity> mAndroidInjector;
    private static WanAndroidApp instance;
    private RefWatcher refWatcher;
    public static boolean isFirstRun = true;
    private static volatile AppComponent appComponent;
    private DaoSession mDaoSession;

    //static 代码可以防止内存泄漏，全局设置刷新头部以及尾部，优先级最低。
    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(((context, layout) -> {
            //全局设置主题颜色
            layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);
            //指定为Delivery Header ,默认是贝塞尔雷达Header。
            return new DeliveryHeader(context);
        }));
        SmartRefreshLayout.setDefaultRefreshFooterCreator(((context, layout) -> {
            //默认是 BallPulseFooter
            return new BallPulseFooter(context).setAnimatingColor(ContextCompat.getColor(context, R.color.colorPrimary));
        }));

    }

    public DaoSession getmDaoSession() {
        return mDaoSession;
    }

    public static synchronized WanAndroidApp getInstance() {
        return instance;
    }

    public static RefWatcher getRefWatcher(Context context) {
        WanAndroidApp androidApp = (WanAndroidApp) context.getApplicationContext();
        return androidApp.refWatcher;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        refWatcher = LeakCanary.install(this);

        initGreenDao();
        instance = this;

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .httpModule(new HttpModule())
                .build();

        appComponent.inject(this);


        initBugly();

        initLogger();
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }

    }

    /**
     * 指导应用程序咋不同的情况下进行自身的内存释放，以避免被系统直接杀掉。提供应用程序的用户体验。
     *
     * @param level
     */
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level == TRIM_MEMORY_UI_HIDDEN) {
            Glide.get(this).clearMemory();
        }
        Glide.get(this).trimMemory(level);
    }

    /**
     * 低版本 内存释放
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Glide.get(this).clearMemory();
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, Constants.DB_NAME);
        SQLiteDatabase database = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        mDaoSession = daoMaster.newSession();

    }

    private void initLogger() {
        //DEBUG 版本 控制台log
        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(new AndroidLogAdapter(PrettyFormatStrategy.newBuilder().tag(getString(R.string.app_name)).build()));
        }
        //把log存在本地
        Logger.addLogAdapter(new DiskLogAdapter(TxtFormatStrategy.newBuilder().tag(getString(R.string.app_name)).build(getPackageName(), getString(R.string.app_name))));
    }

    private void initBugly() {
        // 获取当前包名
        String packageName = getApplicationContext().getPackageName();
        // 获取当前进程名
        String processName = CommonUtils.getProcessName(android.os.Process.myPid());
        // 设置是否为上报进程
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(getApplicationContext());
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        CrashReport.initCrashReport(getApplicationContext(), Constants.BUGLY_ID, false, strategy);
    }

    private void initAppUpdate() {
        XUpdate.get()
                .debug(true)
                .isWifiOnly(true)
                .isGet(true)
                .isAutoMode(false)
                .param("VersionCode", UpdateUtils.getVersionCode(this))
                .param("AppKey", getPackageName())
                .setOnUpdateFailureListener(new OnUpdateFailureListener() {
                    @Override
                    public void onFailure(UpdateError error) {
                        CommonUtils.showMessage(getInstance(), error.toString());
                    }
                })
                .setIUpdateHttpService(new UpdateHttpService())
                .init(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mAndroidInjector;
    }

}
