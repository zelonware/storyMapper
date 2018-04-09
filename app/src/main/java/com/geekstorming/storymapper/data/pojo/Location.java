package com.geekstorming.storymapper.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Entidad Location, para refugiar a personajes y acoger facciones
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class Location implements Comparable, Parcelable {

    // Atts

    public static final String TAG = "location";

    int locationID;
    String locationName;
    String locationDesc;

    int IDBook;

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

    public int getIDBook() {
        return IDBook;
    }

    public void setIDBook(int IDBook) {
        this.IDBook = IDBook;
    }

    // Constructor

    public Location(int locationID, String locationName, String locationDesc, int bookID) {
        this.locationID = locationID;
        this.locationName = locationName;
        this.locationDesc = locationDesc;
        this.IDBook = bookID;
    }

    protected Location(Parcel in)
    {
        this.locationID = in.readInt();
        this.locationName = in.readString();
        this.locationDesc = in.readString();
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    // toString()

    @Override
    public String toString() {
        return getLocationName();
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return locationName.compareTo(((Location)o).getLocationName());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(locationID);
        dest.writeString(locationName);
        dest.writeString(locationDesc);
    }
}
