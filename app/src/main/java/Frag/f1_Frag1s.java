package Frag;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import java.util.List;

import Bean.DataBean;
import MyAdapter_List.Myadapter_xrecy1;
import Presenter.NewPresenter;
import Views.IViews;
import zhangtao.bwie.com.lgank.R;
import zhangtao.bwie.com.lgank.XiangQing_act;

/**
 * Created by ZhangTAO on 2017/12/17.
 */

public class f1_Frag1s extends Fragment implements IViews{
    private RecyclerView xrecy1;
    private NewPresenter newPresenter;
    private String name;
    private int num = 10;
    private int pages = 1;
    private List<DataBean.ResultsBean> results;
    private Myadapter_xrecy1 myadapter_xrecy1;
    private PullToRefreshLayout pull1;
    private int colorzt;
    private Handler ler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    private SharedPreferences f1_frag1s_share;
    private SimpleDraweeView load_img;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View f1_frags = inflater.inflate(R.layout.f1_frags, null);
        Fresco.initialize(getContext());
        initView(f1_frags);
        return f1_frags;
    }
    @Override
    public void onResume() {
        super.onResume();
        name="Android";
        setPresenters("http://gank.io/api/",name,num,pages);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        f1_frag1s_share = getActivity().getSharedPreferences("colors", Context.MODE_PRIVATE);
        colorzt = f1_frag1s_share.getInt("zt_color", 0);
        pull1.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setPresenters("http://gank.io/api/", name, num, pages);
                        setAdapters();
                        myadapter_xrecy1.notifyDataSetChanged();
                        pull1.finishRefresh();
                    }
                }, 2000);
            }
            @Override
            public void loadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        num += 10;
                        setPresenters("http://gank.io/api/", name, num, pages);
                        setAdapters();
                        myadapter_xrecy1.notifyDataSetChanged();
                        pull1.finishLoadMore();
                    }
                }, 2000);
            }
        });
    }

    private void initView(View f1_frags) {
        xrecy1 = f1_frags.findViewById(R.id.recy1);
        pull1 = f1_frags.findViewById(R.id.pull_layout);
//        load_img = f1_frags.findViewById(R.id.load_img);
    }
    private void setPresenters(String baseurl,String types,int num,int pages) {
        newPresenter = new NewPresenter();
        newPresenter.attach(this);
        newPresenter.getNewData(baseurl,types,num,pages);
    }
    private void setAdapters() {
        myadapter_xrecy1 = new Myadapter_xrecy1(getActivity(), results);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        xrecy1.setLayoutManager(manager);
        xrecy1.setAdapter(myadapter_xrecy1);
        myadapter_xrecy1.setItemClickeds(new Myadapter_xrecy1.onitemclick() {
            @Override
            public void onItemClicked(View view, int pos) {
                String url = results.get(pos).getUrl();
                Intent intent = new Intent(getActivity(), XiangQing_act.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onSuccess(Object o) {
        if(o instanceof DataBean) {
            DataBean bean = (DataBean) o;
            if (bean != null) {
                results = bean.getResults();
                setAdapters();
            }
        }
    }
    @Override
    public void onFailed(Exception e) {
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(newPresenter != null) {
            newPresenter.detach();
        }
    }
}
