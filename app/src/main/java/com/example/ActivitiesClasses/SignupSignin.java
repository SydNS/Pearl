package com.example.ActivitiesClasses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.Edutec.R;


public class SignupSignin extends AppCompatActivity {
    ViewFlipper viewFlipper;
    RelativeLayout alreadyregisteredlogin,notyetregisterhere;
    Button signinbutton,signupbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_signin);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        viewFlipper=findViewById(R.id.viewflipper);
        alreadyregisteredlogin=findViewById(R.id.vplogin);
        notyetregisterhere=findViewById(R.id.vpnotregistered);
        signupbutton=findViewById(R.id.Signup);
        signinbutton=findViewById(R.id.Signin);
        Animation doneAnimation= AnimationUtils.loadAnimation(SignupSignin.this,R.anim.loginwith);

        RelativeLayout loginwith =(RelativeLayout)findViewById(R.id.loginwiths);
        loginwith.setAnimation(doneAnimation);


        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setDisplayedChild(0);
            }
        });
        signinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupSignin.this, MainActivity.class));
                finish();
            }
        });

        notyetregisterhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setDisplayedChild(1);
                alreadyregisteredlogin.setVisibility(View.VISIBLE);
                notyetregisterhere.setVisibility(View.INVISIBLE);
            }
        });
        alreadyregisteredlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setDisplayedChild(0);
                alreadyregisteredlogin.setVisibility(View.INVISIBLE);
                notyetregisterhere.setVisibility(View.VISIBLE);
            }
        });
    }
}
