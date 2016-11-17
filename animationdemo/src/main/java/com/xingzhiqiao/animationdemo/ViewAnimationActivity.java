package com.xingzhiqiao.animationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * 视图动画
 * Created by xingzhiqiao on 2016/11/17.
 */

public class ViewAnimationActivity extends AppCompatActivity {


    private ImageView mImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);


        mImg = (ImageView) findViewById(R.id.boy);
        mImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.view_animation1);
                mImg.startAnimation(animation);
            }
        });
//
    }

    private void StartAnim() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(300);
        mImg.startAnimation(alphaAnimation);

        TranslateAnimation translateAnimation = new TranslateAnimation(0,100,0,100);
        mImg.startAnimation(translateAnimation);
        //...

    }


}


