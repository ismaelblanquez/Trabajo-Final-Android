package com.example.ibooking.lstHotels.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ibooking.R;
import com.example.ibooking.entities.Hotel;
import com.example.ibooking.entities.Index;
import com.example.ibooking.lstHotels.LstIndexContract;
import com.example.ibooking.lstHotels.presenter.LstIndexPresenter;


import java.util.ArrayList;


public class HotelListActivity extends AppCompatActivity implements LstIndexContract.View {


        ArrayList<Hotel> lstHotels;
        RecyclerView recyclerHotels;
        Button btnSearch;
        LstIndexPresenter lstIndexPresenter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_hotel_list);

            initComponents();
            initPresenter();
            initData();

            btnSearch.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent screenChanger = new Intent(getBaseContext(),
                            HotelsFilterActivity.class
                    );
                    startActivity(screenChanger);
                }
            });
        }

        public void initComponents(){
            lstHotels = new ArrayList<>();
            recyclerHotels = (RecyclerView) findViewById(R.id.hotelsRecyclerView);
            btnSearch = (Button) findViewById(R.id.search_view);
        }

        public void initPresenter(){
            lstIndexPresenter = new LstIndexPresenter(this);
        }

        public void initData(){
            lstIndexPresenter.lstIndex(null);
        }

        @Override
        public void successLstIndex(ArrayList<Index> lstIndex) {
            for (Hotel hotels: lstIndex.get(0).getHotels()) {
                lstHotels.add(hotels);
                //listaRestaurantes.add(new Restaurantes("La Mafia","Comida italiana"));
                //listaRestaurantes.add(new Restaurantes("El Churrasco","Comida aragonesa"));
                //listaRestaurantes.add(new Restaurantes("Ché","Comida argentina"));
            }

            recyclerHotels.setLayoutManager(new LinearLayoutManager(this));

            HotelAdapter adapter = new HotelAdapter(lstHotels);

            adapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent screenChanger = new Intent(getBaseContext(),
                            Hotel.class
                    );

                    startActivity(screenChanger);
                }
            });

            recyclerHotels.setAdapter(adapter);
        }

        @Override
        public void failureLstIndex(String error) {
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        }

}


