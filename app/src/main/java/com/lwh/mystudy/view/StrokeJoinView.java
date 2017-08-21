package com.lwh.mystudy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 拐角形状
 * Created by ${lwh} on 2017/8/21.
 */

public class StrokeJoinView extends View{

    private Paint mPaint;
    private Path mPath;

    public StrokeJoinView(Context context) {
        this(context,null);
    }

    public StrokeJoinView(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public StrokeJoinView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(30);
        mPaint.setStyle(Paint.Style.STROKE);
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPath.moveTo(100,100);
        mPath.lineTo(300,100);
        mPath.lineTo(200,200);
        mPaint.setStrokeJoin(Paint.Join.ROUND);//圆角
        canvas.drawPath(mPath,mPaint);

        mPath.moveTo(100,400);
        mPath.lineTo(300,400);
        mPath.lineTo(100,500);
        mPaint.setStrokeJoin(Paint.Join.BEVEL);//平角
        canvas.drawPath(mPath,mPaint);

        mPath.moveTo(100,800);
        mPath.lineTo(300,800);
        mPath.lineTo(100,900);
        mPaint.setStrokeJoin(Paint.Join.MITER);//尖角
        canvas.drawPath(mPath,mPaint);


    }
}
