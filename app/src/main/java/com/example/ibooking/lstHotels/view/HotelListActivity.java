package com.example.ibooking.lstHotels.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ibooking.R;
import com.example.ibooking.entities.Hotel;
import com.example.ibooking.lstHotels.LstHotelsContract;
import com.example.ibooking.lstHotels.presenter.LstHotelsPresenter;


import java.util.ArrayList;
import java.util.List;


public class HotelListActivity extends AppCompatActivity implements LstHotelsContract.View {

    private RecyclerView recyclerView;
    private HotelAdapter adapter;
    private LstHotelsPresenter presenter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list);

        recyclerView = findViewById(R.id.hotelsRecyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new HotelAdapter(new ArrayList<>(), getApplicationContext());
        recyclerView.setAdapter(adapter);

        presenter = new LstHotelsPresenter(this);
        presenter.lstHotels();
    }




    @Override
    public void successLstHotels(List<Hotel> lstHotel) {
        adapter.setHotels(lstHotel);
    }

    @Override
    public void failureLstHotels(String err) {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }
}


