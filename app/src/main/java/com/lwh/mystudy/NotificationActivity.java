package com.lwh.mystudy;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ${lwh} on 2017/8/18.
 */

public class NotificationActivity extends AppCompatActivity {
    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.btn_delete)
    Button btnDelete;

    private int mId = 1;

    private NotificationManager mNotificationManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);

        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

    }

    @OnClick({R.id.btn_add, R.id.btn_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                addNotification();
                break;
            case R.id.btn_delete:
                deleteNotification();
                break;
        }
    }

    /**
     * 删除通知
     */
    private void deleteNotification() {
        mNotificationManager.cancel(mId);
    }

    /**
     * 添加通知
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void addNotification() {

        PendingIntent intent = PendingIntent.getActivity(this,0,new Intent(this,MainActivity.class), PendingIntent.FLAG_CANCEL_CURRENT);

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("测试"+mId)
                .setContentText("测试内容")
                .setSubText("补充内容")
                .setTicker("ticker")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setDefaults(Notification.DEFAULT_SOUND|Notification.DEFAULT_VIBRATE)//设置声音和振动
                .setAutoCancel(true)//点击取消
                .setWhen(System.currentTimeMillis())
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                .setContentIntent(intent)
                .build();

        mNotificationManager.notify(mId,builder.build());

        mId++;

    }
    
    
}
