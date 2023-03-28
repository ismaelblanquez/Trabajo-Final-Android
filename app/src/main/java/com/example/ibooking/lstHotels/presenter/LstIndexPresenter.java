package com.example.ibooking.lstHotels.presenter;

import com.example.ibooking.entities.Hotel;
import com.example.ibooking.entities.Index;
import com.example.ibooking.lstHotels.LstIndexContract;
import com.example.ibooking.lstHotels.model.LstIndexModel;

import java.util.ArrayList;
import java.util.List;

public class LstIndexPresenter implements LstIndexContract.Presenter {
    private LstIndexModel lstIndexModel;
    private LstIndexContract.View view;

    public LstIndexPresenter(LstIndexContract.View view){
        this.view = view;
        this.lstIndexModel = new LstIndexModel();
    }

    @Override
    public void lstIndex(Index index) {
        lstIndexModel.lstIndexWS(null, new LstIndexContract.Model.OnLstIndexListener() {
            @Override
            public void onSuccess(ArrayList<Index> lstIndex) {
                if (lstIndex != null && lstIndex.size()>0){
                    view.successLstIndex(lstIndex);
                }else{
                    view.failureLstIndex("Error en la lista de datos. ");
                }
            }

            @Override
            public void onFailure(String error) {
                view.failureLstIndex(error);
            }
        });
    }
}