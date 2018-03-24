package com.geekstorming.storymapper.ui.factions.interactor;

import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Faction;

public interface ListFactionInteractor {

    void loadFactions(Book book);
    void removeFaction(Faction faction);
}
