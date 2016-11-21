package com.xingzhiqiao.animationdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 属性动画
 * Created by xingzhiqiao on 2016/11/17.
 */

public class PropAnimActivity extends AppCompatActivity {

    private ImageView mBoyImg;
    private Button mPropBtn;
    private Button mTv;
    private Button freedownBtn, paowuxianBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prop);

        mBoyImg = (ImageView) findViewById(R.id.prop_img);
        mPropBtn = (Button) findViewById(R.id.prop_btn);
        mTv = (Button) findViewById(R.id.prop_tv);

        mBoyImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ObjectAnimator.ofFloat(mBoyImg, "translationY", mBoyImg.getHeight()).start();
                ObjectAnimator.ofFloat(mBoyImg, "translationY", -mBoyImg.getHeight()).start();
            }
        });
        mPropBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //背景色在3s内实现从0xFFFF8080到0xFF8080FF的渐变
//                ValueAnimator colorAnimator = ObjectAnimator.ofInt(mPropBtn, "backgroundColor",/*Red*/0xFFFF8080,/*Blue*/0xFF8080FF);
//                colorAnimator.setDuration(3000);
//                colorAnimator.setEvaluator(new ArgbEvaluator());
//                colorAnimator.setRepeatCount(ValueAnimator.INFINITE);
//                colorAnimator.setRepeatMode(ValueAnimator.REVERSE);
//                colorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    //持有一个IntEvaluator对象，方便下面估值的时候使用
//                    private IntEvaluator mEvaluator = new IntEvaluator();
//
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                        //获得当前动画的进度值，整形，1-100之间
//                        int currentValue = (int) valueAnimator.getAnimatedValue();
//                        Log.d("TAG", "current value" + currentValue);
//                        //获得当前进度占整个动画的过程的比例，浮点，0-1之间
//                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB_MR1) {
//                            float fraction = valueAnimator.getAnimatedFraction();
//                            Log.d("TAG", "fraction" + fraction);
//                        }
//
//
//                    }
//                });
//                colorAnimator.start();

            }
        });

        mPropBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {


                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(
                        ObjectAnimator.ofFloat(mPropBtn, "rotationX", 0, 360),
                        ObjectAnimator.ofFloat(mPropBtn, "rotationY", 0, 180),
                        ObjectAnimator.ofFloat(mPropBtn, "rotation", 0, -90),
                        ObjectAnimator.ofFloat(mPropBtn, "translationX", 0, 180),
                        ObjectAnimator.ofFloat(mPropBtn, "translationY", 0, 360),
                        ObjectAnimator.ofFloat(mPropBtn, "scaleX", 1, 1.5f),
                        ObjectAnimator.ofFloat(mPropBtn, "scaleY", 1, 0.5f),
                        ObjectAnimator.ofFloat(mPropBtn, "alpha", 1, 0.25f, 1));
                animatorSet.setDuration(5000).start();
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationCancel(Animator animation) {
                        super.onAnimationCancel(animation);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                        super.onAnimationRepeat(animation);
                    }

                    @Override
                    public void onAnimationStart(Animator animation) {
                        super.onAnimationStart(animation);
                    }

                    @Override
                    public void onAnimationPause(Animator animation) {
                        super.onAnimationPause(animation);
                    }

                    @Override
                    public void onAnimationResume(Animator animation) {
                        super.onAnimationResume(animation);
                    }
                });

                return true;
            }
        });

        mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator.ofInt(mTv, "width", 500).setDuration(5000).start();
            }
        });


        freedownBtn = (Button) findViewById(R.id.free_down);
        paowuxianBtn = (Button) findViewById(R.id.paowuxian);


        freedownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                freeDown();
            }
        });
        paowuxianBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paowuxian();
            }
        });

    }

    private void freeDown() {
        WindowManager manager = getWindowManager();
        int screenheight = manager.getDefaultDisplay().getHeight();
        ObjectAnimator.ofFloat(mPropBtn, "translationY", 0, screenheight - mPropBtn.getHeight()).start();

    }

    private void paowuxian() {

        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(3000);
        valueAnimator.setTarget(mPropBtn);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setObjectValues(new PointF(0, 0));
        valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
            @Override
            public PointF evaluate(float v, PointF pointF, PointF t1) {
                PointF pointf = new PointF();
                pointf.x = 200 * v * 3;
                pointf.y = 0.5f * 400 * 3 * v * 3 * v;

                return pointf;
            }

        });
        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PointF pointf = (PointF) valueAnimator.getAnimatedValue();
                mPropBtn.setX(pointf.x);
                mPropBtn.setY(pointf.y);
            }
        });

    }

}
