package com.lwh.mystudy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ${lwh} on 2017/12/20.
 *
 * @descirbe  自定义日历
 */

public class CustomCalendar extends View{

    private Paint mPaintMonth;//2017年12月
    private Paint mPaintWeek;//星期
    private Paint mPaintDay;//具体的日子

    public CustomCalendar(Context context) {
       this(context,null);
    }

    public CustomCalendar(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public CustomCalendar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initCompute();
    }

    private void initCompute() {
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawMonth(canvas);
    }

    private void drawMonth(Canvas canvas) {

    }
}
