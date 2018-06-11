package com.lwh.mystudy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by ${lwh} on 2018/1/16.
 *
 * @descirbe
 */

public class HiddenLineView extends View {
    private Paint mPaint;
    private Path mPath;
    private DashPathEffect mDashPathEffect;

    public HiddenLineView(Context context) {
        this(context, null);
    }

    public HiddenLineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HiddenLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(2);

        mPath = new Path();
        mDashPathEffect = new DashPathEffect(new float[]{4, 4, 4, 4}, 2);
        mPaint.setPathEffect(mDashPathEffect);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = getSuggestedMinimumHeight();
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);
        switch (specMode) {
            case MeasureSpec.AT_MOST:
                height =  (int) (-mPaint.ascent() + mPaint.descent()) + getPaddingTop() + getPaddingBottom();
                break;
            case MeasureSpec.EXACTLY:
                height = specSize;
                break;
            case MeasureSpec.UNSPECIFIED:
                height = Math.max(height,specSize);
                break;
        }
        setMeasuredDimension(2,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e("=============","onDraw");
        mPath.moveTo(0,0);
        mPath.lineTo(0, getHeight() );
        canvas.drawPath(mPath,mPaint);
    }
}
