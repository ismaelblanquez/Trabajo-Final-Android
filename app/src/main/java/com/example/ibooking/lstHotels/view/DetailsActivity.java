package com.example.ibooking.lstHotels.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.ibooking.R;
import com.example.ibooking.entities.Hotel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class DetailsActivity extends AppCompatActivity {


    FirebaseFirestore mFirebase;
    TextView hotelNameTextView, hotelPriceTextView, hotelDescriptionTextView, hotelRoomsTextView;
    ImageView hotelImageView;
    RatingBar hotelRatingRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);






        mFirebase = FirebaseFirestore.getInstance();

        hotelNameTextView = findViewById(R.id.view_name);
        hotelPriceTextView = findViewById(R.id.view_price);
        hotelDescriptionTextView = findViewById(R.id.view_description);
        hotelRatingRatingBar = findViewById(R.id.view_rating);
        hotelRoomsTextView = findViewById(R.id.view_available_rooms);
        hotelImageView = findViewById(R.id.view_image);


        Intent intent = getIntent();
        String hotelId = intent.getStringExtra("hotelId");
        if (hotelId != null) {
            DocumentReference hotelRef = mFirebase.collection("Hotel").document(hotelId);
            hotelRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if (documentSnapshot.exists()) {
                        Hotel hotel = documentSnapshot.toObject(Hotel.class);
                        // display hotel details on screen
                        hotelNameTextView.setText(hotel.getName());
                        hotelPriceTextView.setText(String.valueOf(hotel.getPrice()));
                        hotelRoomsTextView.setText(String.valueOf(hotel.getRoom()));
                        hotelDescriptionTextView.setText(hotel.getDescription());
                        hotelRatingRatingBar.setRating(hotel.getRating());
                        if (hotel.getImage() != null) {
                            Glide.with(DetailsActivity.this)
                                    .load(hotel.getImage())
                                    .into(hotelImageView);
                        }

                    } else {
                        // hotel not found
                        Toast.makeText(DetailsActivity.this, "Hotel not found", Toast.LENGTH_SHORT).show();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    // handle error
                }
            });
            Button reserveButton = findViewById(R.id.book_button);
            reserveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int availableRooms = Integer.parseInt(hotelRoomsTextView.getText().toString());
                    if (availableRooms > 0) {
                        DocumentReference hotelRef = mFirebase.collection("Hotel").document(hotelId);
                        hotelRef.update("room", availableRooms - 1)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(DetailsActivity.this, "Reservado!", Toast.LENGTH_SHORT).show();
                                        hotelRoomsTextView.setText(String.valueOf(availableRooms - 1));
                                        sendEmail("ismaelblanquez@gmail.com"); // Cambia example@example.com por el correo electrónico del usuario
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(DetailsActivity.this, "Error al reservar", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } else {
                        Toast.makeText(DetailsActivity.this, "No hay habitaciones disponibles", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }

    private void sendEmail(String emailAddress) {
        String subject = "Reserva de hotel";
        String message = "¡Gracias por reservar con nosotros! Su habitación está lista.";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAddress});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Enviar correo electrónico"));
    }



}