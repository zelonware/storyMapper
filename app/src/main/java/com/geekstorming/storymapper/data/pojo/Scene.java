package com.geekstorming.storymapper.data.pojo;

/**
 * Entidad Scene, para organizar eventos
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class Scene {

    // Atts

    int sceneID;
    int sceneOrder;
    String sceneRecap;
    boolean sceneWritten;

    Chapter chapter;

    // Getters + Setters

    public int getSceneID() {
        return sceneID;
    }

    public void setSceneID(int sceneID) {
        this.sceneID = sceneID;
    }

    public int getSceneOrder() {
        return sceneOrder;
    }

    public void setSceneOrder(int sceneOrder) {
        this.sceneOrder = sceneOrder;
    }

    public String getSceneRecap() {
        return sceneRecap;
    }

    public void setSceneRecap(String sceneRecap) {
        this.sceneRecap = sceneRecap;
    }

    public boolean isSceneWritten() {
        return sceneWritten;
    }

    public void setSceneWritten(boolean sceneWritten) {
        this.sceneWritten = sceneWritten;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }


    // Constructor

    public Scene(int sceneID, int sceneOrder, String sceneRecap, boolean sceneWritten, Chapter chapter) {
        this.sceneID = sceneID;
        this.sceneOrder = sceneOrder;
        this.sceneRecap = sceneRecap;
        this.sceneWritten = sceneWritten;
        this.chapter = chapter;
    }


    // toString()

    @Override
    public String toString() {
        return "Scene{" +
                "sceneID=" + sceneID +
                ", sceneOrder=" + sceneOrder +
                ", sceneRecap='" + sceneRecap + '\'' +
                ", sceneWritten=" + sceneWritten +
                ", chapter=" + chapter +
                '}';
    }
}
