package MyAdapter_List;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import Bean.FuliBean;
import zhangtao.bwie.com.lgank.R;

/**
 * Created by ZhangTAO on 2017/12/18.
 */

public class Myadapter_xrecy4 extends RecyclerView.Adapter<Myadapter_xrecy4.ViewHolder>{
    private Context context;
    private List<FuliBean.ResultsBean> alist;
    public Myadapter_xrecy4(FragmentActivity activity, List<FuliBean.ResultsBean> results4) {
        this.context = activity;
        this.alist = results4;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View fuli = View.inflate(context, R.layout.fuli_item, null);
        ViewHolder fuli_vh = new ViewHolder(fuli);
        return fuli_vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.fu_img.setImageURI(alist.get(position).getUrl());
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
            return  0;
        }
        return alist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView fu_img;
        private View root;
        public ViewHolder(View itemView) {
            super(itemView);
            root = itemView;
            fu_img = itemView.findViewById(R.id.fuli_icons);
        }
    }
    private onitemclick mitemclick;
    public void setItemClickeds(onitemclick itemClickeds) {
        this.mitemclick = itemClickeds;
    }
    public interface onitemclick {
        void onItemClicked(View view,int pos);
    }
}
