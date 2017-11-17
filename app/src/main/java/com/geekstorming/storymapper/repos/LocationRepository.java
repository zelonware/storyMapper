package com.geekstorming.storymapper.repos;

import com.geekstorming.storymapper.pojo.Location;

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

    // Constructor
    static {
        locationRepository = new LocationRepository();
    }

    private LocationRepository() {
        locations = new ArrayList<>();
        initializeLocations();
    }

    // Methods

    private void initializeLocations() {
        addLocation(new Location(1, "Location 1", "Description 1"));
        addLocation(new Location(2, "Location 2", "Description 2"));
        addLocation(new Location(3, "Location 3", "Description 3"));
    }

    public void addLocation(Location l) {
        locations.add(l);
    }

    public static LocationRepository getInstance() {
        return locationRepository;
    }

    public ArrayList<Location> getLocations() {
        Collections.sort(locations);
        return locations;
    }
}
