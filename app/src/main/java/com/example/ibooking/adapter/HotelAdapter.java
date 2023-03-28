package com.example.ibooking.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
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
        holder.hotelPriceTextView.setText(String.valueOf(hotel.getPrice()));
        holder.hotelRatingRatingBar.setRating(hotel.getRating());
        holder.hotelRoomTextView.setText(String.valueOf(hotel.getRoom()));
        // set image to holder using a library such as Glide or Picasso
        Glide.with(holder.hotelImageView.getContext())
                .load(hotel.getImage())
                .into(holder.hotelImageView);

        holder.hotelRatingRatingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            if (fromUser) {
                updateRating(position, rating);
            }
        });
    }
    public void updateRating(int position, float rating) {
        getSnapshots().getSnapshot(position).getReference().update("rating", rating);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_item, parent, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView hotelImageView;
        TextView hotelNameTextView, hotelPriceTextView , hotelRoomTextView;
        RatingBar hotelRatingRatingBar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hotelImageView = itemView.findViewById(R.id.view_image);
            hotelNameTextView = itemView.findViewById(R.id.view_name);
            hotelPriceTextView = itemView.findViewById(R.id.view_price);
            hotelRatingRatingBar = itemView.findViewById(R.id.view_rating);
            hotelRoomTextView = itemView.findViewById(R.id.view_room);
        }
    }
}
