package com.example.ibooking.lstHotels.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ibooking.R;
import com.example.ibooking.entities.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolderHotels> implements View.OnClickListener {

    List<Hotel> lstHotels;
    Context context;
    private View.OnClickListener listener;

    public HotelAdapter( Context context) {
        lstHotels = new ArrayList<>();
        this.context = context;
    }

    public void addHotels(ArrayList<Hotel> hotels){
        lstHotels.clear();
        lstHotels.addAll(hotels);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolderHotels onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_hotel,null,false);
        view.setOnClickListener(this);
        return new ViewHolderHotels(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderHotels holder, int position) {
        /*Hotel hotel = lstHotels.get(position);
        holder.name.setText(hotel.getName());
        holder.description.setText(hotel.getDescription());
        holder.rating.setText(hotel.getRating());
        holder.location.setText(hotel.getLocation());*/
        holder.setItem(this.lstHotels.get(position));

    }

    @Override
    public int getItemCount() {
        return lstHotels.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null){
            listener.onClick(view);
        }
    }



    public class ViewHolderHotels extends RecyclerView.ViewHolder {

        TextView hotel_id, name,description, rating, location;

        public ViewHolderHotels(View itemView) {
            super(itemView);
          // etiNombre = (TextView) itemView.findViewById(R.id.idNombre);
           // etiDescription = (TextView) itemView.findViewById(R.id.idCategoria);
        }

        public void setItem(Hotel hotel) {
            hotel_id = itemView.findViewById(R.id.hotel_id);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            rating = itemView.findViewById(R.id.rating);
            location = itemView.findViewById(R.id.location);

            hotel_id.setText(String.valueOf(hotel.getHotel_id()));
            name.setText(hotel.getName());
            description.setText(hotel.getDescription());
            location.setText(String.valueOf(hotel.getLocation()));
            rating.setText(hotel.getRating());
        }
    }
}

