package com.example.ibooking.lstHotels.presenter;

import com.example.ibooking.entities.Hotel;
import com.example.ibooking.lstHotels.LstHotelsContract;
import com.example.ibooking.lstHotels.model.LstHotelsModel;

import java.util.List;

public class LstHotelsPresenter implements LstHotelsContract.Presenter {
    // Instancia de la clase LstHotelsModel y la interfaz LstHotelsContract.View.
    private LstHotelsModel lstHotelsModel;
    private LstHotelsContract.View view;

    /**
     * Constructor del HotelLstPresenter que inicializa el modelo y la vista.
     *
     * @param view - la vista a la que se comunica.
     */
    public LstHotelsPresenter(LstHotelsContract.View view) {
        this.lstHotelsModel = new LstHotelsModel();
        this.view = view;
    }


    @Override
    public void lstHotels() {
        lstHotelsModel.lstHotelsWS(new LstHotelsContract.Model.OnLstHotelsListener() {
            @Override
            public void onSuccess(List<Hotel> hotels) {
                // Si la lista de hoteles no es nula y tiene algún elemento se llama al método successLstHotels de la vista.
                if (hotels != null && hotels.size() > 0) {
                    view.successLstHotels(hotels);
                }
            }

            @Override
            public void onFailure(String error) {
                // Si ha habido algún error en la petición se llama al método failureLstHotels de la vista.
                view.failureLstHotels(error);
            }
        });
    }
}