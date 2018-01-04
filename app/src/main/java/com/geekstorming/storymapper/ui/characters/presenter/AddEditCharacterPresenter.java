package com.geekstorming.storymapper.ui.characters.presenter;

import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.ui.characters.contracts.AddEditCharacterContract;
import com.geekstorming.storymapper.ui.characters.interactor.AddEditCharacterInteractorImpl;

/**
 * Presenter for adding or editing characters
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class AddEditCharacterPresenter implements AddEditCharacterContract.Presenter {

    AddEditCharacterInteractorImpl interactor;
    AddEditCharacterContract.View view;

    public AddEditCharacterPresenter ()
    {
        this.interactor = new AddEditCharacterInteractorImpl();
    }

    @Override
    public void editCharacter(Character c) {
        interactor.editCharacter(c);
    }

    @Override
    public void addCharacter(Character c) {
        interactor.addCharacter(c);
    }
}
