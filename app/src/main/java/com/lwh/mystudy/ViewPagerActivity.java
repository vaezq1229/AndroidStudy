package com.lwh.mystudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lwh.mystudy.adapter.MyLoopViewPagerAdapter;

import java.util.ArrayList;

/**
 * Created by ${lwh} on 2017/12/21.
 *
 * @descirbe
 */

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        ArrayList<String> data = new ArrayList<>();
        data.add("");
        data.add("");
        data.add("");

        mViewPager.setAdapter(new MyLoopViewPagerAdapter(this,data,mViewPager));
        mViewPager.setCurrentItem(1,false);
    }
}
