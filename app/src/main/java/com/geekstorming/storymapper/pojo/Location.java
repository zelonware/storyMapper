package com.geekstorming.storymapper.pojo;

/**
 * Entidad Location, para refugiar a personajes y acoger facciones
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class Location {

    // Atts

    int locationID;
    String locationName;
    String locationDesc;

    // Getters + Setters

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    // Constructor

    public Location(int locationID, String locationName, String locationDesc) {
        this.locationID = locationID;
        this.locationName = locationName;
        this.locationDesc = locationDesc;
    }

    // toString()

    @Override
    public String toString() {
        return getLocationName();
    }
}
