package com.example.ibooking.entities;



import com.google.gson.annotations.SerializedName;

public class Reservation {

    @SerializedName("reservation_id")

    private Integer reservation_id;

    @SerializedName("user_id")

    private int user;

    @SerializedName("room_id")

    private int room;

    @SerializedName("hotel_id")

    private int hotel;

    @SerializedName("check_in_date")

    private String checkin;

    @SerializedName("check_out_date")

    private String checkout;


    public Reservation(int user, int room, int hotel, String checkin, String checkout) {
        this.user = user;
        this.room = room;
        this.hotel = hotel;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Integer reservation_id) {
        this.reservation_id = reservation_id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}
