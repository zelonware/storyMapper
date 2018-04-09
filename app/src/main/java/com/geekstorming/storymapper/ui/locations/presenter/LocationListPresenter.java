package com.geekstorming.storymapper.ui.locations.presenter;

import com.geekstorming.storymapper.data.pojo.Book;

import com.geekstorming.storymapper.data.pojo.Location;
import com.geekstorming.storymapper.ui.locations.contracts.ListLocationContract;
import com.geekstorming.storymapper.ui.locations.interactor.ListLocationInteractorImpl;

import java.util.List;


public class LocationListPresenter implements ListLocationContract.Presenter, ListLocationInteractorImpl.OnLoadFinishedListener {

    ListLocationInteractorImpl interactor;
    ListLocationContract.View view;

    public LocationListPresenter(ListLocationContract.View v) {
        this.view = v;
        interactor = new ListLocationInteractorImpl(this);
    }

    @Override
    public void loadLocations(Book b) {
        interactor.loadLocations(b);
    }

    @Override
    public void removeLocation(Location location) {
        interactor.removeLocation(location);
    }

    @Override
    public void onSuccess(List<Location> list) {
        view.showLocations(list);
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
