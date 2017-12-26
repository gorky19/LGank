package zhangtao.bwie.com.lgank;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
/**
 * Created by ZhangTAO on 2017/11/16.
 */

public class My_Recy extends RecyclerView{
    public My_Recy(Context context) {
        this(context,null);
    }
    public My_Recy(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public My_Recy(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expanSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec,expanSpec);
    }
}
