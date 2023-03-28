package com.example.ibooking.entities;

import android.location.Location;



public class Hotel {

    private int hotel_id;

    private String name;

    private String description;

    private int location;

    private int rating;



    public Hotel(String name, String description, int rating, int location) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.location = location;

    }

    public String getName() {
        return name;
    }

    public int getHotel_id() {
        return hotel_id;
    }


    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }


    public int getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotel_id=" + hotel_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location=" + location +
                ", rating=" + rating +
                '}';
    }
}
