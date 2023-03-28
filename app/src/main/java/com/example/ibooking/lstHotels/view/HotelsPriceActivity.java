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
import com.example.ibooking.entities.Hotel;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class HotelsPriceActivity extends AppCompatActivity implements HotelAdapter.OnItemClickListener{
    FirebaseFirestore mFirebase;
    FirebaseAuth mAuth;

    ImageButton btn_logout;
    RecyclerView recyclerView;
    HotelAdapter hotelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list);

        mFirebase = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        recyclerView = findViewById(R.id.hotelsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Query query = mFirebase.collection("Hotel").orderBy("price", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<Hotel> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Hotel>().setQuery(query, Hotel.class).build();
        hotelAdapter = new HotelAdapter(firestoreRecyclerOptions);
        hotelAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(hotelAdapter);

        btn_logout = findViewById(R.id.logout_button);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                finish();
                startActivity(new Intent(HotelsPriceActivity.this, LoginActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        hotelAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        hotelAdapter.stopListening();
    }

    @Override
    public void onItemClick(DocumentSnapshot documentSnapshot, int position) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("hotelId", documentSnapshot.getId());
        startActivity(intent);
    }
}