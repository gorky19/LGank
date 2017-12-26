package Model;

import Bean.DataBean;
import Bean.FuliBean;
import Bean.PhoneBean;
import Bean.SelectBean;
import Bean.WebBean;
import Presenter.NewPresenter;
import http.ApiService;
import http.RetrofitUitls;
import io.reactivex.Flowable;

/**
 * Created by ZhangTAO on 2017/12/18.
 */

public class Models implements IModel{
    private NewPresenter mpresenter;
    public Models(NewPresenter newPresenter) {
        this.mpresenter = newPresenter;
    }
    @Override
    public void getDatas1(String baseurl,String types, int num, int pages) {
        Flowable<DataBean> flowable1 = RetrofitUitls.getInstance(baseurl).getretrofit()
                .create(ApiService.class).getService(types, num, pages);
        mpresenter.getDataNews(flowable1);
    }
    @Override
    public void getDatas2(String baseurl, String types, int num, int pages) {
        Flowable<PhoneBean> flowable2 = RetrofitUitls.getInstance(baseurl).getretrofit()
                .create(ApiService.class).getService2(types, num, pages);
        mpresenter.getDataNews2(flowable2);
    }
    @Override
    public void getDatas3(String baseurl, String types, int num, int pages) {
        Flowable<WebBean> flowable3 = RetrofitUitls.getInstance(baseurl).getretrofit()
                .create(ApiService.class).getService3(types, num, pages);
        mpresenter.getDataNews3(flowable3);
    }

    @Override
    public void getDatas4(String baseurl, String types, int num, int pages) {
        Flowable<FuliBean> flowable4 = RetrofitUitls.getInstance(baseurl).getretrofit()
                .create(ApiService.class).getService4(types, num, pages);
        mpresenter.getDataNews4(flowable4);
    }
    @Override
    public void getDatas5(String baseurl, String keyname, int num, int pages) {
        Flowable<SelectBean> flowable5 = RetrofitUitls.getInstance(baseurl).getretrofit()
                .create(ApiService.class).getService5(keyname, num, pages);
        mpresenter.getDataNews5(flowable5);
    }
}
