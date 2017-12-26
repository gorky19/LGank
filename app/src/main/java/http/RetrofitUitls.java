package http;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by ZhangTAO on 2017/12/15.
 */

public class RetrofitUitls {
    private static volatile RetrofitUitls instance;
    private Retrofit retrofit;
    private Class service;

    public RetrofitUitls(String baseurl) {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
    public static RetrofitUitls getInstance(String baseurl) {
        if(instance == null) {
            synchronized (RetrofitUitls.class) {
                if(null == instance) {
                    instance = new RetrofitUitls(baseurl);
                }
            }
        }
            return instance;
    }
    public Retrofit getretrofit() {
        return retrofit;
    }
    public void create(Class cls) {
        service = (Class) retrofit.create(cls);
    }
    public Class getService() {
        return service;
    }
}
