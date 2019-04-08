package com.example.lll.wanandroidproject.app;

import android.support.annotation.NonNull;

import com.xuexiang.xupdate.proxy.IUpdateHttpService;

import java.util.Map;

public class UpdateHttpService implements IUpdateHttpService {

    @Override
    public void asyncGet(@NonNull String url, @NonNull Map<String, Object> params, @NonNull Callback callBack) {

    }

    @Override
    public void asyncPost(@NonNull String url, @NonNull Map<String, Object> params, @NonNull Callback callBack) {

    }

    @Override
    public void download(@NonNull String url, @NonNull String path, @NonNull String fileName, @NonNull DownloadCallback callback) {

    }

    @Override
    public void cancelDownload(@NonNull String url) {

    }
}
