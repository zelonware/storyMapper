package com.geekstorming.storymapper.ui.locations.interactor;

import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Location;

public interface ListLocationInteractor {

    void loadLocations(Book book);
    void removeLocation(Location location);
}
