package com.geekstorming.storymapper.data.repos;

import com.geekstorming.storymapper.base.daos.LocationDAO;
import com.geekstorming.storymapper.data.dao.LocationDAOImpl;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Location;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Location repository, location list
 *
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class LocationRepository {

    // Atts
    ArrayList<Location> locations;
    private static LocationRepository locationRepository;

    LocationDAO dao;

    // Constructor
    static {
        locationRepository = new LocationRepository();
    }

    private LocationRepository() {
        locations = new ArrayList<>();
        dao = new LocationDAOImpl();
    }

    // Methods

    public void addLocation(Location l) {
        dao.add(l);
    }

    public static LocationRepository getInstance() {
        return locationRepository;
    }

    public ArrayList<Location> getLocations(Book book) {
        locations = dao.loadAll(book);
        return locations;
    }

    public void removeLocation (Location l) { dao.delete(l); }

    public void searchLocation (Location l) { dao.exists(l); }

    public void editLocation (Location l) { dao.update(l); }
}
