package com.example.ActivitiesClasses;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.AdaptersJavaClasses.WTAdapter;
import com.example.Edutec.R;

public class Walkthrough extends AppCompatActivity {
    WTAdapter wtAdapter;
    ViewPager viewPager;
    ImageView [] dots;
    LinearLayout dotslayout;
    int [] pages={R.layout.page1,R.layout.page2, R.layout.page3,R.layout.page4};
    Button buttonDone,buttonNext;
    ImageView dot1,dot2,dot3,dot4;
    TextView skiptextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        wtAdapter=new WTAdapter(Walkthrough.this,pages);
        Animation doneAnimation= AnimationUtils.loadAnimation(Walkthrough.this,R.anim.done);

        viewPager=findViewById(R.id.vp);
        viewPager.setAdapter(wtAdapter);
//        viewPager.setClipToPadding(false);
//        viewPager.setPadding(left,0,right,0);

        dotslayout=(LinearLayout) findViewById(R.id.dotslayout);
        buttonDone=findViewById(R.id.btndone);
        buttonNext=findViewById(R.id.btnnext);
        dot1= findViewById(R.id.dot1);
        dot2= findViewById(R.id.dot2);
        dot3= findViewById(R.id.dot3);
        dot4= findViewById(R.id.dot4);
        skiptextview= findViewById(R.id.skiptext);

        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Walkthrough.this, SignupSignin.class));
                finish();
            }
        });
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            //this gets the current item and adds a one to it making the viewpager jump to the result of the addition
            }
        });

        skiptextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(pages.length-1);
            }
        });

        createDots(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                createDots(position);
                createMovingDot(position);
                replacingNextWithDone(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

  }

    private void replacingNextWithDone(int position) {
        if(position==3){
            buttonNext.setVisibility(View.INVISIBLE);
            Animation nextAnimation= AnimationUtils.loadAnimation(Walkthrough.this,R.anim.next);
            buttonNext.setAnimation(nextAnimation);

            skiptextview.setVisibility(View.INVISIBLE);
            Animation skipAnimation= AnimationUtils.loadAnimation(Walkthrough.this,R.anim.skip);
            buttonNext.setAnimation(nextAnimation);

            buttonDone.setVisibility(View.VISIBLE);
            Animation doneAnimation= AnimationUtils.loadAnimation(Walkthrough.this,R.anim.done);
            buttonDone.setAnimation(doneAnimation);
        }else{
            buttonNext.setVisibility(View.VISIBLE);
            buttonDone.setVisibility(View.INVISIBLE);
            skiptextview.setVisibility(View.VISIBLE);

        }
    }

    private void createDots(int currrentPosition){
        if (currrentPosition==pages.length-4){
            dot1.setImageResource(R.drawable.dotnotseen);
        //this changes the background of the dots by replacing them with the dark backgrounded images
        }else if (currrentPosition==pages.length-3){
            dot2.setImageResource(R.drawable.dotnotseen);
        //this changes the background of the dots by replacing them with the dark backgrounded images

        }else if (currrentPosition==pages.length-2){
            dot3.setImageResource(R.drawable.dotnotseen);
        //this changes the background of the dots by replacing them with the dark backgrounded images

        }else if (currrentPosition==pages.length-1){
            dot4.setImageResource(R.drawable.dotnotseen);
        //this changes the background of the dots by replacing them with the dark backgrounded images

        }

    }

    private void createMovingDot(int currrentPosition){
        if (currrentPosition==pages.length-4){
            dot1.setImageResource(R.drawable.dotnotseen);
            //this changes the background of the dots by replacing them with the dark backgrounded images
        }else if (currrentPosition==pages.length-3){
            dot1.setImageResource(R.drawable.dotseen);
            dot2.setImageResource(R.drawable.dotnotseen);
            //this changes the background of the dots by replacing them with the dark backgrounded images

        }else if (currrentPosition==pages.length-2){
            dot1.setImageResource(R.drawable.dotseen);
            dot2.setImageResource(R.drawable.dotseen);
            dot3.setImageResource(R.drawable.dotnotseen);
            //this changes the background of the dots by replacing them with the dark backgrounded images

        }else if (currrentPosition==pages.length-1){
            dot1.setImageResource(R.drawable.dotseen);
            dot2.setImageResource(R.drawable.dotseen);
            dot3.setImageResource(R.drawable.dotseen);
            dot4.setImageResource(R.drawable.dotnotseen);
            //this changes the background of the dots by replacing them with the dark backgrounded images

        }

    }
}
