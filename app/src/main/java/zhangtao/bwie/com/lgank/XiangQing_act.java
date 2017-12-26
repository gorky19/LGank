package zhangtao.bwie.com.lgank;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import ImmerSionUtil.ImmersionUtils;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by ZhangTAO on 2017/12/18.
 */

public class XiangQing_act extends SwipeBackActivity implements View.OnClickListener{
    private WebView webs;
    private ImageView backs_img;
    private String url;
    private SystemBarTintManager tintManager;
    private boolean translucentStatus;
    private int colorzt;
    private RelativeLayout toolbar;
    private SharedPreferences xiangqing_share;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_act);
        new ImmersionUtils().setImmersion(getWindow(), getSupportActionBar());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        webs = (WebView) findViewById(R.id.web_view);
        toolbar = (RelativeLayout) findViewById(R.id.toolbar);
        backs_img = (ImageView) findViewById(R.id.img_back);
        backs_img.setOnClickListener(this);
        xiangqing_share = getSharedPreferences("colors", Context.MODE_PRIVATE);
        colorzt = xiangqing_share.getInt("zt_color", 0);
        WebSettings settings = webs.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setJavaScriptEnabled(true);
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        toolbar.setBackgroundColor(getResources().getColor(colorzt));
        tintManager.setStatusBarTintResource(colorzt);
        webs.loadUrl(url);
        lefthua();
    }
    private void lefthua() {
        setSwipeBackEnable(true);
        SwipeBackLayout swipeBackLayout = getSwipeBackLayout();
        //设置滑动方向
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
