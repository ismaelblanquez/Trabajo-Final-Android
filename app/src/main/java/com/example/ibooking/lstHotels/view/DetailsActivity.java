package com.example.ibooking.lstHotels.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

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
    TextView hotelNameTextView, hotelPriceTextView, hotelDescriptionTextView;
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
        }
    }
}