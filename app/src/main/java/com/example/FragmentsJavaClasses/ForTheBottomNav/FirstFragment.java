package com.example.FragmentsJavaClasses.ForTheBottomNav;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.AdaptersJavaClasses.MyAdapterViewFlippper;
import com.example.AdaptersJavaClasses.RCVForHorizontalDisplay;
import com.example.Edutec.R;

public class FirstFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1, container, false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), layoutManager.getOrientation());

        Button exitting = view.findViewById(R.id.exitButton);
        RecyclerView itemDisplay = view.findViewById(R.id.itemDisplayRCV);

        int[] imageList = {R.drawable.astudio21, R.drawable.astudio52, R.drawable.astudio45, R.drawable.astudio49, R.drawable.astudio45, R.drawable.astudio49, R.drawable.astudio49};
        String[] nameList = {"syd", "edge", "java", "major", "edge", "java", "major"};
        itemDisplay.setAdapter(new RCVForHorizontalDisplay(getActivity(), imageList, nameList));
        itemDisplay.setLayoutManager(layoutManager);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemDisplay.setItemAnimator(itemAnimator);

        int[] slides = {R.layout.page1, R.layout.page2, R.layout.page3, R.layout.page4};
        Context mcontext;
//        mcontext = inflater.getContext();
//        ViewPager featuresViewpager = view.findViewById(R.id.featuresViewpager);
//        WTAdapter wtAdapter = new WTAdapter(mcontext, slides);
//        featuresViewpager.setAdapter(wtAdapter);
//        featuresViewpager.setClipToPadding(false);
//        featuresViewpager.setPadding(3, 0, 3, 0);
//        featuresViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
        int[] imageListFoAdapterView = {R.drawable.asui6, R.drawable.asui61, R.drawable.asui25, R.drawable.asui58, R.drawable.asui39, R.drawable.asui39, R.drawable.asui24};
        AdapterViewFlipper adapterViewFlipper =view.findViewById(R.id.featuresAdapterViewFlipper);
        adapterViewFlipper.setAdapter(new MyAdapterViewFlippper(getActivity(),nameList,imageListFoAdapterView));
        adapterViewFlipper.setAutoStart(true);
        adapterViewFlipper.setFlipInterval(5000);


        return view;
    }


}
