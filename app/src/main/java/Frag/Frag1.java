package Frag;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import zhangtao.bwie.com.lgank.R;

/**
 * Created by ZhangTAO on 2017/12/17.
 */

public class Frag1 extends Fragment{
    private TabLayout tablayout;
    private ViewPager f1_vps;
    private List<String> textlist = new ArrayList<>();
    private List<Fragment> f1_fraglist = new ArrayList<>();
    private MyAdapter_tab myAdapter_tab;
    private int colorzt = R.color.yellow;
    private SharedPreferences f1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v1 = inflater.inflate(R.layout.f1, null);
//        EventBus.getDefault().register(Frag1.this);
        initView(v1);
        return v1;
    }
    @Override
    public void onStart() {
        super.onStart();
        f1 = getActivity().getSharedPreferences("colors", Context.MODE_PRIVATE);
        colorzt = f1.getInt("zt_color", R.color.yellow);
        tablayout.setSelectedTabIndicatorColor(getResources().getColor(colorzt));
        tablayout.setTabTextColors(Color.GRAY,getResources().getColor(colorzt));
//        EventBus.getDefault().post(new EventManages2(colorzt));
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        settextlist();
        tablayout.setTabTextColors(Color.GRAY,getResources().getColor(colorzt));
        tablayout.setSelectedTabIndicatorColor(getResources().getColor(colorzt));
        myAdapter_tab = new MyAdapter_tab(getActivity().getSupportFragmentManager(),f1_fraglist);
        f1_vps.setAdapter(myAdapter_tab);
        tablayout.setupWithViewPager(f1_vps);
    }
//    @Subscribe
//    public void getColor(EventManages event) {
//        colorzt = event.getColoszt();
//        tablayout.setSelectedTabIndicatorColor(getResources().getColor(colorzt));
//        tablayout.setTabTextColors(Color.GRAY,getResources().getColor(colorzt));
//    }
    private void settextlist() {
        textlist.clear();
        textlist.add("ANDROID");
        textlist.add("IOS");
        textlist.add("福利");
        f1_fraglist.add(new f1_Frag1s());
        f1_fraglist.add(new f2_Frag2s());
        f1_fraglist.add(new f3_Frag3s());
    }
    private void initView(View v1) {
        tablayout = v1.findViewById(R.id.tabbar);
        f1_vps = v1.findViewById(R.id.f1_vps);
    }
    private class MyAdapter_tab extends FragmentPagerAdapter{
        private List<Fragment> alist;
        public MyAdapter_tab(FragmentManager supportFragmentManager, List<Fragment> f1_fraglist) {
            super(supportFragmentManager);
            this.alist = f1_fraglist;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return textlist.get(position);
        }
        @Override
        public Fragment getItem(int position) {
            return alist.get(position);
        }
        @Override
        public int getCount() {
            return textlist.size();
        }
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
