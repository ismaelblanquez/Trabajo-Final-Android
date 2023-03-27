package com.example.ibooking.entities;

import com.google.gson.annotations.SerializedName;

public class Room {
    @SerializedName("room_id ")

    private Integer room_id ;
    @SerializedName("hotel_id")
    private Integer hotelId;

    @SerializedName("room_type")
    private String room_type ;

    @SerializedName("pricePerNight")
    private Double pricePerNight;
    @SerializedName("availability ")
    private Boolean availability ;


    public Room(Integer hotelId, String room_type, Double pricePerNight, Boolean availability) {
        this.hotelId = hotelId;
        this.room_type = room_type;
        this.pricePerNight = pricePerNight;
        this.availability = availability;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", hotelId=" + hotelId +
                ", room_type='" + room_type + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", availability=" + availability +
                '}';
    }
}
