package com.lijj.wyx.physical;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.lijj.wyx.physical.core.http.NetWorkManager;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.HttpUrl;
import okhttp3.ResponseBody;

import static com.lijj.wyx.physical.core.http.api.Api.GANK_DOMAIN_NAME;

public class HttpTestActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mProgressDialog = new ProgressDialog(this);
        EditText mUrl2 = findViewById(R.id.et_url2);

        findViewById(R.id.bt_request2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpUrl httpUrl = RetrofitUrlManager.getInstance().fetchDomain(GANK_DOMAIN_NAME);
                if (httpUrl == null || !httpUrl.toString().equals(mUrl2.getText().toString())) { //可以在 App 运行时随意切换某个接口的 BaseUrl
                    RetrofitUrlManager.getInstance().putDomain(GANK_DOMAIN_NAME, mUrl2.getText().toString());
                }
                /**
                 * 使用超级模式请求, 详细注释请查看 {@link me.jessyan.retrofiturlmanager.demo.api.TwoApiService#getData(int, int)}
                 */
                NetWorkManager
                        .getInstance()
                        .getTwoApiService()
                        .getData(10, 1)
                        .compose(HttpTestActivity.this.<ResponseBody>getDefaultTransformer())
                        .subscribe(getDefaultObserver());
            }
        });
    }


    private <T> ObservableTransformer<T, T> getDefaultTransformer() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                mProgressDialog.show();
                            }
                        })
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doAfterTerminate(new Action() {
                            @Override
                            public void run() throws Exception {
                                mProgressDialog.dismiss();
                            }
                        });
            }
        };
    }

    private Observer<ResponseBody> getDefaultObserver() {
        return new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseBody response) {
                try {
                    String string = response.string();
                    Log.d("test", string);
                    showResult(string);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
                showResult(throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
    }

    private void showResult(String result) {
        new AlertDialog.Builder(this)
                .setMessage(result)
                .setCancelable(true)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }
}
