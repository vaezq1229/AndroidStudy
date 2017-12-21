package com.lwh.mystudy.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by ${lwh} on 2017/12/21.
 *
 * @descirbe
 */

public abstract  class BaseLoopViewPagerAdapter<T> extends PagerAdapter implements ViewPager.OnPageChangeListener {

    protected Context context;
    private ViewPager mViewPager;

    private ArrayList<View> data_view;

    private int currentPosition = 0;

    public BaseLoopViewPagerAdapter(Context context, ArrayList<T> data, ViewPager viewPager) {
        this.context = context;
        this.mViewPager = viewPager;

        if(data == null || data.size() == 0){
            return;
        }

        data_view = new ArrayList<>();

        if(data.size() > 1){
            //添加最好一页到第一页
            data.add(0,data.get(data.size()-1));
            //添加第一页到最后一页
            data.add(data.get(1));
        }

        for(int i = 0;i<data.size();i++){
            data_view.add(getItemView(data.get(i),i));
        }

        mViewPager.setAdapter(this);
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public int getCount() {
        return data_view.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(data_view.get(position));
        return data_view.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(data_view.get(position));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        currentPosition = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if(state!=ViewPager.SCROLL_STATE_IDLE){
            return;//没有停止  直接返回
        }
        if(currentPosition == 0){
            //若为第一张 ，则表示当前数据的最后一个，现在的位置是当前list的倒数第二个
            mViewPager.setCurrentItem(data_view.size()-2,false);
        }else if(currentPosition == data_view.size()-1){
            //若为最后一张，则表示是原有数据的第一张，现在的位置是当前list的第二项
            mViewPager.setCurrentItem(1,false);
        }
    }

    public abstract View getItemView(T item,int position);
}
