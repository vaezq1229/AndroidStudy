package com.lwh.mystudy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lwh.mystudy.view.GradientView;

/**
 * 自定义view
 * Created by ${lwh} on 2017/8/17.
 */

public class CustomViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (getIntent().getStringExtra("type")){
            case Constant.GRADIENT:
                setContentView(new GradientView(this));
                break;
        }
    }

    public  static void launch(Context context,String type){
        Intent intent = new Intent(context,CustomViewActivity.class);
        intent.putExtra("type",type);
        context.startActivity(intent);
    }

}
