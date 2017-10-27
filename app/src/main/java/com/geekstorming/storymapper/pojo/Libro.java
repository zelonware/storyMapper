package com.geekstorming.storymapper.pojo;

/**
 * Entidad Libro, proyecto creativo
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class Libro {

    // Atts

    int IDLibro;
    String titulo;
    String genero;
    int nPalabras;

    // Getters + Setters

    public int getIDLibro() {
        return IDLibro;
    }

    public void setIDLibro(int IDLibro) {
        this.IDLibro = IDLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getnPalabras() {
        return nPalabras;
    }

    public void setnPalabras(int nPalabras) {
        this.nPalabras = nPalabras;
    }

    // Constructor

    public Libro(int IDLibro, String titulo, String genero, int nPalabras) {
        this.IDLibro = IDLibro;
        this.titulo = titulo;
        this.genero = genero;
        this.nPalabras = nPalabras;
    }

    // toString()

    @Override
    public String toString() {
        return "Libro{" +
                "IDLibro=" + IDLibro +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", nPalabras=" + nPalabras +
                '}';
    }
}
