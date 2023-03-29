package com.example.ibooking.entities;


public class Hotel {

    private int hotelId;
    private String name;

    private String description;

    private String image;

    private int room;

    private int price;

    private int rating;

    private String location;

    public Hotel() {
    }

    public Hotel(int hotelId, String name, String description, String image, int room, int price, int rating, String location) {
        this.hotelId = hotelId;
        this.name = name;
        this.description = description;
        this.image = image;
        this.room = room;
        this.price = price;
        this.rating = rating;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getPrice() {

        return price;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", room=" + room +
                ", price=" + price +
                ", rating=" + rating +
                ", location='" + location + '\'' +
                '}';
    }
}
