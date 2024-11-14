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

public class CartActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageButton backButton;
    Button checkoutButton;

    ArrayList<Integer> courseImg = new ArrayList<>();
    ArrayList<String> productNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        backButton = (ImageButton)findViewById(R.id.backButton);
        checkoutButton = (Button)findViewById(R.id.checkoutButton);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        Intent intent = getIntent();
        int imagePath = intent.getIntExtra("imagePath", -1);
        String productName = intent.getStringExtra("productName");
        String productPrice = intent.getStringExtra("productPrice");
        String itemBrand = intent.getStringExtra("itemBrand");

        if (imagePath != -1) {
            courseImg.add(imagePath); // No need to parse, it's already an int
        }
        if (productName != null) {
            productNames.add(productName);
        }


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        CartAdapter adapter = new CartAdapter(CartActivity.this, courseImg, productNames);
        recyclerView.setAdapter(adapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(CartActivity.this, HomeActivity.class);
                startActivity(mainIntent);
            }
        });

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orderIntent = new Intent(CartActivity.this, OrderActivity.class);
                startActivity(orderIntent);
            }
        });

    }
}