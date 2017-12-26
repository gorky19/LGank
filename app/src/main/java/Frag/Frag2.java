package Frag;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import java.util.List;

import Bean.WebBean;
import MyAdapter_List.Myadapter_xrecy3;
import Presenter.NewPresenter;
import Views.IViews;
import zhangtao.bwie.com.lgank.R;
import zhangtao.bwie.com.lgank.XiangQing_act;

/**
 * Created by ZhangTAO on 2017/12/17.
 */

public class Frag2 extends Fragment implements IViews{
    private RecyclerView read_xrecy;
    private List<WebBean.ResultsBean> results3;
    private String name = "前端";
    private int num = 10;
    private int pages = 3;
    private Myadapter_xrecy3 myadapter_xrecy3;
    private PullToRefreshLayout pull3;
    private int colorzt;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v2 = inflater.inflate(R.layout.f2, null);
//        EventBus.getDefault().register(Frag2.this);
        initView(v2);
        return v2;
    }
//    @Subscribe
//    public void getColor(EventManages event) {
//        colorzt = event.getColoszt();
//    }
    @Override
    public void onResume() {
        super.onResume();
        setPresenters("http://gank.io/api/", name,num,pages);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setPresenters("http://gank.io/api/", name,num,pages);
    }

    private void initView(View v2) {
        read_xrecy = v2.findViewById(R.id.read_xrecy);
        pull3 = v2.findViewById(R.id.pull_layout3);
    }
    private void setMyadapter_read() {
        myadapter_xrecy3 = new Myadapter_xrecy3(getActivity(),results3);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        read_xrecy.setLayoutManager(manager);
        read_xrecy.setAdapter(myadapter_xrecy3);
        myadapter_xrecy3.setItemClickeds(new Myadapter_xrecy3.onitemclick() {
            @Override
            public void onItemClicked(View view, int pos) {
                String url = results3.get(pos).getUrl();
                Intent intent = new Intent(getActivity(), XiangQing_act.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });
    }
    private void setPresenters(String baseurl,String types,int num,int pages) {
        NewPresenter newPresenter = new NewPresenter();
        newPresenter.attach(this);
        newPresenter.getNewData(baseurl,types,num,pages);
    }
    @Override
    public void onSuccess(Object o) {
        if(o instanceof WebBean) {
            WebBean bean = (WebBean) o;
            if(bean != null) {
                results3 = bean.getResults();
                Log.d("zzz","总数据web3"+results3.toString());
                setMyadapter_read();
                pull3.setRefreshListener(new BaseRefreshListener() {
                    @Override
                    public void refresh() {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                setPresenters("http://gank.io/api/", name,num,pages);
                                setMyadapter_read();
                                myadapter_xrecy3.notifyDataSetChanged();
                                pull3.finishRefresh();
                            }
                        },2000);
                    }
                    @Override
                    public void loadMore() {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                num+=10;
                                setPresenters("http://gank.io/api/", name,num,pages);
                                setMyadapter_read();
                                myadapter_xrecy3.notifyDataSetChanged();
                                pull3.finishLoadMore();
                            }
                        },2000);
                    }
                });
            }
        }
    }
    @Override
    public void onFailed(Exception e) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        EventBus.getDefault().unregister(Frag2.this);
    }
}
