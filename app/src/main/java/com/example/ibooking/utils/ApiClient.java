package com.example.ibooking.utils;

import static okhttp3.internal.Internal.instance;

import okhttp3.internal.Internal;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "http://192.168.0.125:8080/iBookingApi/webresources/api/";

    private  static Retrofit retrofit = null;
    private ApiInterface myApi;
    public static Retrofit getBookingAPI() {
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }



    public ApiInterface getMyApi() {
        return myApi;
    }
}
