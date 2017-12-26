package zhangtao.bwie.com.lgank;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.ArrayList;
import java.util.List;

import Frag.Frag1;
import Frag.Frag2;
import Frag.Frag3;
import ImmerSionUtil.ImmersionUtils;

/**
 * Created by ZhangTAO on 2017/12/17.
 */

public class Two_activity extends AppCompatActivity implements View.OnClickListener{
    private DrawerLayout drawerlayout;
    private ViewPager vps;
    private TabLayout jpbar;
    private List<Fragment> fraglist = new ArrayList<>();
    private ImageView quest_img;
    private NavigationView nav_act;
    private View headerView;
    private int colorzt = R.color.yellow;
    private RelativeLayout toolbars;
    private List<String> textlists = new ArrayList<>();
    private SystemBarTintManager tintManager;
    private boolean translucentStatus;
    private SharedPreferences colors_shape;
    private SharedPreferences.Editor edit;
    private SharedPreferences two_share;
    private int[] icons = {R.drawable.bottom_home,R.drawable.bottom_read,R.drawable.bottom_me};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2_activity);
        new ImmersionUtils().setImmersion(getWindow(), getSupportActionBar());
        two_share = getSharedPreferences("colors", Context.MODE_PRIVATE);
        fraglist.add(new Frag1());
        fraglist.add(new Frag2());
        fraglist.add(new Frag3());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        initView();
        colorzt = two_share.getInt("zt_color", R.color.yellow);
        MyAdapterzt myAdapterzt = new MyAdapterzt(getSupportFragmentManager(), fraglist);
        vps.setAdapter(myAdapterzt);
        jpbar.setupWithViewPager(vps);
        for(int i=0;i<textlists.size();i++) {
            jpbar.getTabAt(i).setIcon(icons[i]);
            jpbar.getTabAt(i).setIcon(icons[i]);
            jpbar.getTabAt(i).setIcon(icons[i]);
        }
        quest_img.setOnClickListener(this);
        tintManager.setStatusBarTintResource(this.colorzt);
        jpbar.setTabTextColors(Color.GRAY, getResources().getColor(this.colorzt));
        toolbars.setBackgroundColor(getResources().getColor(this.colorzt));
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Two_activity.this, "头部", Toast.LENGTH_SHORT).show();
            }
        });
        nav_act.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId) {
                    case R.id.web:
                        Intent intent1 = new Intent(Two_activity.this, QianDaun.class);
                        startActivity(intent1);
                        overridePendingTransition(R.anim.showrighttoleft,R.anim.hiderighttoleft);
                        break;
                    case R.id.xia_tuijian:
                        Intent intent2 = new Intent(Two_activity.this, Xia_act.class);
                        startActivity(intent2);
                        overridePendingTransition(R.anim.showrighttoleft,R.anim.hiderighttoleft);
                        break;
                    case R.id.app_demo:
                        Intent intent3 = new Intent(Two_activity.this, App_act.class);
                        startActivity(intent3);
                        overridePendingTransition(R.anim.showrighttoleft,R.anim.hiderighttoleft);
                        break;
                    case R.id.tuozhan:
                        Intent intent4 = new Intent(Two_activity.this, Tuo_act.class);
                        startActivity(intent4);
                        overridePendingTransition(R.anim.showrighttoleft,R.anim.hiderighttoleft);
                        break;
                    case R.id.video:
                        Intent intent5 = new Intent(Two_activity.this, Video_act.class);
                        startActivity(intent5);
                        overridePendingTransition(R.anim.showrighttoleft,R.anim.hiderighttoleft);
                        break;
                    case R.id.qie_color:
                        Intent intent = new Intent(Two_activity.this, ThemeAct.class);
                        intent.putExtra("colzt", Two_activity.this.colorzt);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
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

    private class MyAdapterzt extends FragmentPagerAdapter {
        private List<Fragment> alist;
        public MyAdapterzt(FragmentManager supportFragmentManager, List<Fragment> fraglist) {
            super(supportFragmentManager);
            this.alist = fraglist;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return textlists.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
            bundle.putInt("color",colorzt);
            if(textlists.get(position).equals("Home")) {
                Frag1 frag1 = new Frag1();
                frag1.setArguments(bundle);
                return frag1;
            }else if(textlists.get(position).equals("Read")) {
                Frag2 frag2 = new Frag2();
                frag2.setArguments(bundle);
                return frag2;
            }else {
                Frag3 frag3 = new Frag3();
                frag3.setArguments(bundle);
                return frag3;
            }
        }
        @Override
        public int getCount() {
           return textlists.size();
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
        }
    }
    private void initView() {
        drawerlayout = (DrawerLayout) findViewById(R.id.drawer_act);
        vps = (ViewPager) findViewById(R.id.vps);
        jpbar = (TabLayout) findViewById(R.id.jpbar);
        quest_img = (ImageView) findViewById(R.id.quest_img);
        nav_act = (NavigationView) findViewById(R.id.nav_act);
        headerView = nav_act.getHeaderView(0);
        toolbars = (RelativeLayout) findViewById(R.id.toolsbars);
        textlists.clear();
        textlists.add("Home");
        textlists.add("Read");
        textlists.add("Me");
        jpbar.setSelectedTabIndicatorHeight(0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.quest_img:
                Intent intent = new Intent(this,HomeSelectActivity.class);
                intent.putExtra("color",colorzt);
                startActivity(intent);
                overridePendingTransition(R.anim.showrighttoleft,R.anim.hiderighttoleft);
                break;
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        colorzt = intent.getIntExtra("color", 0);
        if(colorzt != 0) {
            toolbars.setBackgroundColor(getResources().getColor(colorzt));
            jpbar.setTabTextColors(Color.GRAY,getResources().getColor(colorzt));
            tintManager.setStatusBarTintResource(colorzt);
        }
    }
}
