package com.geekstorming.storymapper.ui.locations.presenter;

import com.geekstorming.storymapper.data.pojo.Location;
import com.geekstorming.storymapper.ui.locations.contracts.AddEditLocationContract;
import com.geekstorming.storymapper.ui.locations.interactor.AddEditLocationInteractorImpl;

/**
 * Presenter for adding or editing locations
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class AddEditLocationPresenter implements AddEditLocationContract.Presenter, AddEditLocationInteractorImpl.AddLocationListener {

    AddEditLocationInteractorImpl interactor;
    AddEditLocationContract.View view;

    public AddEditLocationPresenter(AddEditLocationContract.View view)
    {
        this.view = view;
        this.interactor = new AddEditLocationInteractorImpl(this);
    }

    @Override
    public void editLocation(Location l) {
        interactor.editLocation(l);
    }

    public void addLocation(Location l) {
        interactor.addLocation(l);
    }

    @Override
    public void validateLocationData(String name, String desc) {
        interactor.isValidData(name, desc);
    }

    @Override
    public void nameIsEmpty() {
        view.onNameEmtpy();
    }

    @Override
    public void descIsEmpty() {
        view.onDescriptionEmpy();
    }

    @Override
    public void onDataValid() {
        view.doAddOrEdit();
    }
}
