package com.example.listview_shopphile_ecommerceapp_ensomo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class OrderActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageButton backButton;

    ArrayList<Integer> courseImg = new ArrayList<>(Arrays.asList(R.drawable.jacket, R.drawable.joggers,
            R.drawable.cargo, R.drawable.shoes,
            R.drawable.shorts, R.drawable.skirt,
            R.drawable.slimjeans, R.drawable.widepants));
    ArrayList<String> productNames = new ArrayList<>(Arrays.asList("Penshoppe Jacket", "Jogger Pants", "Cargo Pants", "Penshoppe Shoes", "Orange Shorts",
            "Midi Skirt", "Slim Jeans", "Wide Pants"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        backButton = (ImageButton)findViewById(R.id.backButton);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        OrderAdapter adapter = new OrderAdapter(OrderActivity.this, courseImg, productNames);

        recyclerView.setAdapter(adapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(OrderActivity.this, HomeActivity.class);
                startActivity(mainIntent);
            }
        });

    }
}