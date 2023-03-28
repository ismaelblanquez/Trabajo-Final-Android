package com.example.ibooking.entities;

import com.example.ibooking.utils.ApiInterface;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class Index{

    @SerializedName("hotel")
    private List<Hotel> hotels;

    public List<Hotel> getHotels() {
        return this.hotels;
    }
    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }
}
