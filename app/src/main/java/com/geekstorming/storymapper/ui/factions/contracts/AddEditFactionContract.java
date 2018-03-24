package com.geekstorming.storymapper.ui.factions.contracts;

import com.geekstorming.storymapper.base.BasePresenter;
import com.geekstorming.storymapper.base.BaseView;
import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.data.pojo.Faction;

/**
 * Contract for adding or editing characters
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public interface AddEditFactionContract {

    interface Presenter extends BasePresenter
    {
        void editFaction(Faction c);
        void addFaction(Faction c);

        void validateCharacterData(String name, String desc);
    }

    interface View extends BaseView {
        void onNameEmtpy();
        void onDescriptionEmpy();
        void doAddOrEdit();
    }
}
