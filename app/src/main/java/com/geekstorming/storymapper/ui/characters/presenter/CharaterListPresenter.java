package com.geekstorming.storymapper.ui.characters.presenter;

import com.geekstorming.storymapper.base.BaseView;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.ui.characters.contracts.ListCharacterContract;
import com.geekstorming.storymapper.ui.characters.interactor.ListCharacterInteractorImpl;

import java.util.List;

/**
 * Created by Beelzenef on 18/02/2018.
 */

public class CharaterListPresenter implements ListCharacterContract.Presenter, ListCharacterInteractorImpl.OnLoadFinishedListener {

    ListCharacterInteractorImpl interactor;
    ListCharacterContract.View view;

    public CharaterListPresenter(ListCharacterContract.View v) {
        this.view = v;
        interactor = new ListCharacterInteractorImpl(this);
    }

    @Override
    public void loadCharacters(Book b) {
        interactor.loadCharacters(b);
    }

    @Override
    public void removeCharacter(Character character) {
        interactor.removeCharacter(character);
    }

    @Override
    public void onSuccess(List<Character> list) {
        view.showCharacters(list);
        view.dismissProgressDialog();
    }

    @Override
    public void onDatabaseError(Error error) {
        view.onDatabaseError(error);
    }

    @Override
    public void onDatabaseError(Exception exception) {
        view.onDatabaseError(exception);
    }
}
