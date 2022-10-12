package com.example.utsprakandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class hoteldetails extends AppCompatActivity {

    ImageView imageView;
    TextView hotelNameDisplay;
    TextView hotelPriceDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteldetails);

        imageView = (ImageView) findViewById(R.id.hotel_image_detail);
        hotelNameDisplay = (TextView) findViewById(R.id.nama_detail);
        hotelPriceDisplay = (TextView) findViewById(R.id.harga_detail);

        Intent intent = getIntent();



        imageView.setImageResource(intent.getIntExtra("image_id", 0));
        hotelNameDisplay.setText(intent.getStringExtra("hotel_name"));
        hotelPriceDisplay.setText(intent.getStringExtra("hotel_price"));



    }
}