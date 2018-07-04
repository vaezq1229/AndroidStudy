package com.lwh.mystudy.view;

import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.icu.util.Measure;
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
    private int color;

    private ObjectAnimator objectAnimator;
    private ObjectAnimator objectAnimator2;
    private ObjectAnimator objectAnimator4;


    private RectF rectF;

    private Paint mPaint;
    private Paint mTextPaint;


    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }

    public void setText(int text) {
        this.text = text;
    }

    public void setColor(int color) {
        this.color = color;
        mTextPaint.setColor(color);
        invalidate();
    }

    public AnimationView(Context context) {
        this(context, null);
    }

    public AnimationView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AnimationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        objectAnimator = ObjectAnimator.ofFloat(this, "progress", 0, 65).setDuration(1000);
        objectAnimator2 = ObjectAnimator.ofInt(this, "text", 0, 65).setDuration(1000);
        rectF = new RectF(-100, -100, 100, 100);
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

//        objectAnimator.start();
        objectAnimator2.start();


        ObjectAnimator objectAnimator3 = ObjectAnimator.ofInt(this, "color", 0xffff0000, 0xff00ff00);
        objectAnimator3.setEvaluator(new ArgbEvaluator());
        objectAnimator3.setDuration(1000);
        objectAnimator3.start();

        //从0%开始
        Keyframe keyframe1 = Keyframe.ofFloat(0, 0);
        //时间经过50%的时候，动画完成度100%
        Keyframe keyframe2 = Keyframe.ofFloat(0.5f, 100);
        //时间结束  回到80%
        Keyframe keyframe3 = Keyframe.ofFloat(1, 80);
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofKeyframe("progress", keyframe1, keyframe2, keyframe3);
        objectAnimator4 = ObjectAnimator.ofPropertyValuesHolder(this, propertyValuesHolder).setDuration(1500);
        objectAnimator4.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.drawArc(rectF, 135, progress * 2.7f, false, mPaint);

        Rect rectF1 = new Rect();
//        int value = (int)(Double.parseDouble(objectAnimator4.getAnimatedValue().toString()));
        int value = ((Float) objectAnimator4.getAnimatedValue()).intValue();
        mTextPaint.getTextBounds(value + "%", 0, (value + "%").length(), rectF1);
        canvas.drawText(value + "%", -rectF1.width() / 2, 0, mTextPaint);
        canvas.restore();


        canvas.drawCircle(100, 100, 100, mTextPaint);
    }
}
