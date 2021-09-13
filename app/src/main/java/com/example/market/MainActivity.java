package com.example.market;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageProduct;
    private ImageButton menu;
    private TextView sumTextView, priceProduct, nameProduct;
    private Integer shopBagSum;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadShop();


        sumTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Нажатие на корзину
            }
        });


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumTextView.setText("0 руб.");
                shopBagSum = 0;
            }
        });

        nameProduct.setOnClickListener(this::addProductOnShopBag);


    }

    public void addProductOnShopBag(View v)
    {
        switch (v.getId())
        {
            case R.id.nameProductTextView:
                shopBagSum = shopBagSum + Integer.parseInt(priceProduct.getText().toString().replace(" руб.", ""));
                reloadShopBag();
                break;
        }
    }

    public void reloadShopBag()
    {
        sumTextView.setText(shopBagSum+" руб.");
    }


    public void loadShop()
    {
        menu = findViewById(R.id.menu);
        sumTextView = findViewById(R.id.sumTextView);
        nameProduct = findViewById(R.id.nameProductTextView);
        priceProduct = findViewById(R.id.priceProductTextView);
        imageProduct = findViewById(R.id.imageProductImageView);
        shopBagSum = 0;

        sumTextView.setText("0 руб.");

        nameProduct.setText("Колготки");
        priceProduct.setText("999 руб.");
        imageProduct.setImageResource(R.mipmap.naruto);


    }


}