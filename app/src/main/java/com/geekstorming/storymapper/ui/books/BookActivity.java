package com.geekstorming.storymapper.ui.books;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.base.BaseActivity;
import com.geekstorming.storymapper.ui.books.fragments.BookList_Fragment;
import com.geekstorming.storymapper.ui.books.presenter.ListBookPresenter;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Beelzenef on 27/11/2017.
 */

public class BookActivity extends BaseActivity implements BookList_Fragment.ListBookListener {

    BookList_Fragment bookList;
    ListBookPresenter bookListPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.book_activity);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        bookList = (BookList_Fragment) fragmentManager.findFragmentByTag(BookList_Fragment.TAG);

        if (bookList == null)
        {
            bookList = BookList_Fragment.newInstance(null);
            fragmentTransaction.add(android.R.id.content, bookList, BookList_Fragment.TAG);
            fragmentTransaction.commit();
        }

        bookListPresenter = new ListBookPresenter(bookList);

        bookList.setPresenter(bookListPresenter);
    }

    @Override
    public void addNewBook() {

    }

    @Override
    public void editSelectedBook(int item) {

    }
}
