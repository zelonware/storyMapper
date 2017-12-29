package com.geekstorming.storymapper.ui.books.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.base.BaseFragment;
import com.geekstorming.storymapper.data.pojo.Book;

public class DetailBook_Fragment extends BaseFragment {

    public static final String TAG = "detailBook";

    EditText edT_bookTitle;
    EditText edT_bookDesc;
    EditText edT_bookGenre;
    EditText edT_bookNWords;

    FloatingActionButton fab_editSelectedBook;

    DetailBookClickListener callback;

    private static Book viewBook;

    public static DetailBook_Fragment newInstance(Bundle args) {
        DetailBook_Fragment detailBook_fragment = new DetailBook_Fragment();

        if (args != null) {
            detailBook_fragment.setArguments(args);
            viewBook = (Book) args.getParcelable(Book.TAG);
        }

        return detailBook_fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View viewRoot = inflater.inflate(R.layout.fragment_detail_book, container, false);

        edT_bookTitle = (EditText) viewRoot.findViewById(R.id.tID_BookName);
        edT_bookDesc = (EditText) viewRoot.findViewById(R.id.tID_BookDesc);
        edT_bookGenre = (EditText) viewRoot.findViewById(R.id.edT_Genre);
        edT_bookNWords = (EditText) viewRoot.findViewById(R.id.tID_nWords);

        fab_editSelectedBook = (FloatingActionButton) viewRoot.findViewById(R.id.fab_editSelectedBook);
        fab_editSelectedBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.editSelectedBook(getArguments());
            }
        });

        return viewRoot;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            callback = (DetailBook_Fragment.DetailBookClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must be implemented");
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edT_bookTitle.setText(viewBook.getBookTitle());
        edT_bookDesc.setText(viewBook.getBookDesc());
        edT_bookGenre.setText(viewBook.getBookGenre());
        edT_bookNWords.setText(Integer.toString(viewBook.getnWords()));

    }

    public interface DetailBookClickListener {
        void editSelectedBook(Bundle b);
    }
}
