package com.example.ibooking.lstHotels;

import com.example.ibooking.entities.Hotel;

import java.util.List;

public interface LstHotelsContract {
    public  interface  View{
        void successLstHotels(List<Hotel> lstHotel);
        void failureLstHotels(String err);
    }

    public interface  Presenter{
        void lstHotels();

    }

    public interface  Model{
        interface  OnLstHotelsListener{
            void  onSuccess(List<Hotel> index);
            void  onFailure(String error);
        }
        void lstHotelsWS(LstHotelsContract.Model.OnLstHotelsListener onLstHotelsListener);

    }
}
