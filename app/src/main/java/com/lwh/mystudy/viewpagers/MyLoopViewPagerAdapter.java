package com.lwh.mystudy.viewpagers;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lwh.mystudy.R;

import java.util.ArrayList;

/**
 * Created by ${lwh} on 2017/12/21.
 *
 * @descirbe
 */

public class MyLoopViewPagerAdapter extends BaseLoopViewPagerAdapter<String> {

   private static int[]  imgv_ids = {R.mipmap.banner1,R.mipmap.dog,R.mipmap.banner2};

    private ViewGroup.LayoutParams layoutParams ;

    public MyLoopViewPagerAdapter(Context context, ArrayList<String> data, ViewPager viewPager) {
        super(context, data, viewPager);
    }

    @Override
    public View getItemView(String item,int position) {
        if(layoutParams == null){
            layoutParams = new ViewGroup.LayoutParams(ViewPager.LayoutParams.MATCH_PARENT,ViewPager.LayoutParams.MATCH_PARENT);
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if(position == 0){
            imageView.setImageResource(imgv_ids[imgv_ids.length-1]);
        }else if(position == imgv_ids.length+1){
            imageView.setImageResource(imgv_ids[0]);
        }else{


            imageView.setImageResource(imgv_ids[position-1]);
        }
        return imageView;
    }
}
