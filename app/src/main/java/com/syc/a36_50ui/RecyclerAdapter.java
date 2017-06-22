package com.syc.a36_50ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * 类描述:
 * 创建人:一一哥
 * 创建时间:16/10/17 15:30
 * 备注:
 */

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    List<Map<String, String>> mList;
    private Context mContext;

    interface OnRecylcerItemClickListener {
        void onItemClick(View v, int position);
    }

    private static OnRecylcerItemClickListener mListener;

    public void setOnRecylcerItemClickListener(OnRecylcerItemClickListener listener) {
        mListener = listener;
    }

    RecyclerAdapter(List<Map<String, String>> list, Context context) {
        this.mList = list;
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String name = mList.get(position).get("name");
        String logo = mList.get(position).get("logo");
        holder.tvName.setText(name);
        //根据图片名称得到该图片对应的id
        int logoId = mContext.getResources().getIdentifier(logo, "mipmap", mContext.getPackageName());
        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), logoId);
        holder.ivLogo.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView ivLogo;
        private TextView tvName;

        MyViewHolder(View itemView) {
            super(itemView);
            ivLogo = (ImageView) itemView.findViewById(R.id.iv_logo);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onItemClick(v,getAdapterPosition());
        }
    }

}
