package com.lwh.mystudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.lwh.mystudy.view.MyProgressView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ${lwh} on 2018/2/1.
 *
 * @descirbe
 */

public class MyProgressViewActivity extends AppCompatActivity {
    @BindView(R.id.progress1)
    MyProgressView progress1;
    @BindView(R.id.progress2)
    MyProgressView progress2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_ivew);
        ButterKnife.bind(this);

        progress1.setmColor(ContextCompat.getColor(this,R.color.red));
        progress1.setmPercent(50);

        progress2.setmColor(ContextCompat.getColor(this,R.color.red));
        progress2.setmPercent(80);
    }
}
