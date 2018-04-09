package com.geekstorming.storymapper.ui.factions.interactor;

import android.text.TextUtils;

import com.geekstorming.storymapper.data.pojo.Faction;
import com.geekstorming.storymapper.data.repos.FactionRepository;

/**
 * Interactor implementation for adding or editing factions
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class AddEditFactionInteractorImpl implements AddEditFactionInteractor {

    AddFactionListener listener;

    public AddEditFactionInteractorImpl(AddFactionListener listener) {
        this.listener = listener;
    }

    @Override
    public void editFaction(Faction c) {
        FactionRepository.getInstance().editFaction(c);
    }

    @Override
    public void addFaction(Faction c) {
        FactionRepository.getInstance().addFaction(c);
    }

    @Override
    public void isValidData(String name, String desc) {
        if (TextUtils.isEmpty(name)) {
            listener.nameIsEmpty();
        }
        else if (TextUtils.isEmpty(desc)) {
            listener.descIsEmpty();
        }
        else {
            listener.onDataValid();
        }
    }

    public interface AddFactionListener {
        void nameIsEmpty();
        void descIsEmpty();
        void onDataValid();
    }
}
