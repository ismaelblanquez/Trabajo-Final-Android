package com.example.ibooking.entities;

import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("location_id")
    private int id;
    @SerializedName("city")
    private String city;
    @SerializedName("country")
    private String country;

    public Location(String city, String country) {

        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}
