package com.lwh.mystudy.viewpagers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.lwh.mystudy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${lwh} on 2017/12/21.
 *
 * @descirbe
 */

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    private int[] mImgIds = new int[]{R.mipmap.banner1, R.mipmap.dog, R.mipmap.banner2};
    private List<ImageView> mImageViews = new ArrayList<ImageView>();

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

//        initData();
//        mViewPager.setAdapter(new PagerAdapter() {
//            @Override
//            public Object instantiateItem(ViewGroup container, int position) {
//
//                container.addView(mImageViews.get(position));
//                return mImageViews.get(position);
//            }
//
//            @Override
//            public void destroyItem(ViewGroup container, int position,
//                                    Object object) {
//
//                container.removeView(mImageViews.get(position));
//            }
//
//            @Override
//            public boolean isViewFromObject(View view, Object object) {
//                return view == object;
//            }
//
//            @Override
//            public int getCount() {
//                return mImgIds.length;
//            }
//        });


        mViewPager.setPageTransformer(true, new DepthPageTransformer());

    }


    private void initData() {
        for (int imgId : mImgIds) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(imgId);
            mImageViews.add(imageView);
        }
    }
}


