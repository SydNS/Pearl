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


public class RCVForHorizontalDisplay extends RecyclerView.Adapter<RCVForHorizontalDisplay.ViewHolder> {
    Context context;
    int images[];
    String itemnames[];
    public RCVForHorizontalDisplay(Context context,int [] images,String[]itemnames){
        this.context=context;
        this.images=images;
        this.itemnames=itemnames;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImageView;
        TextView itemNameView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImageView=itemView.findViewById(R.id.itemImage);
            itemNameView=itemView.findViewById(R.id.itemName);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemdisplay,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemImageView.setImageResource(images[position]);
        holder.itemNameView.setText(itemnames[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

}
