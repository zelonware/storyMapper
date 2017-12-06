package com.geekstorming.storymapper.ui.books.fragments;

import android.app.Activity;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.adapters.BooksAdapter;
import com.geekstorming.storymapper.base.BasePresenter;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.ui.books.contracts.ListBookContract;

import java.util.List;

/**
 * Book list fragment, listing and selecting books for removal
 *  @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class BookList_Fragment extends ListFragment implements ListBookContract.View {

    public static final String TAG = "listBook";
    ListBookContract.Presenter presenter;
    private ListBookListener callback;

    BooksAdapter adapter;

    public static BookList_Fragment newInstance(Bundle args) {

        BookList_Fragment fragment = new BookList_Fragment();

        if (args != null) {
            fragment.setArguments(args);
        }

        return fragment;
    }

    public interface ListBookListener {
        void addNewBook();
        void editSelectedBook(int item);
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (ListBookContract.Presenter) presenter;
    }

    @Override
    public void showBooks(List<Book> bookList) {
        adapter.clear();
        adapter.addAll(bookList);
    }

    // Overriding ListFragment code

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapter = new BooksAdapter(getActivity());
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_books, container, false);

        FloatingActionButton fab_AddNewBook = (FloatingActionButton) rootView.findViewById(R.id.fab_Books);

        fab_AddNewBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.addNewBook();
            }
        });
        presenter.loadBooks();

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            callback = (ListBookListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must be implemented");
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setListAdapter(adapter);
        ListView listV_listBooks = (ListView) getListView().findViewById(android.R.id.list);
        listV_listBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                callback.editSelectedBook(position);
            }
        });

    }
}
