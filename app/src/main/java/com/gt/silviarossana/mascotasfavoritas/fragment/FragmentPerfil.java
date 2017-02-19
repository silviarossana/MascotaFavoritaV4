package com.gt.silviarossana.mascotasfavoritas.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.google.gson.Gson;
import com.gt.silviarossana.mascotasfavoritas.R;
import com.gt.silviarossana.mascotasfavoritas.adapter.MascotaAdaptador;
import com.gt.silviarossana.mascotasfavoritas.adapter.MascotaAdaptadorPerfil;
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
 * Created by Silvia Rossana on 29/01/2017.
 */

public class FragmentPerfil extends Fragment {

    ArrayList<MascotaRestApi> mascotas;
    private RecyclerView listaMascotas;
    private final int GRID_LAYOUT_TAMANIO = 2;
    public static final int USUARIO_PERRITO_POCHITO = 0;
    public static final int USUARIO_GATITO_WAFLE = 1;

    public static final String USUARIO_NOMBRE_PERRITO_POCHITO = "perritopochito";
    public static final String USUARIO_NOMBRE_GATITO_WAFLE = "gatitowafle";

    public static int USUARIO_ACTUAL = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);


        this.listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotasPerfil);
        this.obtenerMedioRecientes();

        return v;

    }


    public void inicializarAdaptador(){

        MascotaAdaptadorPerfil adaptador = new MascotaAdaptadorPerfil(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);

        this.inicializarGridLayout();
    }

    public void inicializarGridLayout(){

        GridLayoutManager glm = new GridLayoutManager(getActivity(), GRID_LAYOUT_TAMANIO);
        this.listaMascotas.setLayoutManager(glm);
    }


    public void obtenerMedioRecientes() {

        //Conexión al servidor
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointApi endpointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        //Call<MascotaResponse> contactoResponseCall = endpointApi.getRecentMedia();
        Call<MascotaResponse> contactoResponseCall = null; //= endpointApi.getRecentMediaWafleSandbox();

        //Enviar en un método
        switch (USUARIO_ACTUAL) {

            case USUARIO_PERRITO_POCHITO:
                    contactoResponseCall = endpointApi.getRecentMedia();
                break;

            case USUARIO_GATITO_WAFLE:
                contactoResponseCall = endpointApi.getRecentMediaWafleSandbox();
                break;

        }


        contactoResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse contactoResponse = response.body();
                mascotas = contactoResponse.getMascotas();
                //mostrarMascota(mascotas);
                inicializarAdaptador();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Fallo la conexión", Toast.LENGTH_LONG).show();
                Log.e("Fallo la conexión", t.toString());
            }
        });
    }


    public void mostrarMascota(ArrayList<MascotaRestApi> mascotaRestApis){

        for(int c = 0; c < mascotaRestApis.size(); c++){
            Toast.makeText(getActivity(), "Array " + mascotaRestApis.get(c).getUrlFoto(), Toast.LENGTH_LONG).show();
        }

    }

}
