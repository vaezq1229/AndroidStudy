package com.lwh.mystudy;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * 下载
 * DownloadManager
 * Created by ${lwh} on 2017/8/23.
 */

public class DownloadActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks{

    public static final String DOWNLOAD_URI = "http://gdown.baidu.com/data/wisegame/ba226d3cf2cfc97b/baiduyinyue_4920.apk";
    public static final String DOWNLOAD_FOLDER_NAME = "download";

    private DownloadManager mDownloadManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);

        //得到系统服务
        mDownloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);


    }

    @OnClick(R.id.btn_add)
    public void onViewClicked() {

        checkPermissions();
    }

    /**
     * 检查版本号
     * 利用系统的DownloadManager
     */
    private void checkVersion() {

        //创建下载请求
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DOWNLOAD_URI));
        //设置在通知栏是否显示通知
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        //设置通知的标识
        request.setTitle("测试");
        File folder = Environment.getExternalStoragePublicDirectory("download");
        if (!folder.exists() || !folder.isDirectory()) {
            folder.mkdirs();
        }
        //设置下载文件的保存位置
        request.setDestinationInExternalPublicDir("download","text.apk");

        //获取下载管理器服务的实例，添加下载任务
        mDownloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        //将下载请求添加到任务队列
        mDownloadManager.enqueue(request);
    }



    /**
     * 检查权限
     */
    private void checkPermissions() {
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {
            checkVersion();
        } else {
            EasyPermissions.requestPermissions(this, "", 1, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //把申请权限的回调交由EasyPermissions处理
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        switch (requestCode) {
            case 1:
                if (perms.size() > 0 && perms.contains(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    checkVersion();
                }
                break;
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
    }

    public static void launch(Context context){
        Intent intent = new Intent(context,DownloadActivity.class);
        context.startActivity(intent);
    }

}
