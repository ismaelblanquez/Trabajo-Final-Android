package com.example.ibooking.entities;

import com.google.gson.annotations.SerializedName;

public class Comment {
    @SerializedName("comment_id")
    private int id;
    @SerializedName("user_id")
    private int userId;
    @SerializedName("hotel_id")
    private int hotelId;
    @SerializedName("comment_text")
    private String comment;
    @SerializedName("rating")
    private int rating;

    public Comment(int userId, int hotelId, String comment, int rating) {
        this.userId = userId;
        this.hotelId = hotelId;
        this.comment = comment;
        this.rating = rating;
    }

    public Comment(int id, int userId, int hotelId, String comment, int rating) {
        this.id = id;
        this.userId = userId;
        this.hotelId = hotelId;
        this.comment = comment;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
