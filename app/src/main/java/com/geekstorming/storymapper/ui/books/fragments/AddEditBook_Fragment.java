package com.geekstorming.storymapper.ui.books.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.base.BaseFragment;
import com.geekstorming.storymapper.base.BasePresenter;
import com.geekstorming.storymapper.data.pojo.Book;
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

    AddNewBookClickListener callback;

    // Widgets for creating new books:
    TextInputEditText tID_bookName;
    TextInputEditText tId_bookDesc;
    TextInputEditText tID_nWords;
    Spinner spn_bookGenre;
    FloatingActionButton fab_AddEditBook;

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
        View viewRoot = inflater.inflate(R.layout.fragment_add_book, container, false);

        this.presenter = new AddEditBookPresenter(this);

        tId_bookDesc = (TextInputEditText) viewRoot.findViewById(R.id.tID_BookDesc);
        tID_bookName = (TextInputEditText) viewRoot.findViewById(R.id.tID_BookName);
        tID_nWords = (TextInputEditText) viewRoot.findViewById(R.id.tID_nWords);
        spn_bookGenre = (Spinner) viewRoot.findViewById(R.id.edT_Genre);

        fab_AddEditBook = (FloatingActionButton) viewRoot.findViewById(R.id.fab_BookDone);
        fab_AddEditBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.addNewBook(new Book(0,
                        tID_bookName.getText().toString(), tId_bookDesc.getText().toString(),
                        "Sin genero", Integer.parseInt(tID_nWords.getText().toString())));

                callback.returnToBookList();
            }
        });

        return viewRoot;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (AddNewBookClickListener) activity;
        } catch (ClassCastException e)
        {
            throw new ClassCastException(getActivity().getLocalClassName() + "must be implemented");
        }
    }

    public interface AddNewBookClickListener
    {
        void returnToBookList();
    }
}
