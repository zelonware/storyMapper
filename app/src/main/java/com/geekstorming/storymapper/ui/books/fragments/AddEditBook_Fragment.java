package com.geekstorming.storymapper.ui.books.fragments;

import com.geekstorming.storymapper.base.BaseFragment;
import com.geekstorming.storymapper.base.BasePresenter;
import com.geekstorming.storymapper.ui.books.contracts.AddEditBookContract;

/**
 * Add or edit books fragment, choose adding or editing an existing one
 *  @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class AddEditBook_Fragment extends BaseFragment implements AddEditBookContract.View {

    AddEditBookContract.Presenter presenter;

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddEditBookContract.Presenter) presenter;
    }


}
