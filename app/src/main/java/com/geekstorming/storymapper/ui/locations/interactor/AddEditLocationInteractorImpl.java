package com.geekstorming.storymapper.ui.locations.interactor;

import android.text.TextUtils;

import com.geekstorming.storymapper.data.pojo.Location;
import com.geekstorming.storymapper.data.repos.LocationRepository;

/**
 * Interactor implementation for adding or editing locations
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class AddEditLocationInteractorImpl implements AddEditLocationInteractor {

    AddLocationListener listener;

    public AddEditLocationInteractorImpl(AddLocationListener listener) {
        this.listener = listener;
    }

    @Override
    public void editLocation(Location c) { LocationRepository.getInstance().editLocation(c); }

    @Override
    public void addLocation(Location c) {
        LocationRepository.getInstance().addLocation(c);
    }

    @Override
    public void isValidData(String name, String desc) {
        if (TextUtils.isEmpty(name)) {
            listener.nameIsEmpty();
        }
        else if (TextUtils.isEmpty(desc)) {
            listener.descIsEmpty();
        }
        else {
            listener.onDataValid();
        }
    }

    public interface AddLocationListener {
        void nameIsEmpty();
        void descIsEmpty();
        void onDataValid();
    }
}
