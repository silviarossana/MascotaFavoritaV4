package com.gt.silviarossana.mascotasfavoritas.fragment;

import com.gt.silviarossana.mascotasfavoritas.adapter.MascotaAdaptador;
import com.gt.silviarossana.mascotasfavoritas.pojo.Mascota;
import com.gt.silviarossana.mascotasfavoritas.pojo.MascotaRestApi;

import java.util.ArrayList;

/**
 * Created by Silvia Rossana on 5/02/2017.
 */

public interface IFragmentMascota {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public MascotaAdaptador crearAdaptadorRestApi(ArrayList<MascotaRestApi> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador contactoAdaptador);

}
