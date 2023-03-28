package com.example.ibooking.lstHotels.model;

import com.example.ibooking.entities.Hotel;
import com.example.ibooking.entities.Index;
import com.example.ibooking.lstHotels.LstIndexContract;
import com.example.ibooking.utils.ApiClient;
import com.example.ibooking.utils.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstIndexModel implements LstIndexContract.Model {

    public void lstIndexWS(Index index, OnLstIndexListener onLstIndexListener) {
        ApiInterface apiService = ApiClient.getBookingAPI().create(ApiInterface.class);
        Call<List<Hotel>> indexRespuestaCall = apiService.getHotels();
        indexRespuestaCall.enqueue(new Callback<List<Hotel>>() {
            @Override
            public void onResponse(Call<List<Hotel>> call, Response<List<Hotel>> response) {
                List<Hotel> indexRespuesta = response.body();
                onLstIndexListener.onSuccess(indexRespuesta);

            }

            @Override
            public void onFailure(Call<List<Hotel>> call, Throwable t) {
                onLstIndexListener.onFailure(t.getMessage());
            }
        });
    }
}

