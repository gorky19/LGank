package zhangtao.bwie.com.lgank;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;

import java.util.ArrayList;
import java.util.List;

import me.relex.photodraweeview.OnPhotoTapListener;
import me.relex.photodraweeview.PhotoDraweeView;

/**
 * Created by ZhangTAO on 2017/12/20.
 */

public class PhoneActivity extends Activity{

    private PhotoDraweeView phone_icons;
    private String iconsulr;
    private PipelineDraweeControllerBuilder controller;
    private ImageView backs;
    private List<String> urllist = new ArrayList<>();
    private int id;
    private String urlimg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.phone_act);
        phone_icons = (PhotoDraweeView) findViewById(R.id.phone_icons);
        backs = findViewById(R.id.back_icons);
        Intent intent = getIntent();
        urlimg = intent.getStringExtra("urlimg");
        backs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        initData();
        initEvent();
    }

    private void initEvent() {
        phone_icons.setOnPhotoTapListener(new OnPhotoTapListener() {
            @Override
            public void onPhotoTap(View view, float x, float y) {
                finish();
            }
        });
    }

    private void initData() {
        if(!TextUtils.isEmpty(urlimg)) {
            controller = Fresco.newDraweeControllerBuilder();
            controller.setUri(urlimg);
            controller.setOldController(phone_icons.getController());
            controller.setControllerListener(new BaseControllerListener<ImageInfo>() {
                @Override
                public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                    super.onFinalImageSet(id, imageInfo, animatable);
                    if(imageInfo == null || phone_icons == null) {
                        return;
                    }
                     phone_icons.update(imageInfo.getWidth(),imageInfo.getHeight());
                }
            });
                phone_icons.setController(controller.build());
        }else {
            Toast.makeText(this,"图片获取失败", Toast.LENGTH_SHORT).show();
        }
    }
}
