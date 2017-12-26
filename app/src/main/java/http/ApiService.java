package http;

import Bean.DataBean;
import Bean.FuliBean;
import Bean.PhoneBean;
import Bean.SelectBean;
import Bean.WebBean;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ZhangTAO on 2017/12/15.
 */

public interface ApiService {
    @GET("data/{types}/{num}/{pages}")
    Flowable<DataBean> getService(
            @Path("types") String types,
            @Path("num") int num,
            @Path("pages") int pages);
    @GET("data/{types}/{num}/{pages}")
    Flowable<PhoneBean> getService2(
            @Path("types") String types,
            @Path("num") int num,
            @Path("pages") int pages);
    @GET("data/{types}/{num}/{pages}")
    Flowable<WebBean> getService3(
            @Path("types") String types,
            @Path("num") int num,
            @Path("pages") int pages);
    @GET("data/{types}/{num}/{pages}")
    Flowable<FuliBean> getService4(
            @Path("types") String types,
            @Path("num") int num,
            @Path("pages") int pages);
//    http://gank.io/api/search/query/listview/category/Android/count/10/page/1
    @GET("search/query/{keyname}/category/Android/count/{num}/page/{pages}")
    Flowable<SelectBean> getService5(
            @Path("keyname") String types,
            @Path("num") int num,
            @Path("pages") int pages);
}
