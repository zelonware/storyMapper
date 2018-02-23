package com.geekstorming.storymapper.ui.characters.interactor;

import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Character;

/**
 * Created by Beelzenef on 18/02/2018.
 */

public interface ListCharacterInteractor {

    void loadCharacters(Book book);
    void removeCharacter(Character character);
}
