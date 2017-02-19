package com.gt.silviarossana.mascotasfavoritas.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.gt.silviarossana.mascotasfavoritas.db.ConstructorMascotas;
import com.gt.silviarossana.mascotasfavoritas.fragment.IFragmentMascota;
import com.gt.silviarossana.mascotasfavoritas.pojo.Mascota;
import com.gt.silviarossana.mascotasfavoritas.pojo.MascotaRestApi;
import com.gt.silviarossana.mascotasfavoritas.restApi.EndpointApi;
import com.gt.silviarossana.mascotasfavoritas.restApi.adapter.RestApiAdapter;
import com.gt.silviarossana.mascotasfavoritas.restApi.model.MascotaResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Silvia Rossana on 5/02/2017.
 */

public class ReciclerViewFragmentPresenter implements IReciclerViewFragmentPresenter {

    private IFragmentMascota iFragmentHome;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    ArrayList<Mascota> mascotas;
    ArrayList<MascotaRestApi> mascotasRestApi;

    public ReciclerViewFragmentPresenter(IFragmentMascota iFragmentHome, Context context) {

        this.iFragmentHome = iFragmentHome;
        this.context = context;

        //this.obtenerMascotaBaseDatos();
    }

    @Override
    public void obtenerMascotaBaseDatos() {

        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();

        this.mostrarMascotaRV();
    }

    @Override
    public void mostrarMascotaRV() {

        iFragmentHome.inicializarAdaptadorRV(iFragmentHome.crearAdaptador(mascotas));
        iFragmentHome.generarLinearLayoutVertical();

    }

    @Override
    public void obtenerMascotaFavoritaBaseDatos() {

        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerConsulta();

        this.mostrarMascotaRV();
    }


}
