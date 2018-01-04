package com.geekstorming.storymapper.ui.characters.contracts;

import com.geekstorming.storymapper.base.BasePresenter;
import com.geekstorming.storymapper.base.BaseView;
import com.geekstorming.storymapper.data.pojo.Character;

/**
 * Contract for adding or editing characters
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public interface AddEditCharacterContract  {

    interface Presenter extends BasePresenter
    {
        void editCharacter (Character c);
        void addCharacter (Character c);
    }

    interface View extends BaseView {

    }
}
