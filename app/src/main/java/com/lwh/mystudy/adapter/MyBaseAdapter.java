package com.lwh.mystudy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lwh.mystudy.R;
import com.lwh.mystudy.interfaces.OnItemClickCallBack;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ${lwh} on 2017/8/17.
 */

public class MyBaseAdapter extends RecyclerView.Adapter<MyBaseAdapter.MyHolder> {

    private String[] data;
    private OnItemClickCallBack mOnItemClickCallBack;


    public MyBaseAdapter(String[] data) {
        this.data = data;
    }

    public void setmOnItemClickCallBack(OnItemClickCallBack mOnItemClickCallBack) {
        this.mOnItemClickCallBack = mOnItemClickCallBack;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHolder holder = new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        holder.tv.setText(data[position]);
        if(mOnItemClickCallBack != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickCallBack.onItemClick(holder.itemView,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv)
        TextView tv;
        public MyHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
