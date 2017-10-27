package com.geekstorming.storymapper.pojo;

/**
 * Entidad Lugar, para refugiar a personajes y acoger facciones
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class Lugar {

    // Atts

    int IDLugar;
    String nombre;
    String direccion;

    // Getters + Setters

    public int getIDLugar() {
        return IDLugar;
    }

    public void setIDLugar(int IDLugar) {
        this.IDLugar = IDLugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Constructor

    public Lugar(int IDLugar, String nombre, String direccion) {
        this.IDLugar = IDLugar;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    // toString()

    @Override
    public String toString() {
        return "Lugar{" +
                "IDLugar=" + IDLugar +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
