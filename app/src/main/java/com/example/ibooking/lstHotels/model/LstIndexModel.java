package com.example.ibooking.lstHotels.model;

import com.example.ibooking.entities.Index;
import com.example.ibooking.lstHotels.LstIndexContract;
import com.example.ibooking.utils.ApiClient;
import com.example.ibooking.utils.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstIndexModel implements LstIndexContract.Model {

    public void lstIndexWS(Index index, OnLstIndexListener onLstIndexListener) {
        ApiInterface apiService = ApiClient.getBookingAPI().create(ApiInterface.class);
        Call<ArrayList<Index>> indexRespuestaCall = apiService.getHotels();
        indexRespuestaCall.enqueue(new Callback<ArrayList<Index>>() {
            @Override
            public void onResponse(Call<ArrayList<Index>> call, Response<ArrayList<Index>> response) {
                ArrayList<Index> indexRespuesta = response.body();
                onLstIndexListener.onSuccess(indexRespuesta);
            }

            @Override
            public void onFailure(Call<ArrayList<Index>> call, Throwable t) {
                onLstIndexListener.onFailure(t.getMessage());
            }
        });
    }
}

