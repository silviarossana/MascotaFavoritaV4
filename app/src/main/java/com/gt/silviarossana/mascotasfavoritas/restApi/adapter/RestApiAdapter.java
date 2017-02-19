package com.gt.silviarossana.mascotasfavoritas.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gt.silviarossana.mascotasfavoritas.restApi.ConstantesRestApi;
import com.gt.silviarossana.mascotasfavoritas.restApi.EndpointApi;
import com.gt.silviarossana.mascotasfavoritas.restApi.deserializador.MascotaDeserializador;
import com.gt.silviarossana.mascotasfavoritas.restApi.model.MascotaResponse;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Silvia Rossana on 18/02/2017.
 */

public class RestApiAdapter {

    public EndpointApi establecerConexionRestApiInstagram(Gson gson){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointApi.class);
    }


    public Gson construyeGsonDeserializadorMediaRecent(){

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());


        return gsonBuilder.create();
    }


}
