package zhangtao.bwie.com.lgank;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import me.imid.swipebacklayout.lib.SwipeBackLayout;

/**
 * Created by ZhangTAO on 2017/12/19.
 */

public class ThemeAct extends AppCompatActivity implements View.OnClickListener{
    private Button yellow;
    private Button red;
    private Button green;
    private Button zise;
    private Button blue;
    private Button black;
    private int colorzt = 0;
    private RelativeLayout toolbar;
    private ImageView backimg;
    private SystemBarTintManager tintManager;
    private boolean translucentStatus;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;
    private SwipeBackLayout swipeBackLayout;
    private boolean flag= true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme_item);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        initView();
        setClick();
        Intent intent = getIntent();
        colorzt = intent.getIntExtra("colzt",0);
        toolbar.setBackgroundColor(getResources().getColor(colorzt));
        tintManager.setStatusBarTintResource(colorzt);
        sharedPreferences = getSharedPreferences("colors", Context.MODE_PRIVATE);
        edit = sharedPreferences.edit();
    }

//    private void lefthua() {
//        setSwipeBackEnable(true);
//        swipeBackLayout = getSwipeBackLayout();
//        //设置滑动方向
//        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
//        edit.putInt("zt_color",colorzt);
//        edit.commit();
//        if(flag == false) {
//            jump();
//        }else {
//
//        }
//    }
    private void jump() {
        Intent intent = new Intent(ThemeAct.this,Two_activity.class);
        if(colorzt != 0) {
            intent.putExtra("color",colorzt);
            startActivity(intent);
            overridePendingTransition(R.anim.showlefttoright,R.anim.hidelefttoright);
        }else {
            startActivity(intent);
            overridePendingTransition(R.anim.showlefttoright,R.anim.hidelefttoright);
        }
        finish();
    }
    private void setClick() {
        yellow.setOnClickListener(this);
        red.setOnClickListener(this);
        green.setOnClickListener(this);
        zise.setOnClickListener(this);
        blue.setOnClickListener(this);
        black.setOnClickListener(this);
        backimg.setOnClickListener(this);
    }

    private void initView() {
        yellow = (Button) findViewById(R.id.btn_yellow);
        red = (Button) findViewById(R.id.btn_red);
        green = (Button) findViewById(R.id.btn_green);
        zise = (Button) findViewById(R.id.btn_zise);
        blue = (Button) findViewById(R.id.btn_blues);
        black = (Button) findViewById(R.id.btn_black);
        toolbar = (RelativeLayout) findViewById(R.id.toolbar);
        backimg = (ImageView) findViewById(R.id.home_search_image);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_yellow:
                colorzt = R.color.yellows;
                toolbar.setBackgroundColor(getResources().getColor(colorzt));
                tintManager.setStatusBarTintResource(colorzt);
                edit.putInt("zt_color",colorzt);
                edit.commit();
                flag = false;
                break;
            case R.id.btn_red:
                colorzt = R.color.reds;
                toolbar.setBackgroundColor(getResources().getColor(colorzt));
                tintManager.setStatusBarTintResource(colorzt);
                edit.putInt("zt_color",colorzt);
                edit.commit();
                flag = false;
                break;
            case R.id.btn_green:
                colorzt = R.color.greens;
                toolbar.setBackgroundColor(getResources().getColor(colorzt));
                tintManager.setStatusBarTintResource(colorzt);
                edit.putInt("zt_color",colorzt);
                edit.commit();
                flag = false;
                break;
            case R.id.btn_zise:
                colorzt = R.color.zise;
                toolbar.setBackgroundColor(getResources().getColor(colorzt));
                tintManager.setStatusBarTintResource(colorzt);
                edit.putInt("zt_color",colorzt);
                edit.commit();
                flag = false;
                break;
            case R.id.btn_blues:
                colorzt = R.color.blues;
                toolbar.setBackgroundColor(getResources().getColor(colorzt));
                tintManager.setStatusBarTintResource(colorzt);
                edit.putInt("zt_color",colorzt);
                edit.commit();
                flag = false;
                break;
            case R.id.btn_black:
                colorzt = R.color.blacks;
                toolbar.setBackgroundColor(getResources().getColor(colorzt));
                tintManager.setStatusBarTintResource(colorzt);
                edit.putInt("zt_color",colorzt);
                edit.commit();
                flag = false;
                break;
            case R.id.home_search_image:
                Intent intent = new Intent(ThemeAct.this,Two_activity.class);
                if(colorzt != 0) {
                    intent.putExtra("color",colorzt);
                    startActivity(intent);
                    overridePendingTransition(R.anim.showlefttoright,R.anim.hidelefttoright);
                }else {
                    startActivity(intent);
                    overridePendingTransition(R.anim.showlefttoright,R.anim.hidelefttoright);
                }
                finish();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intent intent = new Intent(ThemeAct.this,Two_activity.class);
        if(colorzt != 0) {
            intent.putExtra("color",colorzt);
            startActivity(intent);
            overridePendingTransition(R.anim.showlefttoright,R.anim.hidelefttoright);
        }else {
            startActivity(intent);
            overridePendingTransition(R.anim.showlefttoright,R.anim.hidelefttoright);
        }
        finish();
        return super.onKeyDown(keyCode, event);
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
        finish();
    }
}
