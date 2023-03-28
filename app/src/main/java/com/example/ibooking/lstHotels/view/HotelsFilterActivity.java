package com.example.ibooking.lstHotels.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ibooking.R;
import com.example.ibooking.entities.Hotel;
import com.example.ibooking.entities.Index;
import com.example.ibooking.lstHotels.LstIndexContract;
import com.example.ibooking.lstHotels.presenter.LstIndexPresenter;

import java.util.List;

public class HotelsFilterActivity extends AppCompatActivity implements LstIndexContract.View {



        Button btnSearch;
        EditText filter;
        LstIndexPresenter lstHotelsPresenter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_hotel_list);

            initComponents();
            initPresenter();
            initData();

            btnSearch.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent screenChanger = new Intent(getBaseContext(),
                            RegisterActivity.class
                    );
                    Bundle categoryBundle = new Bundle();
                    categoryBundle.putString("Categoria", filter.getText().toString());
                    screenChanger.putExtras(categoryBundle);

                    startActivity(screenChanger);
                }
            });

        }

        public void initComponents(){
            btnSearch = (Button) findViewById(R.id.search_view);
          //  filtroCategoria = (EditText) findViewById(R.id.edtTxtFilCat);
        }

        public void initPresenter(){
            lstHotelsPresenter = new LstIndexPresenter(this);
        }

        public void initData(){
            lstHotelsPresenter.lstIndex(null);
        }

        @Override
        public void successLstIndex(List<Hotel> lstIndex) {
            for (Hotel index: lstIndex) {
                //filter.setText(lstIndex.get(get));
            }
        }

        @Override
        public void failureLstIndex(String error) {
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        }
    }

