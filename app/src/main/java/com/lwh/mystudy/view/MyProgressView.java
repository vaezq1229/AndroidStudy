package com.lwh.mystudy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lwh.mystudy.R;

/**
 * Created by ${lwh} on 2018/2/1.
 *
 * @descirbe 进度条view
 */

public class MyProgressView extends View {
    private Paint mPaint;
    private int mPercent;
    private int mColor;

    public MyProgressView(Context context) {
        this(context,null);
    }

    public MyProgressView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setStrokeWidth(getHeight());

        mPaint.setColor(getResources().getColor(R.color.gray));
        canvas.drawLine(10,mPaint.getStrokeWidth()/2,getWidth()-10,mPaint.getStrokeWidth()/2,mPaint);
        mPaint.setColor(mColor);
        canvas.drawLine(10,mPaint.getStrokeWidth()/2,getWidth() * mPercent / 100,mPaint.getStrokeWidth()/2,mPaint);
    }


    public void setmPercent(int mPercent) {
        this.mPercent = mPercent;
        invalidate();
    }

    public void setmColor(int mColor) {
        this.mColor = mColor;
        invalidate();
    }
}
