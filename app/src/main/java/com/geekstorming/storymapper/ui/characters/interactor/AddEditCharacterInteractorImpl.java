package com.geekstorming.storymapper.ui.characters.interactor;

import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.data.repos.CharacterRepository;

/**
 * Interactor implementation for adding or editing characters
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class AddEditCharacterInteractorImpl implements AddEditCharacterInteractor {
    @Override
    public void editCharacter(Character c) {
        CharacterRepository.getInstance().editCharacter(c);
    }

    @Override
    public void addCharacter(Character c) {
        CharacterRepository.getInstance().addCharacter(c);
    }
}
