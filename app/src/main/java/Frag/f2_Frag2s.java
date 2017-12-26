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

import Bean.PhoneBean;
import MyAdapter_List.Myadapter_xrecy1;
import MyAdapter_List.Myadapter_xrecy2;
import Presenter.NewPresenter;
import Views.IViews;
import zhangtao.bwie.com.lgank.R;
import zhangtao.bwie.com.lgank.XiangQing_act;

/**
 * Created by ZhangTAO on 2017/12/17.
 */

public class f2_Frag2s extends Fragment implements IViews{

    private RecyclerView xrecy2;
    private NewPresenter newPresenter;
    private Myadapter_xrecy2 myadapter_xrecy2;
    private int num = 10;
    private int pages = 2;
    private String name;
    private List<PhoneBean.ResultsBean> results2;
    private PullToRefreshLayout pull2;
    private int colorzt;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View f2_frags = inflater.inflate(R.layout.f2_frags, null);
//        EventBus.getDefault().register(f2_Frag2s.this);
        initView(f2_frags);
        return f2_frags;
    }

    @Override
    public void onResume() {
        super.onResume();
        name = "iOS";
        setPresenters("http://gank.io/api/", name,num,pages);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void initView(View f2_frags) {
        xrecy2 = f2_frags.findViewById(R.id.recy2);
        pull2 = f2_frags.findViewById(R.id.pulllayout2);
    }
    private void setPresenters(String baseurl,String types,int num,int pages) {
        newPresenter = new NewPresenter();
        newPresenter.attach(this);
        newPresenter.getNewData(baseurl,types,num,pages);
    }
    private void setAdapters() {
        myadapter_xrecy2 = new Myadapter_xrecy2(getActivity(), results2);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        xrecy2.setLayoutManager(manager);
        xrecy2.setAdapter(myadapter_xrecy2);
        myadapter_xrecy2.setItemClickeds(new Myadapter_xrecy1.onitemclick() {
            @Override
            public void onItemClicked(View view, int pos) {
                String url = results2.get(pos).getUrl();
                Intent intent = new Intent(getActivity(), XiangQing_act.class);
                intent.putExtra("url",url);
//                intent.putExtra("zt_color",colorzt);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof PhoneBean) {
            PhoneBean bean = (PhoneBean) o;
            if(bean != null) {
                results2 = bean.getResults();
                Log.d("zzz","总数据2："+ this.results2.toString());
                setAdapters();
                pull2.setRefreshListener(new BaseRefreshListener() {
                    @Override
                    public void refresh() {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                setPresenters("http://gank.io/api/",name,num,pages);
                                setAdapters();
                                myadapter_xrecy2.notifyDataSetChanged();
                                pull2.finishRefresh();
                            }
                        },2000);
                    }
                    @Override
                    public void loadMore() {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                num+=10;
                                setPresenters("http://gank.io/api/",name,num,pages);
                                setAdapters();
                                myadapter_xrecy2.notifyDataSetChanged();
                                pull2.finishLoadMore();
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
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
