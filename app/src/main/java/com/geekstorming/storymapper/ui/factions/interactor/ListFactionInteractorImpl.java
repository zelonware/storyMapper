package com.geekstorming.storymapper.ui.factions.interactor;

import android.os.AsyncTask;

import com.geekstorming.storymapper.data.db.InteractorCallback;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.data.pojo.Faction;
import com.geekstorming.storymapper.data.repos.CharacterRepository;
import com.geekstorming.storymapper.data.repos.FactionRepository;

import java.util.List;

public class ListFactionInteractorImpl implements ListFactionInteractor, InteractorCallback {

    private Book viewBook;

    ListFactionInteractorImpl.OnLoadFinishedListener listener;

    public ListFactionInteractorImpl(ListFactionInteractorImpl.OnLoadFinishedListener listener)
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
        loadFactions(viewBook);
    }

    @Override
    public void loadFactions(final Book book) {
        new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                viewBook = book;
                listener.onSuccess(FactionRepository.getInstance().getFactions(viewBook));
                return null;
            }
        }.execute();
    }

    @Override
    public void removeFaction(Faction faction) {
        FactionRepository.getInstance().removeFaction(faction);
        loadFactions(viewBook);
    }

    public interface OnLoadFinishedListener {
        void onSuccess(List<Faction> list);

        void onDatabaseError(Error error);

        void onDatabaseError(Exception exception);
    }
}
