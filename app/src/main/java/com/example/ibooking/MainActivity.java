package com.example.ibooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.ibooking.lstHotels.view.RegisterActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent screenChanger = new Intent(getBaseContext(),
                        RegisterActivity.class //FichaDescriptiva-LoginActivity
                );
                startActivity(screenChanger);
            }
        }, 2000);
    }



}