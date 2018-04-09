package com.geekstorming.storymapper.ui.factions.interactor;

import com.geekstorming.storymapper.data.pojo.Faction;

/**
 * Interactor for adding or editing factions
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public interface AddEditFactionInteractor {

    void editFaction(Faction f);
    void addFaction(Faction f);

    void isValidData(String name, String desc);
}
