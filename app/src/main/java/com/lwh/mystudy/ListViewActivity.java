package com.lwh.mystudy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lwh.mystudy.adapter.MyBaseAdapter;
import com.lwh.mystudy.interfaces.OnItemClickCallBack;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ${lwh} on 2017/8/17.
 */

public class ListViewActivity extends AppCompatActivity implements OnItemClickCallBack {
    String[] data_custom = {Constant.GRADIENT, Constant.STROKE_JOIN, Constant.PATH_EFFECT,Constant.DRAW_CIRCLE,Constant.DRAW_BIE
    ,Constant.DRAW_TEXT,Constant.DRAW_CLIP,Constant.DRAW_ANIMATION};
    @BindView(R.id.recycleView)
    RecyclerView recycleView;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ListViewActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        ButterKnife.bind(this);

        recycleView.setLayoutManager(new LinearLayoutManager(this));

        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(data_custom);
        myBaseAdapter.setmOnItemClickCallBack(this);
        recycleView.setAdapter(myBaseAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        CustomViewActivity.launch(this, data_custom[position]);
    }
}
