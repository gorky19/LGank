package Frag;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import Bean.FuliBean;
import MyAdapter_List.Myadapter_xrecy4;
import Presenter.NewPresenter;
import Views.IViews;
import zhangtao.bwie.com.lgank.PhoneActivity2;
import zhangtao.bwie.com.lgank.R;

/**
 * Created by ZhangTAO on 2017/12/17.
 */

public class f3_Frag3s extends Fragment implements IViews,View.OnClickListener{

    private PullToRefreshLayout pull4;
    private RecyclerView recy3;
    private NewPresenter newPresenter;
    private List<FuliBean.ResultsBean> results4;
    private String name = "福利";
    private int num = 10;
    private int pager = 1;
    private Myadapter_xrecy4 myadapter_xrecy4;
    private FloatingActionButton girdbtn;
    private FloatingActionButton listbtn;
    private FloatingActionButton stragglebtn;
    private FloatingActionsMenu plus;
    private int colorzt;
    private ArrayList<String> urllist = new ArrayList<String>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View f3_frags = inflater.inflate(R.layout.f3_frags, null);
        Fresco.initialize(getContext());
        initView(f3_frags);
        return f3_frags;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setPresenters("http://www.gank.io/api/",name,num,pager);
        girdbtn.setOnClickListener(this);
        listbtn.setOnClickListener(this);
        stragglebtn.setOnClickListener(this);
    }
    private void initView(View f3_frags) {
        pull4 = f3_frags.findViewById(R.id.pull_layout_pic4);
        recy3 = f3_frags.findViewById(R.id.recy3);
        girdbtn = f3_frags.findViewById(R.id.action_grid);
        listbtn = f3_frags.findViewById(R.id.action_list);
        stragglebtn = f3_frags.findViewById(R.id.action_staggle);
        plus = f3_frags.findViewById(R.id.plus);
    }
    private void setPresenters(String baseurl,String types,int num,int pages) {
        newPresenter = new NewPresenter();
        newPresenter.attach(this);
        newPresenter.getNewData(baseurl,types,num,pages);
    }
    private void setAdapters() {
        myadapter_xrecy4 = new Myadapter_xrecy4(getActivity(), results4);
        GridLayoutManager manager1 = new GridLayoutManager(getContext(),2);
        recy3.setLayoutManager(manager1);
        recy3.setAdapter(myadapter_xrecy4);
        myadapter_xrecy4.setItemClickeds(new Myadapter_xrecy4.onitemclick() {
            @Override
            public void onItemClicked(View view, int pos) {
                urllist.clear();
                for(int i=0;i<results4.size();i++) {
                    urllist.add(results4.get(i).getUrl());
                }
                Intent intent = new Intent(getActivity(), PhoneActivity2.class);
                intent.putExtra("id",pos);
                intent.putExtra("list",urllist);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onSuccess(Object o) {
        if(o instanceof FuliBean) {
            FuliBean bean = (FuliBean) o;
            if (bean != null) {
                results4 = bean.getResults();
                Log.d("zzz", "总数据4：" + this.results4.toString());
                setAdapters();
                pull4.setRefreshListener(new BaseRefreshListener() {
                    @Override
                    public void refresh() {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                setPresenters("http://www.gank.io/api/",name,num,pager);
                                setAdapters();
                                myadapter_xrecy4.notifyDataSetChanged();
                                pull4.finishRefresh();
                            }
                        },2000);
                    }
                    @Override
                    public void loadMore() {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                num+=10;
                                setPresenters("http://www.gank.io/api/",name,num,pager);
                                setAdapters();
                                myadapter_xrecy4.notifyDataSetChanged();
                                pull4.finishLoadMore();
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.action_grid:
                myadapter_xrecy4 = new Myadapter_xrecy4(getActivity(), results4);
                GridLayoutManager manager1 = new GridLayoutManager(getContext(),2);
                recy3.setLayoutManager(manager1);
                recy3.setAdapter(myadapter_xrecy4);
                myadapter_xrecy4.setItemClickeds(new Myadapter_xrecy4.onitemclick() {
                    @Override
                    public void onItemClicked(View view, int pos) {
                        urllist.clear();
                        for(int i=0;i<results4.size();i++) {
                            urllist.add(results4.get(i).getUrl());
                        }
                        Intent intent = new Intent(getActivity(), PhoneActivity2.class);
                        intent.putExtra("id",pos);
                        intent.putExtra("list",urllist);
                        startActivity(intent);
                    }
                });
                plus.collapse();
                break;
            case R.id.action_list:
                myadapter_xrecy4 = new Myadapter_xrecy4(getActivity(), results4);
                LinearLayoutManager manager2 = new LinearLayoutManager(getContext());
                recy3.setLayoutManager(manager2);
                recy3.setAdapter(myadapter_xrecy4);
                myadapter_xrecy4.setItemClickeds(new Myadapter_xrecy4.onitemclick() {
                    @Override
                    public void onItemClicked(View view, int pos) {
                        urllist.clear();
                        for(int i=0;i<results4.size();i++) {
                            urllist.add(results4.get(i).getUrl());
                        }
                        Intent intent = new Intent(getActivity(), PhoneActivity2.class);
                        intent.putExtra("id",pos);
                        intent.putExtra("list",urllist);
                        startActivity(intent);
                    }
                });
                plus.collapse();
                break;
            case R.id.action_staggle:
                StaggeredGridLayoutManager manager3 = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                myadapter_xrecy4 = new Myadapter_xrecy4(getActivity(), results4);
                recy3.setLayoutManager(manager3);
                recy3.setAdapter(myadapter_xrecy4);
                myadapter_xrecy4.setItemClickeds(new Myadapter_xrecy4.onitemclick() {
                    @Override
                    public void onItemClicked(View view, int pos) {
                        urllist.clear();
                        for(int i=0;i<results4.size();i++) {
                            urllist.add(results4.get(i).getUrl());
                        }
                        Intent intent = new Intent(getActivity(), PhoneActivity2.class);
                        intent.putExtra("id",pos);
                        intent.putExtra("list",urllist);
                        startActivity(intent);
                    }
                });
                plus.collapse();
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
