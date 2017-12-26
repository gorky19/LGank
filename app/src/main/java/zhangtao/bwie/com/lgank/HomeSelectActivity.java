package zhangtao.bwie.com.lgank;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.List;

import Bean.LishiBean;
import Bean.SelectBean;
import DBHelp.DBHelper;
import ImmerSionUtil.ImmersionUtils;
import MyAdapter_List.Lishi_Adapter;
import MyAdapter_List.Select_Myadapter;
import Presenter.NewPresenter;
import Views.IViews;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import zhangtao.bwie.com.lgank.gen.LishiBeanDao;

/**
 * Created by ZhangTAO on 2017/11/14.
 */

public class HomeSelectActivity extends SwipeBackActivity implements View.OnClickListener, IViews{
    private TextView select_btn_text;
    private ImageView select_image;
    private EditText select_edit;
    private RecyclerView lishi_recy;
    private LishiBeanDao dao;
    private List<LishiBean> dbHelperData;
    private ImageView lishi_clear;
    private TextView lishi1;
    private TextView lishi2;
    private TextView lishi3;
    private boolean flages = true;
    private AlertDialog alertDialog;
    private Lishi_Adapter lishi_adapter;
    private TextView f1;
    private TextView f2;
    private TextView f3;
    private TextView f4;
    private TextView f5;
    private TextView f6;
    private ImageView select_xiao_icons;
    private boolean translucentStatus;
    private TextView f7;
    private TextView f8;
    private int colorzt;
    private RelativeLayout toolbar;
    private SystemBarTintManager tintManager;
    private NewPresenter newPresenter;
    private List<SelectBean.ResultsBean> selectlist;
    private Select_Myadapter select_myadapter;
    private RecyclerView select_recy;
    private PullToRefreshLayout select_pull;
    private ScrollView scrollview;
    private int num = 10;
    private int page = 1;
    private String edit_text;
    private Handler ler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            setAdapteraa();
            lishi_adapter.notifyDataSetChanged();
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_activity);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        initView();
//        scrollview.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        colorzt = intent.getIntExtra("color", 0);
        toolbar.setBackgroundColor(getResources().getColor(colorzt));
        tintManager.setStatusBarTintResource(colorzt);
        setOnClick();
        dao = DBHelper.getInstance(this).getDao();
        dbHelperData = getDBHelperData();
        select_xiao_icons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select_edit.setText("");
                select_xiao_icons.setVisibility(View.INVISIBLE);
            }
        });
        lefthua();
        select_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(select_edit.getText().toString().trim().equals("")) {
                    select_xiao_icons.setVisibility(View.INVISIBLE);
                }else {
                    select_xiao_icons.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        ler.sendMessage(new Message());
    }

    @Override
    protected void onResume() {
        super.onResume();
//        scrollview.setVisibility(View.VISIBLE);
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
    private void adapterItemclick() {
        lishi_adapter.setClickListener(new Lishi_Adapter.onclicklistener() {
            @Override
            public void setItemClick(View v, int pos) {
                String zt_text = dbHelperData.get(pos).getEdittext();
                select_edit.setText(zt_text);
                String edit_text = select_edit.getText().toString().trim();
                //网络请求数据
                scrollview.setVisibility(View.GONE);
                setPresenter_select("http://gank.io/api/", edit_text,num,page);
                LishiBean lishiBean = new LishiBean();
                dbHelperData = getDBHelperData();
                for (LishiBean lishi : dbHelperData) {
                    if (lishi.getEdittext().equals(edit_text)) {
                        flages = false;
                    }else {
                        flages = true;
                    }
                }
                if (flages) {
                    lishiBean.setEdittext(edit_text);
                    long insert = dao.insert(lishiBean);
                }
                ler.sendMessage(new Message());
            }
        });

    }

    private void add_DBhelper(String text) {
        select_edit.setText(text);
        String edit_text = select_edit.getText().toString().trim();
        //进行网络请求数据
        scrollview.setVisibility(View.GONE);
        setPresenter_select("http://gank.io/api/", edit_text,num,page);
        LishiBean lishiBean = new LishiBean();
        dbHelperData = getDBHelperData();
        for (LishiBean lishi : dbHelperData) {
            if (lishi.getEdittext().equals(edit_text)) {
                flages = false;
            }else {
                flages = true;
            }
        }
        if (flages) {
            lishiBean.setEdittext(edit_text);
            long insert = dao.insert(lishiBean);
        }
        dbHelperData = getDBHelperData();
        ler.sendMessage(new Message());
    }
    private void setAdapteraa() {
        lishi_adapter = new Lishi_Adapter(this, dbHelperData);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        lishi_recy.setLayoutManager(manager);
        lishi_recy.setAdapter(lishi_adapter);
        lishi_adapter.notifyDataSetChanged();
        adapterItemclick();
        lishi_adapter.setItemClear(new Lishi_Adapter.onitemclear() {
            @Override
            public void setItemClear(View v, int pos) {
                dbHelperData = getDBHelperData();
                dbHelperData.remove(dbHelperData.get(pos));
                dao.deleteAll();
                for(LishiBean lishi:dbHelperData) {
                    dao.insertOrReplace(lishi);
                }
                ler.sendMessage(new Message());
            }
        });
    }
    private void setPresenter_select(String baseurl,String keyname,int num,int pages) {
        newPresenter = new NewPresenter();
        newPresenter.attach(this);
        newPresenter.getNewData(baseurl,keyname,num,pages);
    }
    private void setAdapter_Select() {
        select_myadapter = new Select_Myadapter(HomeSelectActivity.this, selectlist);
        LinearLayoutManager manager = new LinearLayoutManager(HomeSelectActivity.this);
        select_recy.setLayoutManager(manager);
        select_recy.setAdapter(select_myadapter);
        select_myadapter.setItemClickeds(new Select_Myadapter.onitemclick() {
            @Override
            public void onItemClicked(View view, int pos) {
                Intent intent = new Intent(HomeSelectActivity.this,XiangQing_act.class);
                intent.putExtra("url",selectlist.get(pos).getUrl());
                startActivity(intent);
            }
        });
    }
    private void setOnClick() {
        select_btn_text.setOnClickListener(this);
        select_image.setOnClickListener(this);
        lishi_clear.setOnClickListener(this);
        f1.setOnClickListener(this);
        f2.setOnClickListener(this);
        f3.setOnClickListener(this);
        f4.setOnClickListener(this);
        f5.setOnClickListener(this);
        f6.setOnClickListener(this);
        f7.setOnClickListener(this);
        f8.setOnClickListener(this);
    }

    private void initView() {
        new ImmersionUtils().setImmersion(getWindow(), getSupportActionBar());
        select_btn_text = (TextView) findViewById(R.id.home_search_text);
        select_image = (ImageView) findViewById(R.id.home_search_image);
        select_edit = (EditText) findViewById(R.id.home_search_edit);
        lishi_recy = (RecyclerView) findViewById(R.id.lishi_recy);
        lishi_clear = (ImageView) findViewById(R.id.lishi_clear);
        lishi1 = (TextView) findViewById(R.id.lishi1);
        lishi2 = (TextView) findViewById(R.id.lishi2);
        lishi3 = (TextView) findViewById(R.id.lishi3);
        f1 = (TextView) findViewById(R.id.f1);
        f2 = (TextView) findViewById(R.id.f2);
        f3 = (TextView) findViewById(R.id.f3);
        f4 = (TextView) findViewById(R.id.f4);
        f5 = (TextView) findViewById(R.id.f5);
        f6 = (TextView) findViewById(R.id.f6);
        f7 = (TextView) findViewById(R.id.f7);
        f8 = (TextView) findViewById(R.id.f8);
        toolbar = (RelativeLayout) findViewById(R.id.toolbar);
        select_xiao_icons = (ImageView) findViewById(R.id.select_xiao_icons);
        select_recy = (RecyclerView) findViewById(R.id.select_recy);
        select_pull = (PullToRefreshLayout) findViewById(R.id.select_pull);
        scrollview = (ScrollView) findViewById(R.id.select_big);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_search_image:
                finish();
                overridePendingTransition(R.anim.showlefttoright, R.anim.hidelefttoright);
                break;
            case R.id.home_search_text:
                edit_text = select_edit.getText().toString().trim();
                //进行搜索数据
                LishiBean lishiBean = new LishiBean();
                dbHelperData = getDBHelperData();
                for (LishiBean lishi : dbHelperData) {
                    Log.d("aaa","历史记录"+lishi);
                    if (lishi.getEdittext().equals(edit_text)) {
                        scrollview.setVisibility(View.GONE);
                        setPresenter_select("http://gank.io/api/", edit_text,num,page);
                        flages = false;
                    } else {
                        flages = true;
                    }
                }
                if (flages) {
                    if (edit_text.equals("")) {
                        Toast.makeText(HomeSelectActivity.this,"请输入搜索内容",Toast.LENGTH_SHORT).show();
                    } else {
                        scrollview.setVisibility(View.GONE);
                        setPresenter_select("http://gank.io/api/", edit_text,num,page);
                        lishiBean.setEdittext(edit_text);
                        long insert = dao.insert(lishiBean);
                    }
                }
                dbHelperData = getDBHelperData();
                ler.sendMessage(new Message());
                break;
            case R.id.lishi_clear:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示");
                builder.setMessage("确认清空历史搜索吗？");
                builder.setNegativeButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dao.deleteAll();
                        dbHelperData = getDBHelperData();
                        ler.sendMessage(new Message());
                        dialogInterface.dismiss();
                    }
                });
                builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                alertDialog = builder.create();
                alertDialog.show();
                break;
            case R.id.f1:
                add_DBhelper(f1.getText().toString().trim());
                break;
            case R.id.f2:
                add_DBhelper(f2.getText().toString().trim());
                break;
            case R.id.f3:
                add_DBhelper(f3.getText().toString().trim());
                break;
            case R.id.f4:
                add_DBhelper(f4.getText().toString().trim());
                break;
            case R.id.f5:
                add_DBhelper(f5.getText().toString().trim());
                break;
            case R.id.f6:
                add_DBhelper(f6.getText().toString().trim());
                break;
            case R.id.f7:
                add_DBhelper(f7.getText().toString().trim());
                break;
            case R.id.f8:
                add_DBhelper(f8.getText().toString().trim());
                break;
        }
    }

    private List<LishiBean> getDBHelperData() {
        List<LishiBean> data_lishi = dao.loadAll();
        return data_lishi;
    }
    @Override
    public void onSuccess(Object o) {
        if(o instanceof SelectBean) {
            SelectBean bean = (SelectBean) o;
            if(bean != null) {
                selectlist = bean.getResults();
                setAdapter_Select();
                select_pull.setRefreshListener(new BaseRefreshListener() {
                    @Override
                    public void refresh() {
                        select_myadapter.notifyDataSetChanged();
                    }
                    @Override
                    public void loadMore() {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                num+=10;
                                setPresenter_select("http://gank.io/api/",edit_text,num,page);
                                setAdapter_Select();
                                select_myadapter.notifyDataSetChanged();
                                select_pull.finishLoadMore();
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
