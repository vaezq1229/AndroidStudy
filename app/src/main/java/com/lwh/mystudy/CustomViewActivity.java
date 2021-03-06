package com.lwh.mystudy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lwh.mystudy.view.AnimationView;
import com.lwh.mystudy.view.BieChartView;
import com.lwh.mystudy.view.DrawCircleView;
import com.lwh.mystudy.view.GradientView;
import com.lwh.mystudy.view.MyBieChartView;
import com.lwh.mystudy.view.MyClipView;
import com.lwh.mystudy.view.MyTextView;
import com.lwh.mystudy.view.PathEffectView;
import com.lwh.mystudy.view.StrokeJoinView;

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
            case Constant.STROKE_JOIN:
                setContentView(new StrokeJoinView(this));
                break;
            case Constant.PATH_EFFECT:
                setContentView(new PathEffectView(this));
                break;
            case Constant.DRAW_CIRCLE:
                setContentView(new DrawCircleView(this));
                break;
            case Constant.DRAW_BIE:
                setContentView(new MyBieChartView(this));
                break;
            case Constant.DRAW_TEXT:
                setContentView(new MyTextView(this));
                break;
            case Constant.DRAW_CLIP:
                setContentView(new MyClipView(this));
                break;
                case Constant.DRAW_ANIMATION:
                setContentView(new AnimationView(this));
                break;
        }
    }

    public  static void launch(Context context,String type){
        Intent intent = new Intent(context,CustomViewActivity.class);
        intent.putExtra("type",type);
        context.startActivity(intent);
    }

}
