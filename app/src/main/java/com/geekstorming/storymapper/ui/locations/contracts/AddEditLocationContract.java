package com.geekstorming.storymapper.ui.locations.contracts;

import com.geekstorming.storymapper.base.BasePresenter;
import com.geekstorming.storymapper.base.BaseView;
import com.geekstorming.storymapper.data.pojo.Location;

/**
 * Contract for adding or editing characters
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public interface AddEditLocationContract {

    interface Presenter extends BasePresenter
    {
        void editLocation(Location l);
        void addLocation(Location l);

        void validateLocationData(String name, String desc);
    }

    interface View extends BaseView {
        void onNameEmtpy();
        void onDescriptionEmpy();
        void doAddOrEdit();
    }
}
