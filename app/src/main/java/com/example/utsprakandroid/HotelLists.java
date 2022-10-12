package com.example.utsprakandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HotelLists extends AppCompatActivity {

    String checkInDate = "";
    String checkOutDate = "";
    String roomAmount = "";

    private RecyclerView recyclerView;
    // array that contain all images
    private int[] images = {
        R.drawable.hotel1, R.drawable.hotel2, R.drawable.hotel3, R.drawable.hotel4, R.drawable.hotel5, R.drawable.hotel6,
            R.drawable.hotel7, R.drawable.hotel8, R.drawable.hotel9, R.drawable.hotel10
    };
    // array that contain hotel names
    private String[] names = {
      "Luxurious Hotel", "Budget Hotel", "BackPacker's Dream", "Some Hotel", "Cool-Looking Hotel", "Nice Hotel",
            "This Cool Hotel", "Lorem Ipsum Hotel", "Someone's Dream Hotel", "Just A Hotel"
    };

    //array that contain hotel prices
    private String[] prices =  {
        "Rp. 12.000.000/night", "Rp. 300.000/night", "Rp. 125.999/night", "Rp. 500.000/night", "Rp. 750.000/night",
            "Rp. 1.250.000/night", "Rp. 2.000.000/night", "Rp. 374.000/night", "Rp. 20.000.000/night", "Rp. 900.000/night"
    };

    //create layoutmanager
    private RecyclerView.LayoutManager layoutManager;
    //create adapter
    private HotelAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_lists);

        Intent intent = getIntent();
        checkInDate = intent.getStringExtra("check_in");
        checkOutDate = intent.getStringExtra("check_out");
        roomAmount = intent.getStringExtra("room");

        //get the object
        TextView checkInDisplay = (TextView) findViewById(R.id.check_in_text);
        TextView checkOutDisplay = (TextView) findViewById(R.id.check_out_text);
        TextView roomAmountDisplay = (TextView) findViewById(R.id.room_text);

        //set the text value
        checkInDisplay.setText("Check-in Date : " + checkInDate);
        checkOutDisplay.setText("Check-out Date : " + checkOutDate);
        roomAmountDisplay.setText("Amount Of Rooms : " + roomAmount);

        //recyclerview code here
        recyclerView = findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // pass values to adapter
        adapter = new HotelAdapter(images,names,prices, this);
        //set adapter onto the recyclerview
        recyclerView.setAdapter(adapter);

    }

}