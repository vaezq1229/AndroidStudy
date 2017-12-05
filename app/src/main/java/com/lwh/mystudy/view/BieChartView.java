package com.lwh.mystudy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.lwh.mystudy.model.BieModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${lwh} on 2017/12/5.
 *
 * @descirbe 饼状图
 */

public class BieChartView extends View {

    private Paint mPaint;
    private List<BieModel> mData;

    private RectF rectF;

    private float total = 100f;

    private float startAngle = 0f;
    private float sweepAngle;
    private float lineAngle;

    private float lineStartX;
    private float lineStartY;
    private float lineEndX;
    private float lineEndY;

    private int radius = 300;



    public BieChartView(Context context) {
        this(context, null);
    }

    public BieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, null, 0);
    }

    public BieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();


        rectF = new RectF(-300, -300, 300, 300);

        initData();

    }

    private void initData() {
        mData = new ArrayList<>();
        mData.add(new BieModel("1", 5f, Color.BLACK));
        mData.add(new BieModel("2", 10f, Color.BLUE));
        mData.add(new BieModel("3", 15f, Color.GREEN));
        mData.add(new BieModel("4", 20f, Color.RED));
        mData.add(new BieModel("5", 15f, Color.YELLOW));
        mData.add(new BieModel("5", 35f, Color.parseColor("#8FBC8F")));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);

        for (BieModel bieModel : mData) {
            sweepAngle = bieModel.getSweepAngle() / total * 360f;

            lineAngle = startAngle + sweepAngle / 2;

            mPaint.setColor(bieModel.getColor());
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawArc(rectF, startAngle, sweepAngle, true, mPaint);


            lineStartX = radius * (float) Math.cos(lineAngle/180 * Math.PI);
            lineStartY = radius * (float) Math.sin(lineAngle/180 * Math.PI);
            lineEndX = (radius + 50) * (float) Math.cos(lineAngle/180 * Math.PI);
            lineEndY = (radius + 50) * (float) Math.sin(lineAngle/180 * Math.PI);

            Log.e("========",lineStartX + "lineStartY" +lineStartY);
            Log.e("========",lineEndX + "lineEndY" +lineEndY);

            canvas.drawLine(lineStartX,lineStartY,lineEndX,lineEndY,mPaint);

            if (lineAngle > 90 && lineAngle <= 270) {
                canvas.drawLine(lineEndX, lineEndY, lineEndX - 50, lineEndY, mPaint);
                mPaint.setStyle(Paint.Style.FILL);
                canvas.drawText(bieModel.getName(), lineEndX - 50 - 10 - mPaint.measureText(bieModel.getName()), lineEndY, mPaint);
            } else {
                canvas.drawLine(lineEndX, lineEndY, lineEndX + 50, lineEndY, mPaint);
                mPaint.setStyle(Paint.Style.FILL);
                canvas.drawText(bieModel.getName(), lineEndX + 50 + 10, lineEndY, mPaint);
            }



            startAngle += sweepAngle;
        }
    }
}
