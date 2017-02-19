package com.gt.silviarossana.mascotasfavoritas.restApi.model;

import com.gt.silviarossana.mascotasfavoritas.pojo.MascotaRestApi;
import com.gt.silviarossana.mascotasfavoritas.restApi.ConstantesRestApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Silvia Rossana on 18/02/2017.
 */

public class MascotaResponse {

    private ArrayList<MascotaRestApi> mascotas;


    public ArrayList<MascotaRestApi> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<MascotaRestApi> mascotas) {
        this.mascotas = mascotas;
    }
}
