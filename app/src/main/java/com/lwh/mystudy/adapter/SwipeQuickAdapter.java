package com.lwh.mystudy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lwh.mystudy.R;

import java.util.ArrayList;

/**
 * Created by ${lwh} on 2017/11/24.
 *
 * @descirbe
 */

public class SwipeQuickAdapter extends RecyclerView.Adapter{

    private ArrayList<String> data;

    public SwipeQuickAdapter(ArrayList<String> data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_swipe_recycleview,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class MyHolder extends RecyclerView.ViewHolder{

        public MyHolder(View itemView) {
            super(itemView);
        }
    }
}
