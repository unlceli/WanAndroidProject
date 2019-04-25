package com.lijj.wyx.physical.core.http;

import com.lijj.wyx.physical.core.http.api.GeeksApis;

import javax.inject.Inject;

public class HttpHelperImpl implements HttpHelper {

    private GeeksApis mGeeksApis;

    @Inject
    HttpHelperImpl(GeeksApis geeksApis) {
        mGeeksApis = geeksApis;
    }

}
