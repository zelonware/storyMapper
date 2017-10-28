package com.geekstorming.storymapper.pojo;

/**
 * Faction entity
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class Faction {

    // Atts

    int factionID;
    String factionName;
    String factionObjetive;

    Location factionBarrack;

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

    public Location getFactionBarrack() {
        return factionBarrack;
    }

    public void setFactionBarrack(Location factionBarrack) {
        this.factionBarrack = factionBarrack;
    }

    // Constructor

    public Faction(int factionID, String factionName, String factionObjetive, Location factionBarrack) {
        this.factionID = factionID;
        this.factionName = factionName;
        this.factionObjetive = factionObjetive;
        this.factionBarrack = factionBarrack;
    }

    // toString()

    @Override
    public String toString() {
        return "Faction{" +
                "factionID=" + factionID +
                ", factionName='" + factionName + '\'' +
                ", factionObjetive='" + factionObjetive + '\'' +
                ", factionBarrack=" + factionBarrack +
                '}';
    }
}
