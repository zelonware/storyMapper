package com.geekstorming.storymapper.ui.factions.contracts;

import com.geekstorming.storymapper.base.BasePresenter;
import com.geekstorming.storymapper.base.BaseView;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Faction;

import java.util.List;

public interface ListFactionContract {

    interface View extends BaseView {

        void showFactions(List<Faction> factionList);

        void onDatabaseError(Error error);
        void onDatabaseError(Exception exception);
        void showProgressDialog(String message);
        void dismissProgressDialog();
    }

    interface Presenter extends BasePresenter {
        void loadFactions(Book b);
        void removeFaction(Faction faction);
    }
}
