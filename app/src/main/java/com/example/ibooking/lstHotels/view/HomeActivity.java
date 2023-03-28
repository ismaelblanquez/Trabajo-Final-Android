package com.example.ibooking.lstHotels.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ibooking.MainActivity;
import com.example.ibooking.R;
import com.example.ibooking.adapter.HotelAdapter;

public class HomeActivity extends AppCompatActivity {
    Button btnSeeAll,btnChoose,btnRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnSeeAll = (Button) findViewById(R.id.btn_seeAll);

        btnSeeAll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent screenChanger = new Intent(getBaseContext(),
                        HotelsActivity.class
                );
                startActivity(screenChanger);
            }
        });

        btnChoose = (Button) findViewById(R.id.btn_choose);

        btnChoose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent screenChanger = new Intent(getBaseContext(),
                        HotelsPriceActivity.class
                );
                startActivity(screenChanger);
            }
        });

        btnRating = (Button) findViewById(R.id.btn_rating);

        btnRating.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent screenChanger = new Intent(getBaseContext(),
                        HotelsRatingActivity.class
                );
                startActivity(screenChanger);
            }
        });

    }
}
