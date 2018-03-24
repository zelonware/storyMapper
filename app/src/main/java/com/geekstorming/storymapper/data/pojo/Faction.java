package com.geekstorming.storymapper.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Faction entity
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class Faction implements Comparable, Parcelable {

    public static final String TAG = "faction";

    // Atts

    int factionID;
    String factionName;
    String factionObjetive;

    int IDBook;

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

    public int getIDBook() {
        return IDBook;
    }

    public void setIDBook(int IDBook) {
        this.IDBook = IDBook;
    }

    // Constructor

    public Faction(int factionID, String factionName, String factionObjetive, int IDBook) {
        this.factionID = factionID;
        this.factionName = factionName;
        this.factionObjetive = factionObjetive;
        this.IDBook = IDBook;
    }

    protected Faction(Parcel in)
    {
        this.factionID = in.readInt();
        this.factionName = in.readString();
        this.factionObjetive = in.readString();
        this.IDBook = in.readInt();
    }

    public static final Creator<Faction> CREATOR = new Creator<Faction>() {
        @Override
        public Faction createFromParcel(Parcel in) {
            return new Faction(in);
        }

        @Override
        public Faction[] newArray(int size) {
            return new Faction[size];
        }
    };

    // toString()

    @Override
    public String toString() {
        return getFactionName();
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return factionName.compareTo(((Faction)o).getFactionName());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(factionID);
        dest.writeString(factionName);
        dest.writeString(factionObjetive);
        dest.writeInt(IDBook);
    }
}
