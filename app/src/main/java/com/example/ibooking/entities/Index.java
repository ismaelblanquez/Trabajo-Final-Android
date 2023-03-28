package com.example.ibooking.entities;

import com.example.ibooking.utils.ApiInterface;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class Index{


    @SerializedName("hotels")
    private ArrayList<Hotel> hotels;

    public ArrayList<Hotel> getHotels() {
        return this.hotels;
    }
    public void setHotels(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }
}
