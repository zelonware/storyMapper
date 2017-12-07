package com.geekstorming.storymapper.ui.books.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.base.BaseFragment;
import com.geekstorming.storymapper.base.BasePresenter;
import com.geekstorming.storymapper.ui.books.contracts.AddEditBookContract;
import com.geekstorming.storymapper.ui.books.presenter.AddEditBookPresenter;

/**
 * Add or edit books fragment, choose adding or editing an existing one
 *
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class AddEditBook_Fragment extends BaseFragment implements AddEditBookContract.View {

    public final static String TAG = "addeditBook";
    AddEditBookContract.Presenter presenter;

    public static AddEditBook_Fragment newInstance(Bundle args) {
        AddEditBook_Fragment addEditBook_fragment = new AddEditBook_Fragment();

        if (args != null) {
            // Loading existing book for edits
            addEditBook_fragment.setArguments(args);
            // ...
        }

        return addEditBook_fragment;

    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddEditBookContract.Presenter) presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.activity_add_book, container, false);

        this.presenter = new AddEditBookPresenter(this);

        return viewRoot;
    }
}
