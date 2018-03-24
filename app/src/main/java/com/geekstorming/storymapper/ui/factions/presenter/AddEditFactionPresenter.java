package com.geekstorming.storymapper.ui.factions.presenter;

import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.data.pojo.Faction;
import com.geekstorming.storymapper.ui.factions.contracts.AddEditFactionContract;
import com.geekstorming.storymapper.ui.factions.interactor.AddEditFactionInteractorImpl;

/**
 * Presenter for adding or editing factions
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class AddEditFactionPresenter implements AddEditFactionContract.Presenter, AddEditFactionInteractorImpl.AddFactionListener {

    AddEditFactionInteractorImpl interactor;
    AddEditFactionContract.View view;

    public AddEditFactionPresenter(AddEditFactionContract.View view)
    {
        this.view = view;
        this.interactor = new AddEditFactionInteractorImpl(this);
    }

    @Override
    public void editFaction(Faction f) {
        interactor.editFaction(f);
    }

    @Override
    public void addFaction(Faction f) {
        interactor.addCharacter(f);
    }

    @Override
    public void validateCharacterData(String name, String desc) {
        interactor.isValidData(name, desc);
    }

    @Override
    public void nameIsEmpty() {
        view.onNameEmtpy();
    }

    @Override
    public void descIsEmpty() {
        view.onDescriptionEmpy();
    }

    @Override
    public void onDataValid() {
        view.doAddOrEdit();
    }
}
