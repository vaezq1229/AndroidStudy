package com.lwh.mystudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;

import com.lwh.mystudy.adapter.SwipeQuickAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ${lwh} on 2017/11/24.
 *
 * @descirbe swipe嵌套recycleview
 */

public class SwipRecycleActivity extends AppCompatActivity {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_recycleview);
        ButterKnife.bind(this);

        recycleView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<String> data = new ArrayList<>();
        data.add("");
        data.add("");
        data.add("");
        data.add("");
        data.add("");
        data.add("");
        data.add("");
        recycleView.setHasFixedSize(true);
        recycleView.setAdapter(new SwipeQuickAdapter(data));

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
    }
}
