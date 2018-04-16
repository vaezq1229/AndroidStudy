package com.lwh.mystudy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ${lwh} on 2018/3/6.
 *
 * @descirbe
 */

public class MyProgressDetailView extends View{

    private Paint mPaint;
    private Paint mTextPaint;

    private float text_length;
    private int percent = 50;
    private String text = "已投20";

    public MyProgressDetailView(Context context) {
        this(context,null);
    }

    public MyProgressDetailView(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public MyProgressDetailView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setStrokeWidth(2);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#000000"));

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(24);
        mTextPaint.setColor(Color.parseColor("#000000"));

        text_length = mTextPaint.measureText(text);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int percentX = getWidth()/100 * percent;
        if(percentX < text_length / 2 ){
            canvas.drawText(text,percentX,mTextPaint.getTextSize(),mTextPaint);
        }else if(percentX >= text_length/2 && percentX + text_length/2 < getWidth()){
            canvas.drawText(text,percentX - text_length/2,mTextPaint.getTextSize(),mTextPaint);
        }else{
            canvas.drawText(text,percentX - text_length,mTextPaint.getTextSize(),mTextPaint);
        }
        canvas.drawLine(0,mPaint.getStrokeWidth()/2 + mTextPaint.getFontSpacing(),percentX,mPaint.getStrokeWidth()/2 + mTextPaint.getFontSpacing(),mPaint);
        canvas.drawCircle(percentX,mPaint.getStrokeWidth()/2 + mTextPaint.getFontSpacing() ,5,mPaint);
    }
}
