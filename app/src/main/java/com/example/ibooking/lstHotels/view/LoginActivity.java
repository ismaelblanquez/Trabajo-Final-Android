package com.example.ibooking.lstHotels.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ibooking.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {


        Button btn_register;
        Button btn_login;
        EditText etEmail, etPassword;
        FirebaseFirestore mFirebase;
        FirebaseAuth mAuth;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            mFirebase = FirebaseFirestore.getInstance();
            mAuth = FirebaseAuth.getInstance();

            etEmail = findViewById(R.id.login_email);
            etPassword = findViewById(R.id.login_password);
            btn_register = findViewById(R.id.btn_register);
            btn_login = findViewById(R.id.login_button);

            btn_register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                }
            });


            btn_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String emailUser = etEmail.getText().toString().trim();
                    String passwordUser = etPassword.getText().toString().trim();

                    if (emailUser.isEmpty() && passwordUser.isEmpty()) {
                        Toast.makeText(LoginActivity.this, "Rellena los datos para realizar esta accion", Toast.LENGTH_LONG).show();
                    } else {
                        loginUser(emailUser, passwordUser);
                    }
                }
            });

        }

        private void loginUser(String emailUser, String passwordUser) {
            mAuth.signInWithEmailAndPassword(emailUser, passwordUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        finish();
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        Toast.makeText(LoginActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(LoginActivity.this, "Error al iniciar sesion", Toast.LENGTH_SHORT).show();
                }
            });
        }

        // COMPRUEBA SI LA SESIÓN ESTA INICIADA
        @Override
        protected void onStart() {
            super.onStart();
            FirebaseUser user = mAuth.getCurrentUser();

            if (user != null) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                finish();
            }
        }
    }

