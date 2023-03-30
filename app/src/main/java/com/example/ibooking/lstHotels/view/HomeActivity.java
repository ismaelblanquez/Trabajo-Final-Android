package com.example.ibooking.lstHotels.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ibooking.R;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    Button btnSeeAll,btnChoose,btnRating, btnHistory;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();


        setContentView(R.layout.activity_home);
        ImageButton btn_logout;
        btn_logout = findViewById(R.id.logout_button);
        mAuth = FirebaseAuth.getInstance();
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                finish();
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            }
        });


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

        btnHistory = (Button) findViewById(R.id.btn_history);
        btnHistory.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent screenChanger = new Intent(getBaseContext(),
                        HotelsHistoryActivity.class
                );
                startActivity(screenChanger);
            }
        });
    }
}
