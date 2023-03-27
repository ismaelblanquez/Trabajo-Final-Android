package com.example.ibooking.entities;


import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("room_id")
    private int user_id ;
    @SerializedName("name")
    private String name;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;


    public User(String name, String lastName, String email, String password) {
    }

    public User(int id, String name, String lastName, String email, String password) {
        this.user_id  = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Object getCurrentUser() {
        return this;
    }

    public int getId() {
        return user_id ;
    }

    public void setId(int id) {
        this.user_id  = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
