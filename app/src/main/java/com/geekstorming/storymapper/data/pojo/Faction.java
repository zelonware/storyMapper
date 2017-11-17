package com.geekstorming.storymapper.data.pojo;

import android.support.annotation.NonNull;

/**
 * Faction entity
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class Faction implements Comparable {

    // Atts

    int factionID;
    String factionName;
    String factionObjetive;

    int factionBarrack;

    // Getters + Setters

    public int getFactionID() {
        return factionID;
    }

    public void setFactionID(int factionID) {
        this.factionID = factionID;
    }

    public String getFactionName() {
        return factionName;
    }

    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    public String getFactionObjetive() {
        return factionObjetive;
    }

    public void setFactionObjetive(String factionObjetive) {
        this.factionObjetive = factionObjetive;
    }

    public int getFactionBarrack() {
        return factionBarrack;
    }

    public void setFactionBarrack(int factionBarrack) {
        this.factionBarrack = factionBarrack;
    }

    // Constructor

    public Faction(int factionID, String factionName, String factionObjetive, int factionBarrack) {
        this.factionID = factionID;
        this.factionName = factionName;
        this.factionObjetive = factionObjetive;
        this.factionBarrack = factionBarrack;
    }

    // toString()

    @Override
    public String toString() {
        return getFactionName();
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return factionName.compareTo(((Faction)o).getFactionName());
    }
}
