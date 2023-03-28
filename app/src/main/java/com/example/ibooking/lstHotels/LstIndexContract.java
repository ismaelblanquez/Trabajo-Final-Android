package com.example.ibooking.lstHotels;

import com.example.ibooking.entities.Hotel;
import com.example.ibooking.entities.Index;

import java.util.List;

public interface LstIndexContract {
    public interface View {
        void successLstIndex(List<Hotel> lstIndex);
        void failureLstIndex(String error);
    }
    public interface Presenter{
        // CASO DE USO -> DISTINTOS APARTADOS DEL TRABAJO
        void lstIndex(Index index);
    }
    public interface Model{
        interface OnLstIndexListener{
            void onSuccess(List<Hotel> lstIndex);
            void onFailure(String error);
        }
        void lstIndexWS(Index index,
                        OnLstIndexListener onLstIndexListener);
    }
}
