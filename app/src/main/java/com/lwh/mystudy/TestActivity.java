package com.lwh.mystudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by ${lwh} on 2018/1/31.
 *
 * @descirbe
 */

public class TestActivity extends AppCompatActivity {
    String time = "05";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("==========","time = " + Integer.parseInt(time));
    }
}

