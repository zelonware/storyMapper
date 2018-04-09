package com.geekstorming.storymapper.ui.locations.interactor;

import android.os.AsyncTask;

import com.geekstorming.storymapper.data.db.InteractorCallback;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Location;
import com.geekstorming.storymapper.data.repos.LocationRepository;

import java.util.List;

public class ListLocationInteractorImpl implements ListLocationInteractor, InteractorCallback {

    private Book viewBook;

    ListLocationInteractorImpl.OnLoadFinishedListener listener;

    public ListLocationInteractorImpl(ListLocationInteractorImpl.OnLoadFinishedListener listener)
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
        loadLocations(viewBook);
    }

    @Override
    public void loadLocations(final Book book) {
        new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                viewBook = book;
                listener.onSuccess(LocationRepository.getInstance().getLocations(viewBook));
                return null;
            }
        }.execute();
    }

    @Override
    public void removeLocation(Location location) {
        LocationRepository.getInstance().removeLocation(location);
        loadLocations(viewBook);
    }

    public interface OnLoadFinishedListener {
        void onSuccess(List<Location> list);

        void onDatabaseError(Error error);

        void onDatabaseError(Exception exception);
    }
}
