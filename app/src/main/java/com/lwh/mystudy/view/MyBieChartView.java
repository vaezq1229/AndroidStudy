package com.lwh.mystudy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lwh.mystudy.model.BieModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${lwh} on 2018/6/26.
 *
 * @descirbe
 */
public class MyBieChartView extends View {

    private Paint mPaint;
    private List<BieModel> list;

    private RectF rectF;

    private float startAngle = 0;
    private float sweepAngle;

    private Paint paint_text;

    private int radius = 300;

    private float lineStartX;
    private float lineStartY;
    private float lineEndX;
    private float lineEndY;

    private float lineAngle;

    public MyBieChartView(Context context) {
        this(context, null);
    }

    public MyBieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyBieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);

        paint_text = new Paint();
        paint_text.setStyle(Paint.Style.STROKE);
        paint_text.setStrokeWidth(1);
        paint_text.setColor(Color.BLACK);

        rectF = new RectF(-300, -300, 300, 300);

        list = new ArrayList<>();
        list.add(new BieModel("1", 5f, Color.BLACK));
        list.add(new BieModel("2", 10f, Color.BLUE));
        list.add(new BieModel("3", 15f, Color.GREEN));
        list.add(new BieModel("4", 20f, Color.RED));
        list.add(new BieModel("5", 15f, Color.YELLOW));
        list.add(new BieModel("5", 35f, Color.parseColor("#8FBC8F")));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(getWidth() / 2, getHeight() / 2);

        for (BieModel bieModel : list) {
            mPaint.setColor(bieModel.getColor());

            sweepAngle = bieModel.getSweepAngle() / 100 * 360;
            canvas.drawArc(rectF, startAngle, sweepAngle, true, mPaint);

            lineAngle = startAngle + sweepAngle / 2;
            lineStartX = radius * (float) Math.cos(lineAngle / 180 * Math.PI);
            lineStartY = radius * (float) Math.sin(lineAngle / 180 * Math.PI);
            lineEndX = (radius + 50) * (float) Math.cos(lineAngle / 180 * Math.PI);
            lineEndY = (radius + 50) * (float) Math.sin(lineAngle / 180 * Math.PI);

            canvas.drawLine(lineStartX, lineStartY, lineEndX, lineEndY, paint_text);

            if (lineAngle < 90 || lineAngle > 270) {
                canvas.drawLine(lineEndX, lineEndY, lineEndX + 50, lineEndY, paint_text);
                canvas.drawText(bieModel.getName(), lineEndX + 50 + 10, lineEndY, paint_text);
            } else {
                canvas.drawLine(lineEndX, lineEndY, lineEndX - 50, lineEndY, paint_text);
                canvas.drawText(bieModel.getName(), lineEndX - 50 - 10 - mPaint.measureText(bieModel.getName()), lineEndY, paint_text);
            }

            startAngle += sweepAngle;


        }
    }
}
