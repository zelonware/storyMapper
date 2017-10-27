package com.geekstorming.storymapper.pojo;

/**
 * Entidad Capitulo, para organizar escenas
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class Capitulo {

    // Atts

    int IDCapitulo;
    String nombreCapitulo;
    String progresoTrama;

    // Getters + Setters

    public int getIDCapitulo() {
        return IDCapitulo;
    }

    public void setIDCapitulo(int IDCapitulo) {
        this.IDCapitulo = IDCapitulo;
    }

    public String getNombreCapitulo() {
        return nombreCapitulo;
    }

    public void setNombreCapitulo(String nombreCapitulo) {
        this.nombreCapitulo = nombreCapitulo;
    }

    public String getProgresoTrama() {
        return progresoTrama;
    }

    public void setProgresoTrama(String progresoTrama) {
        this.progresoTrama = progresoTrama;
    }

    // Constructor

    public Capitulo(int IDCapitulo, String nombreCapitulo, String progresoTrama) {
        this.IDCapitulo = IDCapitulo;
        this.nombreCapitulo = nombreCapitulo;
        this.progresoTrama = progresoTrama;
    }

    // toString()


    @Override
    public String toString() {
        return "Capitulo{" +
                "IDCapitulo=" + IDCapitulo +
                ", nombreCapitulo='" + nombreCapitulo + '\'' +
                ", progresoTrama='" + progresoTrama + '\'' +
                '}';
    }
}
