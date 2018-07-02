package com.lwh.mystudy.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.lwh.mystudy.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ${lwh} on 2018/7/2.
 *
 * @descirbe
 */
public class AnimationActivity extends AppCompatActivity {
    @BindView(R.id.icon_angle)
    ImageView iconAngle;
    @BindView(R.id.icon_angle2)
    ImageView iconAngle2;
    @BindView(R.id.icon_angle3)
    ImageView iconAngle3;
    @BindView(R.id.icon_angle4)
    ImageView iconAngle4;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, AnimationActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);

        /**
         * AccelerateDecelerateInterpolator 加速减速
         * LinearInterpolator  线性
         * AccelerateInterpolator  一直加速
         * DecelerateInterpolator 减速
         * AnticipateInterpolator  先回拉一下再进行正常动画轨迹。效果看起来有点像投掷物体或跳跃等动作前的蓄力。
         * OvershootInterpolator 动画会超过目标值一些，然后再弹回来。效果看起来有点像你一屁股坐在沙发上后又被弹起来一点的感觉。
         * AnticipateOvershootInterpolator 上面这两个的结合版：开始前回拉，最后超过一些然后回弹。
         * BounceInterpolator 在目标值处弹跳。有点像玻璃球掉在地板上的效果。
         * CycleInterpolator 这个也是一个正弦 / 余弦曲线，不过它和 AccelerateDecelerateInterpolator 的区别是，它可以自定义曲线的周期，所以动画可以不到终点就结束，
         *                                 也可以到达终点后回弹，回弹的次数由曲线的周期决定，曲线的周期由 CycleInterpolator() 构造方法的参数决定
         *
         * PathInterpolator  自定义动画完成度 / 时间完成度曲线。
         */

        //线性 匀速
        iconAngle.animate().translationX(500).setInterpolator(new LinearInterpolator()).setDuration(1000);

        //带施法前摇 和回弹的Interpolator
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iconAngle2, "translationX", 500).setDuration(1000);
        objectAnimator.setInterpolator(new CycleInterpolator(2f));
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        objectAnimator.removeAllListeners();
        objectAnimator.start();

        /**
         *
         */
        iconAngle3.animate().scaleX(1).scaleY(1).alpha(1).setDuration(1000);


        /**
         * AnimationSet
         */




    }

    @OnClick({R.id.icon_angle, R.id.icon_angle2, R.id.icon_angle3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.icon_angle:
                break;
            case R.id.icon_angle2:
                break;
            case R.id.icon_angle3:
                break;
        }
    }
}
