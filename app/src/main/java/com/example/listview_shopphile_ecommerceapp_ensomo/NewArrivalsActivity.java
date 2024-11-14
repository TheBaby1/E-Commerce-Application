package com.example.listview_shopphile_ecommerceapp_ensomo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class NewArrivalsActivity extends AppCompatActivity {

    Button addCartButton;
    ImageView itemImage;
    TextView brandName, productName, productPrice;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.list_item);

        dbHandler = new DBHandler(this);

        addCartButton = (Button)findViewById(R.id.addCartButton);
        itemImage = (ImageView)findViewById(R.id.courseImg);
        brandName = (TextView)findViewById(R.id.shorts1);
        productName = (TextView)findViewById(R.id.productName);
        productPrice = (TextView)findViewById(R.id.shortsPrice);

        addCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String itemName = productName.getText().toString();
                String itemPrice = productPrice.getText().toString();
                String itemBrand = brandName.getText().toString();
                int imagePath = R.drawable.shorts;

                dbHandler.addNewItem(itemName, itemPrice, itemBrand, String.valueOf(imagePath));

                Intent cartIntent = new Intent(NewArrivalsActivity.this, CartActivity.class);
                startActivity(cartIntent);

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}