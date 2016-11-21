package com.xingzhiqiao.animationdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

/**
 * Created by xingzhiqiao on 2016/11/17.
 */

public class EnterActiviy extends AppCompatActivity {


    private ImageView mBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        mBg = (ImageView) findViewById(R.id.bg_boy);


        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(mBg, "scaleX", 1, 1.5f),
                ObjectAnimator.ofFloat(mBg, "scaleY", 1, 1.5f));
        set.setDuration(2000);
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Intent intent = new Intent(EnterActiviy.this, MainActivity.class);
                EnterActiviy.this.startActivity(intent);
                finish();
            }
        });
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        set.start();

    }


}
