package com.example.lll.wanandroidproject.core.http;

import com.example.lll.wanandroidproject.core.http.api.GeeksApis;

import javax.inject.Inject;

public class HttpHelperImpl implements HttpHelper {

    private GeeksApis mGeeksApis;

    @Inject
    HttpHelperImpl(GeeksApis geeksApis) {
        mGeeksApis = geeksApis;
    }

}
