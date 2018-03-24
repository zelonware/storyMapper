package com.geekstorming.storymapper.ui.factions.presenter;

import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.data.pojo.Faction;
import com.geekstorming.storymapper.ui.factions.contracts.ListFactionContract;
import com.geekstorming.storymapper.ui.factions.interactor.ListFactionInteractorImpl;

import java.util.List;


public class FactionListPresenter implements ListFactionContract.Presenter, ListFactionInteractorImpl.OnLoadFinishedListener {

    ListFactionInteractorImpl interactor;
    ListFactionContract.View view;

    public FactionListPresenter(ListFactionContract.View v) {
        this.view = v;
        interactor = new ListFactionInteractorImpl(this);
    }

    @Override
    public void loadFactions(Book b) {
        interactor.loadFactions(b);
    }

    @Override
    public void removeFaction(Faction character) {
        interactor.removeFaction(character);
    }

    @Override
    public void onSuccess(List<Faction> list) {
        view.showFactions(list);
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
