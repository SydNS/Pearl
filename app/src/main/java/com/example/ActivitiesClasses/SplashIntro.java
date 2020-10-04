package com.example.ActivitiesClasses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.Edutec.R;

public class SplashIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_intro);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ImageView nearme=findViewById(R.id.nearme);
        RelativeLayout introset=findViewById(R.id.introset);
        Animation clockwiseAnimation= AnimationUtils.loadAnimation(SplashIntro.this,R.anim.introclockwise);
        Animation anticlockwiseAnimation= AnimationUtils.loadAnimation(SplashIntro.this,R.anim.introanticlockwise);
        nearme.setAnimation(clockwiseAnimation);
        introset.setAnimation(anticlockwiseAnimation);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashIntro.this, Walkthrough.class));
                finish();

            }
        };
        new Handler().postDelayed(runnable,6000);

    }
}
