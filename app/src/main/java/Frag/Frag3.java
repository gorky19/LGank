package Frag;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;
import zhangtao.bwie.com.lgank.R;

/**
 * Created by ZhangTAO on 2017/12/17.
 */

public class Frag3 extends Fragment implements View.OnClickListener{
    private int colorzt;
    private CircleImageView user_img;
    private Button btn_pick;
    private Button photo;
    private Button cancal;
    private AlertDialog dialog;
    private SharedPreferences.Editor f3_edit;
    private static String path="/sdcard/myHead";
    private SharedPreferences f3_share;
    private Bitmap bits;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v3 = inflater.inflate(R.layout.f3, null);
//        Fresco.initialize(getContext());
        initView(v3);
        return v3;
    }

    @Override
    public void onResume() {
        super.onResume();
        bits = null;
        String icon = f3_share.getString("icon", "");
        if(icon != "") {
            byte[] decode = Base64.decode(icon.getBytes(), 1);
            bits = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            user_img.setImageBitmap(bits);
        }
    }

    private void initView(View v3) {
        user_img = v3.findViewById(R.id.user_img);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        f3_share = getActivity()
                .getSharedPreferences("colors", Context.MODE_PRIVATE);
        f3_edit = f3_share.edit();
        setOnCliek();
    }
    private void setOnCliek() {
        user_img.setOnClickListener(this);
    }
    private void invokepics() {
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);//相机
        intent.putExtra(MediaStore.EXTRA_OUTPUT,
        Uri.fromFile(new File(Environment.getExternalStorageDirectory(),"userimg.jpg")));
        startActivityForResult(intent,200);
    }
    private void invokepics2() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_PICK);//系统相册
        intent.setType("image/*");
        startActivityForResult(intent,250);
    }
    private void showTypeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        dialog = builder.create();
        //设置AlertDialog的弹出位置
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        //设置AlertDialog的透明度
//        WindowManager.LayoutParams attributes = window.getAttributes();
//        attributes.alpha = 0.6f;
        View inflate = View.inflate(getContext(), R.layout.qie_head, null);
        btn_pick = inflate.findViewById(R.id.pick);
        photo = inflate.findViewById(R.id.photo);
        cancal = inflate.findViewById(R.id.canale);
        btn_pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                invokepics2();
                dialog.dismiss();
            }
        });
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                invokepics();
                dialog.dismiss();
            }
        });
        cancal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.setView(inflate);
        dialog.show();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_img:
                showTypeDialog();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 250) {
            //Uri:统一资源定位符
            Uri icons = data.getData();
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            f3_edit.commit();
            crop(icons);
        }
        if(requestCode == 200) {
            File file = new File(Environment.getExternalStorageDirectory() + "/userimg.jpg");
            crop(Uri.fromFile(file));
              //保存SD卡
//            if(data != null) {
//                Bundle extras = data.getExtras();
//                Bitmap head = extras.getParcelable("data");
//                if(head != null) {
//                    setPicToView(head);
//                    user_img.setImageBitmap(head);
//                }
//            }
        }
        if(requestCode == 9999) {
            //得到裁剪后的图片并显示
            Bitmap bit = data.getParcelableExtra("data");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bit.compress(Bitmap.CompressFormat.JPEG,50,byteArrayOutputStream);
            String headimg = new String(Base64.encodeToString(byteArrayOutputStream.toByteArray(),Base64.DEFAULT));
            f3_edit.putString("icon",headimg);
            f3_edit.commit();
            user_img.setImageBitmap(bit);
        }
    }
    private void crop(Uri uri) {
        // 裁剪图片意图
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        //是否裁剪
        intent.putExtra("crop", "true");
        // 裁剪框的比例，1：1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 裁剪后输出图片的尺寸大小
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);
        intent.putExtra("outputFormat", "JPEG");// 图片格式
        intent.putExtra("noFaceDetection", false);// 取消人脸识别
        // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_CUT
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 9999);
    }
    private void setPicToView(Bitmap mBitmap) {
        String sdStatus = Environment.getExternalStorageState();
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
            return;
        }
        FileOutputStream b = null;
        File file = new File(path);
        file.mkdirs();// 创建文件夹
        String fileName = path + "userimg.jpg";// 图片名字
        try {
            b = new FileOutputStream(fileName);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
            // 关闭流
            b.flush();
            b.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
