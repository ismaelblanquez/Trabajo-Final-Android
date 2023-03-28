package com.example.ibooking.lstHotels;

import com.example.ibooking.entities.Hotel;
import com.example.ibooking.entities.Index;

import java.util.ArrayList;
import java.util.List;

public interface LstIndexContract {
    public interface View {
        void successLstIndex(ArrayList<Index> lstIndex);
        void failureLstIndex(String error);
    }
    public interface Presenter{
        // CASO DE USO -> DISTINTOS APARTADOS DEL TRABAJO
        void lstIndex(Index index);
    }
    public interface Model{
        interface OnLstIndexListener{
            void onSuccess(ArrayList<Index> lstIndex);
            void onFailure(String error);
        }
        void lstIndexWS(Index index,
                        OnLstIndexListener onLstIndexListener);
    }
}
