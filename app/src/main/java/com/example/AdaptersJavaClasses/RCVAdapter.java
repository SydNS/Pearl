package com.example.AdaptersJavaClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Edutec.R;


public class RCVAdapter extends RecyclerView.Adapter<RCVAdapter.ViewHolder> {
    Context context;
    String [] names;
    String [] descriptions;
    int [] images;
    LayoutInflater inflater;
    public RCVAdapter(Context context,String[]names,String[]descriptions,int[] images){
        this.context=context;
        this.names=names;
        this.descriptions=descriptions;
        this.images=images;

    }


    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView names,desc;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            names=itemView.findViewById(R.id.names);
            desc=itemView.findViewById(R.id.descs);
            imageView=itemView.findViewById(R.id.images);
        }
    }

    @NonNull
    @Override
    public RCVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.rcvitem,parent,false);
        ViewHolder viewHolder =new ViewHolder(view);
        return  viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RCVAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);
        holder.names.setText(names[position]);
        holder.desc.setText(descriptions[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

}
