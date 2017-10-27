package com.geekstorming.storymapper.pojo;

/**
 * Entidad Escena, para organizar eventos
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class Escena {

    // Atts

    int IDEscena;
    int ordenEscena;
    String resumenEscena;
    boolean escenaEscrita;

    Capitulo capitulo;

    // Getters + Setters

    public int getIDEscena() {
        return IDEscena;
    }

    public void setIDEscena(int IDEscena) {
        this.IDEscena = IDEscena;
    }

    public int getOrdenEscena() {
        return ordenEscena;
    }

    public void setOrdenEscena(int ordenEscena) {
        this.ordenEscena = ordenEscena;
    }

    public String getResumenEscena() {
        return resumenEscena;
    }

    public void setResumenEscena(String resumenEscena) {
        this.resumenEscena = resumenEscena;
    }

    public boolean isEscenaEscrita() {
        return escenaEscrita;
    }

    public void setEscenaEscrita(boolean escenaEscrita) {
        this.escenaEscrita = escenaEscrita;
    }

    public Capitulo getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(Capitulo capitulo) {
        this.capitulo = capitulo;
    }


    // Constructor

    public Escena(int IDEscena, int ordenEscena, String resumenEscena, boolean escenaEscrita, Capitulo capitulo) {
        this.IDEscena = IDEscena;
        this.ordenEscena = ordenEscena;
        this.resumenEscena = resumenEscena;
        this.escenaEscrita = escenaEscrita;
        this.capitulo = capitulo;
    }


    // toString()

    @Override
    public String toString() {
        return "Escena{" +
                "IDEscena=" + IDEscena +
                ", ordenEscena=" + ordenEscena +
                ", resumenEscena='" + resumenEscena + '\'' +
                ", escenaEscrita=" + escenaEscrita +
                ", capitulo=" + capitulo +
                '}';
    }
}
