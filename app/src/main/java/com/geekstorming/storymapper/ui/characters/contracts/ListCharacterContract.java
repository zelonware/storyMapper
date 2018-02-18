package com.geekstorming.storymapper.ui.characters.contracts;

import com.geekstorming.storymapper.base.BasePresenter;
import com.geekstorming.storymapper.base.BaseView;
import com.geekstorming.storymapper.data.pojo.Character;

import java.util.List;

/**
 * Created by Beelzenef on 18/02/2018.
 */

public interface ListCharacterContract {

    interface View extends BaseView {

        void showCharacters(List<Character> characterList);

        void onDatabaseError(Error error);
        void onDatabaseError(Exception exception);
        void showProgressDialog(String message);
        void dismissProgressDialog();
    }

    interface Presenter extends BasePresenter {
        void loadCharacters();
        void removeCharacter(Character character);
    }
}
