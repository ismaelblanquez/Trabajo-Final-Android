package com.example.ibooking.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import com.example.ibooking.lstHotels.view.DetailsActivity;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

import org.checkerframework.checker.nullness.qual.NonNull;

public class HotelAdapter extends FirestoreRecyclerAdapter<Hotel, HotelAdapter.ViewHolder>  {
    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public HotelAdapter(@NonNull FirestoreRecyclerOptions<Hotel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position, @NonNull Hotel hotel) {
        // set data to views in holder

        holder.hotelNameTextView.setText(hotel.getName());
        holder.hotelDescriptionTextView.setText(hotel.getDescription());
        holder.hotelPriceTextView.setText(String.valueOf(hotel.getPrice()));
        holder.hotelRatingRatingBar.setRating(hotel.getRating());
       // holder.hotelRoomTextView.setText(String.valueOf(hotel.getRoom()));
        // set image to holder using a library such as Glide or Picasso
        Glide.with(holder.hotelImageView.getContext())
                .load(hotel.getImage())
                .into(holder.hotelImageView);

        DocumentSnapshot documentSnapshot = getSnapshots().getSnapshot(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(documentSnapshot, position);
                }
            }
        });

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
        TextView hotelNameTextView, hotelPriceTextView , hotelDescriptionTextView;
        RatingBar hotelRatingRatingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hotelImageView = itemView.findViewById(R.id.view_image);
            hotelNameTextView = itemView.findViewById(R.id.view_name);
            hotelDescriptionTextView = itemView.findViewById(R.id.view_description);
            hotelPriceTextView = itemView.findViewById(R.id.view_price);
            hotelRatingRatingBar = itemView.findViewById(R.id.view_rating);
            //hotelRoomTextView = itemView.findViewById(R.id.view_room);

            hotelImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), DetailsActivity.class);
                    intent.putExtra("hotelId", getSnapshots().getSnapshot(getBindingAdapterPosition()).getId());
                    itemView.getContext().startActivity(intent);
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(getSnapshots().getSnapshot(getBindingAdapterPosition()), getBindingAdapterPosition());
                    }
                }
            });
        }
    }



    public interface OnItemClickListener {
        void onItemClick(DocumentSnapshot documentSnapshot, int position);
    }

}
