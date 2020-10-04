package com.example.AdaptersJavaClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Edutec.R;

public class MyAdapterViewFlippper extends BaseAdapter {

    Context context;
    String[] features;
    int [] imageFeatures;
    LayoutInflater layoutInflater;

    public MyAdapterViewFlippper(Context context,String[] features,int[] imageFeatures){
        this.context=context;
        this.features=features;
        this.imageFeatures=imageFeatures;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return features.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =layoutInflater.inflate(R.layout.itemdisplay,parent,false);
        TextView textView =view.findViewById(R.id.itemName);
        ImageView imageView =view.findViewById(R.id.itemImage);
        textView.setText(features[position]);
        imageView.setImageResource(imageFeatures[position]);
        return view;
    }
}
