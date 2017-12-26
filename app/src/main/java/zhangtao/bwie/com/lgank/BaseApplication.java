package zhangtao.bwie.com.lgank;

import android.app.Application;
import android.os.StrictMode;

/**
 * Created by ZhangTAO on 2017/12/21.
 */

public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //解决7.0系统拍照的问题
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();
    }
}
