package ImmerSionUtil;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.Window;

/**
 * Created by ZhangTAO on 2017/12/17.
 */

public class ImmersionUtils {
    public void setImmersion(Window window, ActionBar supprotActionBar) {
        if(window != null) {
            if(Build.VERSION.SDK_INT >= 21) {
                View decorView = window.getDecorView();
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(option);
                window.setStatusBarColor(Color.TRANSPARENT);
            }
        }
        if(supprotActionBar != null) {
            ActionBar actionBar = supprotActionBar;
            actionBar.hide();
        }
    }
}
