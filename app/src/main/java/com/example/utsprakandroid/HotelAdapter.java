package com.example.utsprakandroid;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//<HotelAdapter.HotelViewHolder>

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {

    private int[] images;
    private String[] hotelNames;
    private String[] prices;
//    private String[] description;

    private Context context;


    public HotelAdapter(int[] images, String[] hotelNames, String[] prices, Context context){
        this.images = images;
        this.hotelNames = hotelNames;
        this.prices = prices;
        this.context = context;
    }


    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotelminiview, parent, false);
        HotelViewHolder hotelViewHolder = new HotelViewHolder(view, context,images, hotelNames, prices);

        return hotelViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {

        int image_id = images[position];
        String hotel_id = hotelNames[position];
        String hotel_price = prices[position];

        holder.image.setImageResource(image_id);
        holder.hotelName.setText(hotel_id);
        holder.hotelPrice.setText(hotel_price);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class HotelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView hotelName;
        TextView hotelPrice;
        Context context;

        //arrays
        int[] images;
        String[] hotelNames;
        String[] prices;


        public HotelViewHolder(@NonNull View itemView, Context context, int[] images, String[] hotelNames, String[] prices) {
            super(itemView);
            image = itemView.findViewById(R.id.image_hotel);
            hotelName = itemView.findViewById(R.id.nama_hotel);
            hotelPrice = itemView.findViewById(R.id.harga_hotel);

            this.context = context;
            this.images = images;
            this.hotelNames = hotelNames;
            this.prices = prices;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, hoteldetails.class);
            intent.putExtra("image_id", images[getAdapterPosition()]);
            intent.putExtra("hotel_name", hotelNames[getAdapterPosition()]);
            intent.putExtra("hotel_price", prices[getAdapterPosition()]);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }


}
