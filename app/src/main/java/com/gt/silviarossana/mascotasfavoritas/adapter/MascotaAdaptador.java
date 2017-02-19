package com.gt.silviarossana.mascotasfavoritas.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gt.silviarossana.mascotasfavoritas.db.ConstructorMascotas;
import com.gt.silviarossana.mascotasfavoritas.pojo.Mascota;
import com.gt.silviarossana.mascotasfavoritas.R;

import java.util.ArrayList;

/**
 * Created by Silvia Rossana on 22/01/2017.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;


    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {


        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvNombreMascotaCV.setText(mascota.getNombre());
        holder.tvLikeMascotaCV.setText(mascota.getNumLike() + " Likes");

        holder.btnLike.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascotas(mascota);
                holder.tvLikeMascotaCV.setText(constructorMascotas.obtenerLikesMascota(mascota)+" Likes");
            }
        });

    }


    @Override
    public int getItemCount() {
        return this.mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreMascotaCV;
        private TextView tvLikeMascotaCV;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            this.imgFoto = (ImageView)itemView.findViewById(R.id.imgFoto);
            this.tvNombreMascotaCV = (TextView)itemView.findViewById(R.id.tvNombreMascotaCV);
            this.tvLikeMascotaCV = (TextView)itemView.findViewById(R.id.tvLikeMascotaCV);
            this.btnLike = (ImageButton)itemView.findViewById(R.id.btnLike);
        }
    }

}
