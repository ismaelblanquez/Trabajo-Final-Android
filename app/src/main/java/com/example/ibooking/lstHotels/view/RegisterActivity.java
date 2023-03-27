package com.example.ibooking.lstHotels.view;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ibooking.MainActivity;
import com.example.ibooking.R;

public class RegisterActivity extends AppCompatActivity {

    TextView tvLogin;


    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = (Button) findViewById(R.id.btn_register);
        tvLogin = findViewById(R.id.tv_login);


        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent screenChanger = new Intent(getBaseContext(),
                        MainActivity.class
                );
                startActivity(screenChanger);
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent screenChanger = new Intent(getBaseContext(),
                        LoginActivity.class
                );
                startActivity(screenChanger);
            }
        });
    }
}


