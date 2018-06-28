package com.lwh.mystudy.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lwh.mystudy.R;

/**
 * 渐变色
 * Created by ${lwh} on 2017/8/17.
 */

public class GradientView extends View {

    private Paint mPaint;
    private Shader mShader;

    private Bitmap bitmap_ic;

    public GradientView(Context context) {
        this(context,null);
    }

    public GradientView(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public GradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        bitmap_ic = BitmapFactory.decodeResource(getResources(),R.mipmap.dog);
        bitmap_ic = Bitmap.createScaledBitmap(bitmap_ic,200,200,false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mShader = new LinearGradient(100,800,200,900, Color.BLUE,Color.RED, Shader.TileMode.CLAMP);
        mPaint.setShader(mShader);
        canvas.drawCircle(200,800,100,mPaint);

        mShader = new RadialGradient(200,400,20, Color.BLUE,Color.RED, Shader.TileMode.CLAMP);
        mPaint.setShader(mShader);
        canvas.drawCircle(200,400,100,mPaint);

        mShader = new SweepGradient(200,600, Color.BLUE,Color.RED);
        mPaint.setShader(mShader);
        canvas.drawCircle(200,600,100,mPaint);

        mShader = new BitmapShader(bitmap_ic, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint.setShader(mShader);
        canvas.drawCircle(100,100,100,mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
