package com.geekstorming.storymapper.ui.locations.interactor;

import com.geekstorming.storymapper.data.pojo.Location;

/**
 * Interactor for adding or editing locations
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public interface AddEditLocationInteractor {

    void editLocation(Location l);
    void addLocation(Location l);

    void isValidData(String name, String desc);
}
