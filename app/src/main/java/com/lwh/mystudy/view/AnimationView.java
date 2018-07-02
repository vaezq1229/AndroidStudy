package com.lwh.mystudy.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ${lwh} on 2018/7/2.
 *
 * @descirbe
 */
public class AnimationView extends View {
    private float progress = 0f;
    private int text = 0;

    private ObjectAnimator objectAnimator;
    private ObjectAnimator objectAnimator2;

    private RectF rectF;
    private Paint mPaint;

    private Paint mTextPaint;


    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }

    public void setText(int text) {
        this.text = text;
    }

    public AnimationView(Context context) {
        this(context,null);
    }

    public AnimationView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AnimationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        objectAnimator = ObjectAnimator.ofFloat(this,"progress",0,65).setDuration(1000);
        objectAnimator2 = ObjectAnimator.ofInt(this,"text",0,65).setDuration(1000);
        rectF = new RectF(-100,-100,100,100);
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setAntiAlias(true);

        mTextPaint = new Paint();
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setTextSize(40);
//        mTextPaint.setFakeBoldText(true);
        mTextPaint.setAntiAlias(true);

        objectAnimator.start();
        objectAnimator2.start();


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(getWidth()/2,getHeight()/2);
        canvas.drawArc(rectF,135,progress * 2.7f,false,mPaint);
        canvas.drawText(objectAnimator2.getAnimatedValue() + "%",0,0,mTextPaint);
    }
}
