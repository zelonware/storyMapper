package com.geekstorming.storymapper.pojo;

/**
 * Entidad Faccion, para bandos y grupos
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class Faccion {

    // Atts

    int IDFaccion;
    String nombreFaccion;
    String objetivoFaccion;

    Lugar sede;

    // Getters + Setters

    public int getIDFaccion() {
        return IDFaccion;
    }

    public void setIDFaccion(int IDFaccion) {
        this.IDFaccion = IDFaccion;
    }

    public String getNombreFaccion() {
        return nombreFaccion;
    }

    public void setNombreFaccion(String nombreFaccion) {
        this.nombreFaccion = nombreFaccion;
    }

    public String getObjetivoFaccion() {
        return objetivoFaccion;
    }

    public void setObjetivoFaccion(String objetivoFaccion) {
        this.objetivoFaccion = objetivoFaccion;
    }

    public Lugar getSede() {
        return sede;
    }

    public void setSede(Lugar sede) {
        this.sede = sede;
    }

    // Constructor

    public Faccion(int IDFaccion, String nombreFaccion, String objetivoFaccion, Lugar sede) {
        this.IDFaccion = IDFaccion;
        this.nombreFaccion = nombreFaccion;
        this.objetivoFaccion = objetivoFaccion;
        this.sede = sede;
    }

    // toString()

    @Override
    public String toString() {
        return "Faccion{" +
                "IDFaccion=" + IDFaccion +
                ", nombreFaccion='" + nombreFaccion + '\'' +
                ", objetivoFaccion='" + objetivoFaccion + '\'' +
                ", sede=" + sede +
                '}';
    }
}
