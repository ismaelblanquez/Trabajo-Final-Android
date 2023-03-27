package com.example.ibooking.lstHotels.model;

import com.example.ibooking.entities.Hotel;
import com.example.ibooking.lstHotels.LstHotelsContract;
import com.example.ibooking.utils.ApiClient;
import com.example.ibooking.utils.ApiInterface;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstHotelsModel implements LstHotelsContract.Model {

    private Gson gson = new Gson(); // Instancia de la clase Gson para convertir objetos Java en JSON y viceversa.

    @Override
    public void lstHotelsWS(OnLstHotelsListener onLstHotelsListener) {
        getHotelsService(onLstHotelsListener); // Llama al método getHotelsService() para obtener la lista de hoteles y notificar al listener correspondiente.
    }

    private void getHotelsService(final OnLstHotelsListener onLstHotelsListener) {
        // Obtiene la instancia de la interfaz ApiInterface para realizar las peticiones HTTP utilizando Retrofit.
        ApiInterface hotelesApi = ApiClient.getBookingAPI().create(ApiInterface.class);

        // Realiza la petición GET para obtener la lista de hoteles y obtiene la respuesta a través de un objeto Call<List<Hotel>>.
        Call<List<Hotel>> lstHoteles = hotelesApi.getHotels();

        // Agrega una nueva llamada asíncrona a la cola de llamadas en segundo plano de Retrofit.
        lstHoteles.enqueue(new Callback<List<Hotel>>() {
            @Override
            public void onResponse(Call<List<Hotel>> call, Response<List<Hotel>> response) {
                // Si la respuesta es exitosa, obtiene la lista de hoteles y notifica al listener correspondiente.
                if (response.isSuccessful()) {
                    List<Hotel> lstHoteles = response.body();
                    onLstHotelsListener.onSuccess(lstHoteles);
                } else {
                    // Si la respuesta no es exitosa, notifica al listener correspondiente el mensaje de error.
                    onLstHotelsListener.onFailure("Error al obtener la lista de hoteles");
                }
            }

            @Override
            public void onFailure(Call<List<Hotel>> call, Throwable t) {
                // Si hay un error en la petición, notifica al listener correspondiente el mensaje de error.
                onLstHotelsListener.onFailure("Error al obtener la lista de hoteles");
            }
        });
    }
}

