package com.example.listview_shopphile_ecommerceapp_ensomo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {  // Corrected here
    ArrayList<Integer> courseImg;  // Specify the type
    ArrayList<String> courseName;  // Specify the type
    Context context;

    public OrderAdapter(Context context, ArrayList<Integer> courseImg, ArrayList<String> courseName) {
        this.context = context;
        this.courseImg = courseImg;
        this.courseName = courseName;
    }

    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_order, parent, false);
        return new OrderAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, int position) {  // Corrected type here
        // Set image and text
        int res = courseImg.get(position);
        holder.images.setImageResource(res);
        holder.text.setText(courseName.get(position));
    }

    @Override
    public int getItemCount() {
        return courseImg.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView images;
        TextView text;

        public ViewHolder(View view) {
            super(view);
            images = view.findViewById(R.id.courseImg);
            text = view.findViewById(R.id.productName);
        }
    }
}