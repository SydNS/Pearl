package com.example.ActivitiesClasses;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;


import com.example.FragmentsJavaClasses.ForTheBottomNav.FirstFragment;
import com.example.FragmentsJavaClasses.ForTheBottomNav.ForthFragment;
import com.example.FragmentsJavaClasses.ForTheBottomNav.SecondFragment;
import com.example.FragmentsJavaClasses.ForTheBottomNav.ThirdFragment;
import com.example.Edutec.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Fragment selectedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        startActivity(new Intent(MainActivity.this,SplashIntro.class));
        getSupportFragmentManager().beginTransaction().replace(R.id.activitymain,new FirstFragment()).commit();
        bottomNavigationView=findViewById(R.id.bottomnavmenu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("ResourceType")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectedFragment=null;
                switch (item.getItemId()){
                    case R.id.bnhome:
                        selectedFragment=new FirstFragment();
                        break;

                    case R.id.bndash:
                        selectedFragment=new SecondFragment();
                        break;

                    case R.id.bnplaces:
                        selectedFragment=new ThirdFragment();
                        break;

                    case R.id.bnprofile:
                        selectedFragment=new ForthFragment();
                        break;


                }
                getSupportFragmentManager().beginTransaction().replace(R.id.activitymain,selectedFragment).commit();
                return true;
            }
        });

    }
}
