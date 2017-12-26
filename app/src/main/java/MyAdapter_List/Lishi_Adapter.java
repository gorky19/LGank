package MyAdapter_List;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import Bean.LishiBean;
import zhangtao.bwie.com.lgank.HomeSelectActivity;
import zhangtao.bwie.com.lgank.R;

/**
 * Created by ZhangTAO on 2017/12/8.
 */

public class Lishi_Adapter extends RecyclerView.Adapter<Lishi_Adapter.ViewHolder>{
    private Context context;
    private List<LishiBean> alist;
    public Lishi_Adapter(HomeSelectActivity homeSelectActivity, List<LishiBean> dbHelperData) {
        this.context = homeSelectActivity;
        this.alist = dbHelperData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v1 = View.inflate(context, R.layout.lishi_item, null);
        ViewHolder vh1 = new ViewHolder(v1);
        return vh1;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.jilu.setText(alist.get(position).getEdittext());
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monclick.setItemClick(view,position);
            }
        });
        holder.clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mitem.setItemClear(view,position);
            }
        });
    }
    @Override
    public int getItemCount() {
        if(alist == null) {
            return 0;
        }
        return alist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView jilu;
        private ImageView clear;
        private View root;
        public ViewHolder(View itemView) {
            super(itemView);
            this.root = itemView;
            jilu = itemView.findViewById(R.id.jilu_item);
            clear = itemView.findViewById(R.id.clear);
        }
    }
    private onclicklistener monclick;
    public void setClickListener(onclicklistener monclick) {
        this.monclick = monclick;
    }
    public interface onclicklistener {
        void setItemClick(View v, int pos);
    }
    //删除
    private onitemclear mitem;
    public void setItemClear(onitemclear monclick) {
        this.mitem = monclick;
    }
    public interface onitemclear {
        void setItemClear(View v,int pos);
    }
}
