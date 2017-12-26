package Presenter;

import Bean.DataBean;
import Bean.FuliBean;
import Bean.PhoneBean;
import Bean.SelectBean;
import Bean.WebBean;
import Model.Models;
import Views.IViews;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by ZhangTAO on 2017/12/18.
 */

public class NewPresenter implements IPersenter {
    private IViews miv;
    private DisposableSubscriber subscriper1;
    private DisposableSubscriber subscriper2;
    private DisposableSubscriber subscriper3;
    private DisposableSubscriber subscriper4;
    private DisposableSubscriber subscriper5;
    public void attach(IViews iv) {
        this.miv = iv;
    }
    public void detach() {
        if(miv != null) {
            miv = null;
        }
        if(subscriper1 != null) {
            if(subscriper1.isDisposed()) {
                subscriper1.dispose();
            }
        }
        if(subscriper2 != null) {
            if(subscriper2.isDisposed()) {
                subscriper2.dispose();
            }
        }
        if(subscriper3 != null) {
            if(subscriper3.isDisposed()) {
                subscriper3.dispose();
            }
        }
        if(subscriper4 != null) {
            if(subscriper4.isDisposed()) {
                subscriper4.dispose();
            }
        }
        if(subscriper5 != null) {
            if(subscriper5.isDisposed()) {
                subscriper5.dispose();
            }
        }
    }
    @Override
    public void getNewData(String baseurl, String types, int num, int pages) {
        Models models = new Models(this);
        models.getDatas1(baseurl,types,num,pages);
        models.getDatas2(baseurl,types,num,pages);
        models.getDatas3(baseurl,types,num,pages);
        models.getDatas4(baseurl,types,num,pages);
        models.getDatas5(baseurl,types,num,pages);
    }
    public void getDataNews(Flowable<DataBean> flowable1) {
        subscriper1 = flowable1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<DataBean>() {
                    @Override
                    public void onNext(DataBean dataBean) {
                        if(dataBean != null) {
                            miv.onSuccess(dataBean);
                        }
                    }
                    @Override
                    public void onError(Throwable t) {
                        miv.onFailed((Exception) t);
                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getDataNews2(Flowable<PhoneBean> flowable2) {
        subscriper2 = flowable2.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<PhoneBean>() {
                    @Override
                    public void onNext(PhoneBean phoneBean) {
                        if(phoneBean != null) {
                            miv.onSuccess(phoneBean);
                        }
                    }
                    @Override
                    public void onError(Throwable t) {
                        miv.onFailed((Exception) t);
                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void getDataNews3(Flowable<WebBean> flowable3) {
        subscriper3 = flowable3.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<WebBean>() {
                    @Override
                    public void onNext(WebBean webBean) {
                        if(webBean != null) {
                            miv.onSuccess(webBean);
                        }
                    }
                    @Override
                    public void onError(Throwable t) {
                        miv.onFailed((Exception) t);
                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getDataNews4(Flowable<FuliBean> flowable4) {
        subscriper4 = flowable4.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<FuliBean>() {
                    @Override
                    public void onNext(FuliBean fuliBean) {
                        if(fuliBean != null) {
                            miv.onSuccess(fuliBean);
                        }
                    }
                    @Override
                    public void onError(Throwable t) {
                        miv.onFailed((Exception) t);
                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getDataNews5(Flowable<SelectBean> flowable5) {
        subscriper5 = flowable5.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<SelectBean>() {
                    @Override
                    public void onNext(SelectBean selectBean) {
                        if(selectBean != null) {
                            miv.onSuccess(selectBean);
                        }
                    }
                    @Override
                    public void onError(Throwable t) {
                        miv.onFailed((Exception) t);
                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }
}
