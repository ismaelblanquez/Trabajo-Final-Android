package com.example.ibooking.lstHotels.view;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ibooking.MainActivity;
import com.example.ibooking.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {


    Button btn_register;
    EditText etEmail, etPassword;
    FirebaseFirestore mFirebase;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebase = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailUser = etEmail.getText().toString().trim();
                String passwordUser = etPassword.getText().toString().trim();

                if (emailUser.isEmpty() && passwordUser.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Rellena los datos para realizar esta accion", Toast.LENGTH_LONG).show();
                } else {
                    registerUser(emailUser, passwordUser);
                }
            }
        });
    }

    private void registerUser(String emailUser, String passwordUser) {
        mAuth.createUserWithEmailAndPassword(emailUser, passwordUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //Pilla el id del usuario
                String id = "";
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if (currentUser != null) {
                    id = currentUser.getUid();
                } else {
                    Toast.makeText(RegisterActivity.this, "No se pudo obtener el usuario actual", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Hace el map
                Map<String, Object> map = new HashMap<>();
                map.put("id", id);
                map.put("email", emailUser);
                map.put("password", passwordUser);

                // Si hay exito te manda a otra actividad
                mFirebase.collection("user").document(id).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        finish();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        Toast.makeText(RegisterActivity.this, "Usuario registrado con exito", Toast.LENGTH_SHORT).show();
                    }
                    // Si falla notifica del error
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterActivity.this, "Error al guardar", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterActivity.this, "Error al registrar", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


