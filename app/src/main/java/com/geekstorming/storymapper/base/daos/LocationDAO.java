package com.geekstorming.storymapper.base.daos;

import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Location;

import java.util.ArrayList;

public interface LocationDAO {
    ArrayList<Location> loadAll(Book bookID);
    long add(Location location);
    boolean exists(Location location);
    long delete(Location location);
    long update(Location location);
}
