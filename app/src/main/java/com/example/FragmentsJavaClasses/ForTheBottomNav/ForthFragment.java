package com.example.FragmentsJavaClasses.ForTheBottomNav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.AdaptersJavaClasses.FragAdapter;
import com.example.Edutec.R;
import com.google.android.material.tabs.TabLayout;

public class ForthFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag4,container,false);
        FragAdapter fragAdapter=new FragAdapter(getFragmentManager());

        ViewPager frag4viewpager=view.findViewById(R.id.frag4viewpager);
        TabLayout frag4tablayout=view.findViewById(R.id.tablayoutffrag4);
        frag4viewpager.setAdapter(fragAdapter);
        frag4tablayout.setupWithViewPager(frag4viewpager);

        return view;
    }
}
