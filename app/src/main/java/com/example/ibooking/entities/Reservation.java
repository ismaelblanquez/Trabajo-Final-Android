package com.example.ibooking.entities;

import java.util.Date;

public class Reservation {
    private String userId;
    private String hotelId;
    private String name;
    private int price;



    public Reservation() {
        // empty constructor required for Firestore
    }

    public Reservation(String userId, String hotelId, String name, int price) {
        this.userId = userId;
        this.hotelId = hotelId;
        this.name = name;
        this.price = price;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Reservation{" +
                "userId='" + userId + '\'' +
                ", hotelId='" + hotelId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
