package com.gt.silviarossana.mascotasfavoritas.db;

import android.content.ContentValues;
import android.content.Context;

import com.gt.silviarossana.mascotasfavoritas.R;
import com.gt.silviarossana.mascotasfavoritas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Silvia Rossana on 5/02/2017.
 */

public class ConstructorMascotas {

    private static boolean INSERTO_REGISTROS = false;
    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }


    public ArrayList<Mascota> obtenerDatos() {

        BaseDatos baseDatos = new BaseDatos(context);
        insertarMascotas(baseDatos);

        return baseDatos.obtenerAllMascotas();

    }

    public ArrayList<Mascota> obtenerConsulta() {

        BaseDatos baseDatos = new BaseDatos(context);
        return baseDatos.obtenerAllMascotas();

    }



    public void insertarMascotas(BaseDatos baseDatos){

        if(!INSERTO_REGISTROS) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Perla");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perritouno);
            baseDatos.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Pochito");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perritodos);
            baseDatos.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Blaqui");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perritotres);
            baseDatos.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Susi");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perritocuatro);
            baseDatos.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Puppy");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perritocinco);
            baseDatos.insertarMascota(contentValues);

            INSERTO_REGISTROS = true;
        }

    }

    public void darLikeMascotas(Mascota mascota){

        BaseDatos baseDatos = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKE_MASCOTA_NUMERO_LIKES, LIKE);

        baseDatos.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){

        BaseDatos baseDatos = new BaseDatos(context);
        return baseDatos.obtenerLikesContacto(mascota);
    }


}
