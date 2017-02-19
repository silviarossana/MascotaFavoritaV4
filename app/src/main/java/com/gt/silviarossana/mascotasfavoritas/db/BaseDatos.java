package com.gt.silviarossana.mascotasfavoritas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.gt.silviarossana.mascotasfavoritas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Silvia Rossana on 5/02/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        //super(context, name, factory, version);
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;

    }

    /*public BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }*/

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String queryCrearTablaContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA
                    + "(" + ConstantesBaseDatos.TABLE_MASCOTA_ID   + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE       + " TEXT," +
                    ConstantesBaseDatos.TABLE_MASCOTA_FOTO         + " INTEGER" +
                ")";

        String queryCrearTablaLikesContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA
                + "(" + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID      + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA     + " INTEGER," +
                ConstantesBaseDatos.TABLE_LIKE_MASCOTA_NUMERO_LIKES    + " INTEGER," +
                " FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID + ") " +
                " REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTA + "(" + ConstantesBaseDatos.TABLE_MASCOTA_ID +")" +
                ")";

        sqLiteDatabase.execSQL(queryCrearTablaContacto);
        sqLiteDatabase.execSQL(queryCrearTablaLikesContacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA);

        this.onCreate(sqLiteDatabase);
    }

    public ArrayList<Mascota> obtenerAllMascotas() {
        ArrayList<Mascota> contactos = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor registros = sqLiteDatabase.rawQuery(query, null);
        Mascota mascota;
        String queryLikes;
        Cursor registroLikes;

        while(registros.moveToNext()){

            mascota = new Mascota();
            mascota.setId(registros.getInt(0));
            mascota.setNombre(registros.getString(1));
            mascota.setFoto(registros.getInt(2));

            queryLikes = "SELECT COUNT ( " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_NUMERO_LIKES + ")" +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + " = " + mascota.getId();

            registroLikes = sqLiteDatabase.rawQuery(queryLikes, null);
            if(registroLikes.moveToNext()){
                mascota.setNumLike(registroLikes.getInt(0));

            }else{

                mascota.setNumLike(0);
            }

            //contacto.setLikes();
            contactos.add(mascota);
        }

        sqLiteDatabase.close();
        return contactos;
    }

    public void insertarMascota(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKE_MASCOTA, null, contentValues);
        db.close();
    }


    public int obtenerLikesContacto(Mascota mascota){

        int likes = 0;

        String query = "SELECT COUNT ( " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_NUMERO_LIKES + ")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + " = " + mascota.getId();

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor registros = database.rawQuery(query, null);

        Toast.makeText(context, "Tamaño " + registros.getCount(), Toast.LENGTH_SHORT).show();

        while(registros.moveToNext()){
            likes = registros.getInt(0);
        }

        database.close();

        return likes;
    }

}
