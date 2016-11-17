package com.xingzhiqiao.animationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button viewBtn, propBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewBtn = (Button) findViewById(R.id.view_anim);
        propBtn = (Button) findViewById(R.id.prop_anim);

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewAnimationActivity.class);
                startActivity(intent);
            }
        });

        propBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PropAnimActivity.class);
                startActivity(intent);

            }
        });


    }
}
