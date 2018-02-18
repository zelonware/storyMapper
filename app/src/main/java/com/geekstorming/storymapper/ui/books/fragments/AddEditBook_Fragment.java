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
import com.geekstorming.storymapper.utils.ModeAddEdit;

/**
 * Add or edit books fragment, choose adding or editing an existing one
 *
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class AddEditBook_Fragment extends BaseFragment implements AddEditBookContract.View {

    public final static String TAG = "addeditBook";
    AddEditBookContract.Presenter presenter;

    AddNewBookClickListener callback;

    // Widgets for creating/editing new books:
    private TextInputEditText tID_bookName;
    private TextInputEditText tId_bookDesc;
    private TextInputEditText tID_nWords;
    private Spinner spn_bookGenre;
    private FloatingActionButton fab_AddEditBook;

    static ModeAddEdit mode;

    private static Book editableBook;

    public static AddEditBook_Fragment newInstance(Bundle args) {
        AddEditBook_Fragment addEditBook_fragment = new AddEditBook_Fragment();
        mode = new ModeAddEdit(ModeAddEdit.ADD_MODE);

        if (args != null) {
            // Loading existing book for edits
            addEditBook_fragment.setArguments(args);
            mode.setMode(ModeAddEdit.EDIT_MODE);
            editableBook = (Book) args.getParcelable(Book.TAG);
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
        View viewRoot = inflater.inflate(R.layout.fragment_book_add, container, false);

        this.presenter = new AddEditBookPresenter(this);

        tId_bookDesc = (TextInputEditText) viewRoot.findViewById(R.id.tID_BookDesc);
        tID_bookName = (TextInputEditText) viewRoot.findViewById(R.id.tID_BookName);
        tID_nWords = (TextInputEditText) viewRoot.findViewById(R.id.tID_nWords);
        spn_bookGenre = (Spinner) viewRoot.findViewById(R.id.edT_Genre);

        fab_AddEditBook = (FloatingActionButton) viewRoot.findViewById(R.id.fab_BookDone);
        fab_AddEditBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addOrEditBook();
            }
        });

        return viewRoot;
    }

    private void addOrEditBook()
    {
        if (mode.getMode() == ModeAddEdit.EDIT_MODE)
        {
            presenter.updateBook(new Book(editableBook.getBookID(),
                    tID_bookName.getText().toString(), tId_bookDesc.getText().toString(),
                    spn_bookGenre.getSelectedItem().toString(), Integer.parseInt(tID_nWords.getText().toString())));
        }
        if (mode.getMode() == ModeAddEdit.ADD_MODE)
        {
            presenter.addNewBook(new Book(5,
                    tID_bookName.getText().toString(), tId_bookDesc.getText().toString(),
                    spn_bookGenre.getSelectedItem().toString(), Integer.parseInt(tID_nWords.getText().toString())));
        }

        callback.returnToBookList();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (mode.getMode() == ModeAddEdit.EDIT_MODE)
        {
            tID_bookName.setText(editableBook.getBookTitle());
            tId_bookDesc.setText(editableBook.getBookDesc());
            tID_nWords.setText(Integer.toString(editableBook.getnWords()));
        }
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
