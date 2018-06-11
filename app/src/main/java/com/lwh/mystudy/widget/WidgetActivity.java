package com.lwh.mystudy.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.lwh.mystudy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ${lwh} on 2017/11/29.
 *
 * @descirbe
 */

public class WidgetActivity extends AppCompatActivity {
    @BindView(R.id.switcher)
    TextSwitcher switcher;
    @BindView(R.id.switcher2)
    TextSwitcher switcher2;

    private String[] str = {"测试1","测试2","测试3"};

    private int position = 0 ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);
        ButterKnife.bind(this);

        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView tv = new TextView(WidgetActivity.this);
                tv.setTextSize(40);
                // 字体颜色品红
                tv.setTextColor(ContextCompat.getColor(WidgetActivity.this,android.R.color.holo_red_light));
                return tv;
            }
        });
        switcher.postDelayed(runnable,0);


        switcher2.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView tv = new TextView(WidgetActivity.this);
                tv.setTextSize(40);
                // 字体颜色品红
                tv.setTextColor(ContextCompat.getColor(WidgetActivity.this,android.R.color.holo_red_light));
                return tv;
            }
        });
        //测试
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            switcher.setText(str[position++ % str.length]);
            switcher2.setText(str[position++ % str.length]);
            switcher.postDelayed(runnable, 2000);
        }
    };
}
