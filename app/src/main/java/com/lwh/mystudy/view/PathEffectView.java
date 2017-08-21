package com.lwh.mystudy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 图形的轮廓设置效果
 * Created by ${lwh} on 2017/8/21.
 */

public class PathEffectView extends View {

    private  DashPathEffect mDashPathEffect;//虚线
    private PathEffect mCornerPathEffect;//把所有的拐角变成圆角
    private PathEffect mDiscretePathEffect;//让线条进行随机的偏离，让轮廓变得乱七八糟
    private PathEffect mPathDashPathEffect;//使用一个path来绘制一个虚线

    private Paint mPaint;

    private float phase = 0;

    private Path mPath;
    private Path mDiscretePath;
    private Path mPathDashPath;


    public PathEffectView(Context context) {
        this(context,null);
    }

    public PathEffectView(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint =  new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);

        //数组是实线虚线比
        mDashPathEffect = new DashPathEffect(new float[]{10,5},phase);

        mCornerPathEffect = new CornerPathEffect(20);

        //第一个参数是拼接线段的长度，第二个参数是抖动的幅度
        mDiscretePathEffect = new DiscretePathEffect(20,5);

        Path  path_triangle = new Path();
        path_triangle.addCircle(0,0,10, Path.Direction.CW);


        mPath = new Path();
        mDiscretePath = new Path();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setPathEffect(mDashPathEffect);
        canvas.drawCircle(100,100,100,mPaint);

        mPath.moveTo(200,200);
        mPath.lineTo(200,400);
        mPath.lineTo(300,200);
        mPath.lineTo(500,400);
        mPath.lineTo(700,200);
        mPaint.setPathEffect(mCornerPathEffect);
        canvas.drawPath(mPath,mPaint);

        mDiscretePath.moveTo(200,500);
        mDiscretePath.lineTo(200,800);
        mDiscretePath.lineTo(300,600);
        mDiscretePath.lineTo(500,800);
        mDiscretePath.lineTo(700,600);
        mPaint.setPathEffect(mDiscretePathEffect);
        canvas.drawPath(mDiscretePath,mPaint);
    }
}
