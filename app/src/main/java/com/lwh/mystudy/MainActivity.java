package com.lwh.mystudy;

import android.Manifest;
import android.app.DownloadManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import com.lwh.mystudy.adapter.SwipeQuickAdapter;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity  {

    @BindView(R.id.btn1)
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.btn1, R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6})
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
        }
    }




}

