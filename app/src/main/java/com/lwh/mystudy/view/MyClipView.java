package com.lwh.mystudy.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lwh.mystudy.R;


/**
 * Created by ${lwh} on 2018/6/29.
 *
 * @descirbe
 */
public class MyClipView extends View {

    private Bitmap bitmap;
    private Paint mPaint;

    private Path mPath;
    private RectF rectF;

    private Camera camera;


    public MyClipView(Context context) {
        this(context, null);
    }

    public MyClipView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyClipView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

//        this.setLayerType(View.LAYER_TYPE_HARDWARE,null);

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);


        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.dog);
        bitmap = Bitmap.createScaledBitmap(bitmap, 200, 200, true);


        rectF = new RectF(100, 400, 500, 800);
        mPath = new Path();
        mPath.addArc(rectF, 0, 360);

        camera = new Camera();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.clipRect(100, 100, 300, 200);
        canvas.drawBitmap(bitmap, 0, 100, mPaint);
        canvas.restore();

        canvas.save();
        canvas.clipPath(mPath);
        canvas.drawBitmap(bitmap, 100, 400, mPaint);
        canvas.restore();


        canvas.save();
        canvas.translate(600, 0);
        canvas.drawBitmap(bitmap, 0, 0, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(600, 300);
        canvas.rotate(45, 100, 100);
        canvas.drawBitmap(bitmap, 0, 0, mPaint);
        canvas.restore();


        canvas.save();
        canvas.translate(100, 800);
        canvas.scale(0.5f, 1.0f);
        canvas.drawBitmap(bitmap, 0, 0, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 800);
        canvas.skew(0, 0.5f);
        canvas.drawBitmap(bitmap, 0, 0, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(100, 1100);
        camera.rotateX(30);//旋转camera的三维空间
        camera.applyToCanvas(canvas);//把旋转投影到Canvas、
        canvas.drawBitmap(bitmap, 0, 0, mPaint);
        canvas.restore();

    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawCircle(100,100,10,mPaint);

        canvas.drawCircle(150,150,10,mPaint);
    }

//    // View.java 的 draw() 方法的简化版大致结构（是大致结构，不是源码哦）：
//
//    public void draw(Canvas canvas) {
//    ...
//
//        drawBackground(Canvas); // 绘制背景（不能重写）
//        onDraw(Canvas); // 绘制主体
//        dispatchDraw(Canvas); // 绘制子 View
//        onDrawForeground(Canvas); // 绘制滑动相关和前景
//
//    ...
//    }
}
