package com.xingzhiqiao.animationdemo;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * 视图动画
 * Created by xingzhiqiao on 2016/11/17.
 */

public class ViewAnimationActivity extends AppCompatActivity {


    private ImageView mImg;
    private ImageView mLoading;
    private ListView mLv;
    private Button enterBtn;

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

        mLoading = (ImageView) findViewById(R.id.frameImg);
        mLoading.setBackgroundResource(R.drawable.refresh_loading);
        AnimationDrawable drawable = (AnimationDrawable) mLoading.getBackground();
        drawable.start();

        mLv = (ListView) findViewById(R.id.lv);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_item);
        LayoutAnimationController controller = new LayoutAnimationController(animation);
        controller.setDelay(0.5f);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        mLv.setLayoutAnimation(controller);

        enterBtn = (Button) findViewById(R.id.enter_btn);
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActiviy();
            }
        });


//
    }

    private void startAnim() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(300);
        mImg.startAnimation(alphaAnimation);

        TranslateAnimation translateAnimation = new TranslateAnimation(0, 100, 0, 100);
        mImg.startAnimation(translateAnimation);
        //...

    }

    public void startActiviy() {
        Intent intent = new Intent(this, EnterActiviy.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter_anim, R.anim.exit_anim);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.enter_anim, R.anim.exit_anim);
    }



}


