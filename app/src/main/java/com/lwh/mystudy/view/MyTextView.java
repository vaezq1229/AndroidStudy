package com.lwh.mystudy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ${lwh} on 2018/6/28.
 *
 * @descirbe
 */
public class MyTextView extends View {

    private TextPaint mPaint;

    String text = "a\nbc\ndefghi\njklm\nnopqrst\nuvwx\nyz";

    public MyTextView(Context context) {
        this(context,null);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new TextPaint();
        mPaint.setTextSize(30);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(getWidth()/2,getHeight()/2);

//        width 是文字区域的宽度，文字到达这个宽度后就会自动换行；
//        align 是文字的对齐方向；
//        spacingmult 是行间距的倍数，通常情况下填 1 就好；
//        spacingadd 是行间距的额外增加值，通常情况下填 0 就好；
//        includeadd 是指是否在文字上下添加额外的空间，来避免某些过高的字符的绘制出现越界。
        StaticLayout staticLayout = new StaticLayout(text,mPaint,600, Layout.Alignment.ALIGN_NORMAL,1,0,true);
        staticLayout.draw(canvas);
    }
}
