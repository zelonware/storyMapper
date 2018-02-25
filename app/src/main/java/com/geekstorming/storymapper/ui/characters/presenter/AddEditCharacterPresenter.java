package com.geekstorming.storymapper.ui.characters.presenter;

import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.ui.characters.contracts.AddEditCharacterContract;
import com.geekstorming.storymapper.ui.characters.interactor.AddEditCharacterInteractorImpl;

/**
 * Presenter for adding or editing characters
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class AddEditCharacterPresenter implements AddEditCharacterContract.Presenter, AddEditCharacterInteractorImpl.AddCharacterListener {

    AddEditCharacterInteractorImpl interactor;
    AddEditCharacterContract.View view;

    public AddEditCharacterPresenter (AddEditCharacterContract.View view)
    {
        this.view = view;
        this.interactor = new AddEditCharacterInteractorImpl(this);
    }

    @Override
    public void editCharacter(Character c) {
        interactor.editCharacter(c);
    }

    @Override
    public void addCharacter(Character c) {
        interactor.addCharacter(c);
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
