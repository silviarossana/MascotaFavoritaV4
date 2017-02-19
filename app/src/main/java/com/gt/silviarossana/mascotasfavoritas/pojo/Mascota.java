package com.gt.silviarossana.mascotasfavoritas.pojo;

import java.io.Serializable;

/**
 * Created by Silvia Rossana on 22/01/2017.
 */

public class Mascota implements Serializable {

    private int id;
    private String nombre;
    private int foto;
    private int numLike;

    public Mascota(String nombre, int foto, int numLike) {
        this.nombre = nombre;
        this.foto = foto;
        this.numLike = numLike;
    }

    public Mascota() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getNumLike() {
        return numLike;
    }

    public void setNumLike(int numLike) {
        this.numLike = numLike;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
