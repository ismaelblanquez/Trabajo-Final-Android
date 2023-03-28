package com.example.ibooking.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ibooking.R;
import com.example.ibooking.entities.Hotel;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import org.checkerframework.checker.nullness.qual.NonNull;

public class HotelAdapter extends FirestoreRecyclerAdapter<Hotel, HotelAdapter.ViewHolder> {
    public HotelAdapter(@NonNull FirestoreRecyclerOptions<Hotel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Hotel hotel) {
        // set data to views in holder
        holder.hotelNameTextView.setText(hotel.getName());
        holder.hotelNameTextView.setText(hotel.getName());
        holder.hotelPriceTextView.setText(String.valueOf(hotel.getPrice()));
        holder.hotelRatingTextView.setText(String.valueOf(hotel.getRating()));
        // set image to holder using a library such as Glide or Picasso
        Glide.with(holder.hotelImageView.getContext())
                .load(hotel.getImage())
                .into(holder.hotelImageView);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_item, parent, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView hotelImageView;
        TextView hotelNameTextView, hotelPriceTextView, hotelRatingTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hotelImageView = itemView.findViewById(R.id.view_image);
            hotelNameTextView = itemView.findViewById(R.id.view_name);
            hotelPriceTextView = itemView.findViewById(R.id.view_price);
            hotelRatingTextView = itemView.findViewById(R.id.view_rating);
        }
    }
}
