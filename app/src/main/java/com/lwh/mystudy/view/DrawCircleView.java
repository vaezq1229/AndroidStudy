package com.lwh.mystudy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ${lwh} on 2017/12/5.
 *
 * @descirbe  画圆
 */

public class DrawCircleView extends View{

    private Paint mPaint;

    private Paint mPaint2;

    public DrawCircleView(Context context) {
        this(context,null);
    }

    public DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#000000"));

        mPaint2 = new Paint();
        mPaint2.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(100,100,100,mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(100,350,100,mPaint);

        mPaint.setStrokeWidth(10);
        canvas.drawCircle(100,700,100,mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.parseColor("#666666"));
        canvas.drawCircle(100,950,100,mPaint);

        RectF rectF = new RectF(300,300,800,800);

        mPaint2.setColor(Color.parseColor("#FFB6C1"));
        canvas.drawArc(rectF,0,-50,true,mPaint2);

        mPaint2.setColor(Color.parseColor("#FF00FF"));
        canvas.drawArc(rectF,-50,-130,true,mPaint2);

        mPaint2.setColor(Color.parseColor("#4B0082"));
        canvas.drawArc(rectF,0,20,true,mPaint2);
    }
}
