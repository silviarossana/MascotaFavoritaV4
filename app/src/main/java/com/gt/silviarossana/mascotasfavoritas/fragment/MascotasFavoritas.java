package com.gt.silviarossana.mascotasfavoritas.fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.gt.silviarossana.mascotasfavoritas.ListaMascotas;
import com.gt.silviarossana.mascotasfavoritas.R;
import com.gt.silviarossana.mascotasfavoritas.adapter.MascotaAdaptador;
import com.gt.silviarossana.mascotasfavoritas.pojo.Mascota;
import com.gt.silviarossana.mascotasfavoritas.pojo.MascotaRestApi;
import com.gt.silviarossana.mascotasfavoritas.presentador.IReciclerViewFragmentPresenter;
import com.gt.silviarossana.mascotasfavoritas.presentador.ReciclerViewFragmentPresenter;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity implements IFragmentMascota {

    Toolbar tbBarraPrincipal;
    //ArrayList<Mascota> mascotas = new ArrayList<Mascota>();;
    private RecyclerView listaMascotas;
    private IReciclerViewFragmentPresenter iReciclerViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        this.listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);

        this.tbBarraPrincipal = (Toolbar) findViewById(R.id.miActionBar);
        if (this.tbBarraPrincipal != null) {
            setSupportActionBar(this.tbBarraPrincipal);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        iReciclerViewFragment = new ReciclerViewFragmentPresenter(this, getBaseContext());
        iReciclerViewFragment.obtenerMascotaFavoritaBaseDatos();
    }

    @Override
    public boolean onSupportNavigateUp() {

        Intent intent = new Intent(this, ListaMascotas.class);
        //intent.putExtra("arrayMascotas", mascotas);

        startActivity(intent);

        onBackPressed();
        return false;
    }

    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        /*GridLayoutManager glm = new GridLayoutManager(this, 2);*/
        this.listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> contactos) {
        MascotaAdaptador adaptador = new MascotaAdaptador(contactos, this);
        return adaptador;
    }

    @Override
    public MascotaAdaptador crearAdaptadorRestApi(ArrayList<MascotaRestApi> mascotas) {
        return null;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador contactoAdaptador) {
        listaMascotas.setAdapter(contactoAdaptador);
    }
}
