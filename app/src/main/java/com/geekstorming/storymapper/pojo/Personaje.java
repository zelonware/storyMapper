package com.geekstorming.storymapper.pojo;

/**
 * Entidad Personaje
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class Personaje {

    // Atts

    int IDPersonaje;
    String nombre;
    String descripcion;

    Faccion faccion;

    // Getters + Setters

    public int getIDPersonaje() {
        return IDPersonaje;
    }

    public void setIDPersonaje(int IDPersonaje) {
        this.IDPersonaje = IDPersonaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Faccion getFaccion() {
        return faccion;
    }

    public void setFaccion(Faccion faccion) {
        this.faccion = faccion;
    }

    // Constructor

    public Personaje(int IDPersonaje, String nombre, String descripcion, Faccion faccion) {
        this.IDPersonaje = IDPersonaje;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.faccion = faccion;
    }

    // toString()

    @Override
    public String toString() {
        return "Personaje{" +
                "IDPersonaje=" + IDPersonaje +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", faccion=" + faccion +
                '}';
    }
}
