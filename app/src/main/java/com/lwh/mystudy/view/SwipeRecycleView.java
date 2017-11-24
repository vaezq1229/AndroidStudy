package com.lwh.mystudy.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by ${lwh} on 2017/11/24.
 *
 * @descirbe     解决recycleview嵌套在swipeRefreshLayout滑动冲突
 */

public class SwipeRecycleView extends RecyclerView {


    public SwipeRecycleView(Context context) {
        super(context);
    }

    public SwipeRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SwipeRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {


        return super.dispatchTouchEvent(ev);
    }
}
