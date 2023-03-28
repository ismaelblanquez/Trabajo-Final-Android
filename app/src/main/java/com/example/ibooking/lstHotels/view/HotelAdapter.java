package com.example.ibooking.lstHotels.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ibooking.R;
import com.example.ibooking.entities.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolderHotels> implements View.OnClickListener {

    ArrayList<Hotel> lstHotels;
    private View.OnClickListener listener;

    public HotelAdapter(ArrayList<Hotel> lstHotels) {
        this.lstHotels = lstHotels;
    }

    @Override
    public ViewHolderHotels onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_hotel_list,null,false);
        view.setOnClickListener(this);
        return new ViewHolderHotels(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderHotels holder, int position) {
        holder.etiNombre.setText(lstHotels.get(position).getName());
        holder.etiDescription.setText(lstHotels.get(position).getDescription());
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

        TextView etiNombre,etiDescription;

        public ViewHolderHotels(View itemView) {
            super(itemView);
          //  etiNombre = (TextView) itemView.findViewById(R.id.idNombre);
           // etiDescription = (TextView) itemView.findViewById(R.id.idCategoria);
        }
    }
}

