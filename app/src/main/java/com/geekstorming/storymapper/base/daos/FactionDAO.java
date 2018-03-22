package com.geekstorming.storymapper.base.daos;

import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Faction;

import java.util.ArrayList;

public interface FactionDAO {
    ArrayList<Faction> loadAll(Book bookID);
    long add(Faction faction);
    boolean exists(Faction faction);
    long delete(Faction faction);
    long update(Faction faction);
}
