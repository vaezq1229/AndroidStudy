package com.lwh.mystudy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lwh.mystudy.viewpagers.ViewPagerActivity;
import com.lwh.mystudy.widget.WidgetActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity  {


    @BindView(R.id.btn1)
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.btn1, R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                Intent intent1 = new Intent(this, ListViewActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn2:
                Intent intent2 = new Intent(this, NotificationActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn3:
                DownloadActivity.launch(this);
                break;
            case R.id.btn4:
                startActivity(new Intent(this,ConstraintLayoutActivity.class));
                break;
            case R.id.btn5:
                startActivity(new Intent(this,SwipRecycleActivity.class));
                break;
            case R.id.btn6:
                startActivity(new Intent(this,RxJavaActivity.class));
                break;
            case R.id.btn7:
                startActivity(new Intent(this,WidgetActivity.class));
                break;
            case R.id.btn8:
                startActivity(new Intent(this,ViewPagerActivity.class));
                break;
        }
    }




}

