package com.geekstorming.storymapper.ui.characters.interactor;

import android.os.AsyncTask;

import com.geekstorming.storymapper.data.db.InteractorCallback;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.data.repos.CharacterRepository;
import com.geekstorming.storymapper.ui.books.interactor.ListBookInteractorImpl;

import java.util.List;

/**
 * Created by Beelzenef on 18/02/2018.
 */

public class ListCharacterInteractorImpl implements ListCharacterInteractor, InteractorCallback {

    private Book viewBook;

    ListCharacterInteractorImpl.OnLoadFinishedListener listener;

    public ListCharacterInteractorImpl (ListCharacterInteractorImpl.OnLoadFinishedListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void onError(Error error) {
        listener.onDatabaseError(error);
    }

    @Override
    public void onError(Exception exception) {
        listener.onDatabaseError(exception);
    }

    @Override
    public void onSuccess() {
        loadCharacters(viewBook);
    }

    @Override
    public void loadCharacters(final Book book) {
        new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                viewBook = book;
                listener.onSuccess(CharacterRepository.getInstance().getCharacters(viewBook));
                return null;
            }
        }.execute();
    }

    @Override
    public void removeCharacter(Character character) {
        CharacterRepository.getInstance().removeCharacter(character);
        loadCharacters(viewBook);
    }

    public interface OnLoadFinishedListener {
        void onSuccess(List<Character> list);

        void onDatabaseError(Error error);

        void onDatabaseError(Exception exception);
    }
}
