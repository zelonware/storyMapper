package com.geekstorming.storymapper.ui.locations.contracts;

import com.geekstorming.storymapper.base.BasePresenter;
import com.geekstorming.storymapper.base.BaseView;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Location;

import java.util.List;

public interface ListLocationContract {

    interface View extends BaseView {

        void showLocations(List<Location> locationList);

        void onDatabaseError(Error error);
        void onDatabaseError(Exception exception);
        void showProgressDialog(String message);
        void dismissProgressDialog();
    }

    interface Presenter extends BasePresenter {
        void loadLocations(Book b);
        void removeLocation(Location location);
    }
}
