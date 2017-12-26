package MyAdapter_List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import Bean.SelectBean;
import zhangtao.bwie.com.lgank.HomeSelectActivity;
import zhangtao.bwie.com.lgank.R;

/**
 * Created by ZhangTAO on 2017/12/18.
 */

public class Select_Myadapter extends XRecyclerView.Adapter<Select_Myadapter.ViewHolder>{
    private Context context;
    private List<SelectBean.ResultsBean> alist;
    public Select_Myadapter(HomeSelectActivity activity, List<SelectBean.ResultsBean> selectlist) {
        this.context = activity;
        this.alist = selectlist;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View xreyc3 = View.inflate(context, R.layout.xrecy1_item, null);
        ViewHolder xrecy3_vh = new ViewHolder(xreyc3);
        return xrecy3_vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String images = alist.get(position).getUrl();
                DraweeController Controller = Fresco.newDraweeControllerBuilder()
                        .setAutoPlayAnimations(true)
                        //设置uri,加载本地的gif资源
                        .setUri(images)//设置uri
                        .build();
        holder.sim_icons.setController(Controller);
        holder.desc.setText(alist.get(position).getDesc());
        holder.who.setText(alist.get(position).getWho());
        String publishedAt = alist.get(position).getPublishedAt();
        String substring = publishedAt.substring(0, 10);
        holder.times.setText(substring);
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mitemclick.onItemClicked(view,position);
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

    class ViewHolder extends XRecyclerView.ViewHolder {
        private SimpleDraweeView sim_icons;
        private TextView desc;
        private TextView who;
        private TextView times;
        private View root;
        public ViewHolder(View itemView) {
            super(itemView);
            root = itemView;
            sim_icons = itemView.findViewById(R.id.sim_icons);
            desc = itemView.findViewById(R.id.desc);
            who = itemView.findViewById(R.id.whos);
            times = itemView.findViewById(R.id.times);
        }
    }
    private onitemclick mitemclick;
    public void setItemClickeds(onitemclick itemClickeds) {
        this.mitemclick = itemClickeds;
    }
    public interface onitemclick {
        void onItemClicked(View view, int pos);
    }
}
