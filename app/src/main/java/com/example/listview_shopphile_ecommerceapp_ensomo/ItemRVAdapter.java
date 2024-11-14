package com.example.listview_shopphile_ecommerceapp_ensomo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ItemRVAdapter extends RecyclerView.Adapter<ItemRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<ItemModal> itemModalArrayList;
    private Context context;

    // constructor
    public ItemRVAdapter(ArrayList<ItemModal> itemModalArrayList, Context context) {
        this.itemModalArrayList = itemModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflating our layout file for recycler view items
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // setting data to views of recycler view item
        ItemModal modal = itemModalArrayList.get(position);
        holder.itemNameTV.setText(modal.getItemName());
        holder.itemDescTV.setText(modal.getItemDescription());
        holder.itemPriceTV.setText(modal.getItemPrice());
        holder.itemQuantityTV.setText(modal.getItemQuantity());
    }

    @Override
    public int getItemCount() {
        // returning the size of array list
        return itemModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for text views
        private TextView itemNameTV, itemDescTV, itemPriceTV, itemQuantityTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing text views
            itemNameTV = itemView.findViewById(R.id.idTVItemName);
            itemDescTV = itemView.findViewById(R.id.idTVItemDescription);
            itemPriceTV = itemView.findViewById(R.id.idTVItemPrice);
            itemQuantityTV = itemView.findViewById(R.id.idTVItemQuantity);
        }
    }
}
