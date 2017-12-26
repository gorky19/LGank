package zhangtao.bwie.com.lgank;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;

import ImmerSionUtil.ImmersionUtils;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by ZhangTAO on 2017/12/20.
 */

public class PhoneActivity2 extends SwipeBackActivity {
    private ImageView backs;
    private int id;
    private ArrayList<String> alist = new ArrayList<>();
    private HackViewPager vps;
    private PhotoView photoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.phone_act2);
        new ImmersionUtils().setImmersion(getWindow(), getSupportActionBar());
        vps = (HackViewPager) findViewById(R.id.photo2_vps);
        backs = (ImageView) findViewById(R.id.back_icons);
        Intent getintent = getIntent();
        alist = getintent.getStringArrayListExtra("list");
        id = getintent.getIntExtra("id",123);
        backs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        vps.setAdapter(new SimplePagerAdapter());
        vps.setCurrentItem(id);
        lefthua();
    }
    private void lefthua() {
        setSwipeBackEnable(true);
        SwipeBackLayout swipeBackLayout = getSwipeBackLayout();
        //设置滑动方向
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
    }
    private class SimplePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return alist.size();
        }
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            photoView = new PhotoView(container.getContext());
            PhotoViewAttacher attacher = new PhotoViewAttacher(photoView);
            Glide.with(container.getContext()).load(alist.get(position)).into(photoView);
            attacher.update();
            photoView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
