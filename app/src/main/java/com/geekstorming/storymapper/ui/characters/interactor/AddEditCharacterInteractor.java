package com.geekstorming.storymapper.ui.characters.interactor;

import com.geekstorming.storymapper.data.pojo.Character;

/**
 * Interactor for adding or editing characters
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public interface AddEditCharacterInteractor {

    void editCharacter (Character c);
    void addCharacter (Character c);

    void isValidData(String name, String desc);
}
