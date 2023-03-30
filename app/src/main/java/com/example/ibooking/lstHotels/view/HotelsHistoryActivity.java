package com.example.ibooking.lstHotels.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ibooking.R;
import com.example.ibooking.adapter.HotelAdapter;
import com.example.ibooking.adapter.ReservationAdapter;
import com.example.ibooking.entities.Hotel;
import com.example.ibooking.entities.Reservation;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class HotelsHistoryActivity extends AppCompatActivity implements ReservationAdapter.OnItemClickListener {
    FirebaseFirestore mFirebase;
    FirebaseAuth mAuth;

    ImageButton btn_logout;
    RecyclerView recyclerView;
    ReservationAdapter reservationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list);
        getSupportActionBar().hide();
        mFirebase = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        recyclerView = findViewById(R.id.hotelsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Query query = mFirebase.collection("reservation").orderBy("name", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<Reservation> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Reservation>().setQuery(query, Reservation.class).build();
        reservationAdapter = new ReservationAdapter(firestoreRecyclerOptions); // initialize the instance variable
        reservationAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(reservationAdapter);

        btn_logout = findViewById(R.id.logout_button);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                finish();
                startActivity(new Intent(HotelsHistoryActivity.this, LoginActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (reservationAdapter != null) { // add null check to avoid NPE
            reservationAdapter.startListening();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (reservationAdapter != null) { // add null check to avoid NPE
            reservationAdapter.stopListening();
        }
    }

    @Override
    public void onItemClick(DocumentSnapshot documentSnapshot, int position) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("reservationId", documentSnapshot.getId());
        startActivity(intent);
    }
}
