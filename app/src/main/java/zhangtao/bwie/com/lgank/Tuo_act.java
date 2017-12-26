package zhangtao.bwie.com.lgank;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.List;

import Bean.WebBean;
import ImmerSionUtil.ImmersionUtils;
import MyAdapter_List.Myadapter_xrecy3;
import Presenter.NewPresenter;
import Views.IViews;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by ZhangTAO on 2017/12/19.
 */

public class Tuo_act extends SwipeBackActivity implements IViews,View.OnClickListener{
    private RelativeLayout toolbar;
    private RecyclerView web_recy;
    private PullToRefreshLayout pull_qianduan;
    private NewPresenter newPresenter;
    private String name;
    private int num = 10;
    private int pages = 1;
    private List<WebBean.ResultsBean> web_results;
    private Myadapter_xrecy3 myadapter_xrecy3;
    private SharedPreferences web_share;
    private int colorzt;
    private ImageView img_back;
    private SystemBarTintManager tintManager;
    private boolean translucentStatus;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qianduan);
        new ImmersionUtils().setImmersion(getWindow(), getSupportActionBar());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        initView();
        web_share = getSharedPreferences("colors", Context.MODE_PRIVATE);
        colorzt = web_share.getInt("zt_color", 0);
        setOnCliek();
        lefthua();
    }
    private void lefthua() {
        setSwipeBackEnable(true);
        SwipeBackLayout swipeBackLayout = getSwipeBackLayout();
        //设置滑动方向
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
    }
    public void setTranslucentStatus(boolean translucentStatus) {
        this.translucentStatus = translucentStatus;
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int bitss = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if(translucentStatus) {
            attributes.flags |=bitss;
        } else {
            attributes.flags &= ~bitss;
        }
        window.setAttributes(attributes);
    }
    private void setOnCliek() {
        img_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                overridePendingTransition(R.anim.showlefttoright,R.anim.hidelefttoright);
                break;
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        name="拓展资源";
        setPresenters("http://gank.io/api/", name,num,pages);
        toolbar.setBackgroundColor(getResources().getColor(colorzt));
        tintManager.setStatusBarTintResource(colorzt);
    }

    private void initView() {
        toolbar = (RelativeLayout) findViewById(R.id.toolbar);
        web_recy = (RecyclerView) findViewById(R.id.web_recy);
        pull_qianduan = (PullToRefreshLayout) findViewById(R.id.pull_qianduan);
        img_back = (ImageView) findViewById(R.id.img_back);
    }
    private void setPresenters(String baseurl,String types,int num,int pages) {
        newPresenter = new NewPresenter();
        newPresenter.attach(this);
        newPresenter.getNewData(baseurl,types,num,pages);
    }
    private void setMyadapter_web() {
        myadapter_xrecy3 = new Myadapter_xrecy3(this, web_results);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        web_recy.setLayoutManager(manager);
        web_recy.setAdapter(myadapter_xrecy3);
        myadapter_xrecy3.setItemClickeds(new Myadapter_xrecy3.onitemclick() {
            @Override
            public void onItemClicked(View view, int pos) {
                String url = web_results.get(pos).getUrl();
                Intent intent = new Intent(Tuo_act.this, XiangQing_act.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onSuccess(Object o) {
        if(o instanceof WebBean) {
            WebBean bean = (WebBean) o;
            if(bean != null) {
                web_results = bean.getResults();
                setMyadapter_web();
                pull_qianduan.setRefreshListener(new BaseRefreshListener() {
                    @Override
                    public void refresh() {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                setPresenters("http://gank.io/api/", name,num,pages);
                                setMyadapter_web();
                                myadapter_xrecy3.notifyDataSetChanged();
                                pull_qianduan.finishRefresh();
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
                                setMyadapter_web();
                                myadapter_xrecy3.notifyDataSetChanged();
                                pull_qianduan.finishLoadMore();
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
}
