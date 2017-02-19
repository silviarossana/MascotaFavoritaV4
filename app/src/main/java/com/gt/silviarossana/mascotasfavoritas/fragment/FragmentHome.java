package com.gt.silviarossana.mascotasfavoritas.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gt.silviarossana.mascotasfavoritas.R;
import com.gt.silviarossana.mascotasfavoritas.adapter.MascotaAdaptador;
import com.gt.silviarossana.mascotasfavoritas.pojo.Mascota;
import com.gt.silviarossana.mascotasfavoritas.pojo.MascotaRestApi;
import com.gt.silviarossana.mascotasfavoritas.presentador.IReciclerViewFragmentPresenter;
import com.gt.silviarossana.mascotasfavoritas.presentador.ReciclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by Silvia Rossana on 29/01/2017.
 */

public class FragmentHome extends Fragment implements IFragmentMascota {

    private RecyclerView listaMascotas;
    private IReciclerViewFragmentPresenter iReciclerViewFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        this.listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        iReciclerViewFragment = new ReciclerViewFragmentPresenter(this, getContext());
        iReciclerViewFragment.obtenerMascotaBaseDatos();

        //FloatingActionButton miFab = (FloatingActionButton) findViewById(R.id.fabMiFab);

        return v;

    }


    public void irMascotasFavoritas(View view){

        Intent intent = new Intent(getActivity(), MascotasFavoritas.class);
        //intent.putExtra("arrayMascotas", mascotas);

        startActivity(intent);

    }

    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        /*GridLayoutManager glm = new GridLayoutManager(this, 2);*/
        this.listaMascotas.setLayoutManager(llm);

            /*Bundle parametro = getIntent().getExtras();
            Toast.makeText(this, "Diste like a " + parametro, Toast.LENGTH_SHORT).show();
            if (getIntent().getExtras() != null) {
                mascotas = (ArrayList<Mascota>) getIntent().getSerializableExtra("arrayMascotas");
            } else {
                this.inicializarListaMascotas();
            }*/
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {

        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public MascotaAdaptador crearAdaptadorRestApi(ArrayList<MascotaRestApi> mascotas) {
        return null;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador mascotaAdaptador) {

        listaMascotas.setAdapter(mascotaAdaptador);
    }
}
