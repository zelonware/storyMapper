package com.geekstorming.storymapper.ui.characters.interactor;

import android.text.TextUtils;

import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.data.repos.CharacterRepository;

/**
 * Interactor implementation for adding or editing characters
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class AddEditCharacterInteractorImpl implements AddEditCharacterInteractor {

    AddCharacterListener listener;

    public AddEditCharacterInteractorImpl(AddCharacterListener listener) {
        this.listener = listener;
    }

    @Override
    public void editCharacter(Character c) {
        CharacterRepository.getInstance().editCharacter(c);
    }

    @Override
    public void addCharacter(Character c) {
        CharacterRepository.getInstance().addCharacter(c);
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

    public interface AddCharacterListener {
        void nameIsEmpty();
        void descIsEmpty();
        void onDataValid();
    }
}
