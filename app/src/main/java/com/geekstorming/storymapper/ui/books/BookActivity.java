package com.geekstorming.storymapper.ui.books;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.base.BaseActivity;
import com.geekstorming.storymapper.ui.books.fragments.AddEditBook_Fragment;
import com.geekstorming.storymapper.ui.books.fragments.BookList_Fragment;
import com.geekstorming.storymapper.ui.books.fragments.DetailBook_Fragment;
import com.geekstorming.storymapper.ui.books.presenter.ListBookPresenter;

/**
 * Books Activity, book fragment manager
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class BookActivity extends BaseActivity implements BookList_Fragment.ListBookListener, AddEditBook_Fragment.AddNewBookClickListener, DetailBook_Fragment.DetailBookClickListener {

    BookList_Fragment bookList_Frag;
    AddEditBook_Fragment addEditBook_Frag;
    DetailBook_Fragment detailBook_Frag;

    ListBookPresenter bookListPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragmentcontainer_book_activity);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        bookList_Frag = (BookList_Fragment) fragmentManager.findFragmentByTag(BookList_Fragment.TAG);

        if (bookList_Frag == null)
        {
            bookList_Frag = BookList_Fragment.newInstance(null);
            fragmentTransaction.add(android.R.id.content, bookList_Frag, BookList_Fragment.TAG);
            fragmentTransaction.commit();
        }

        bookListPresenter = new ListBookPresenter(bookList_Frag);

        bookList_Frag.setPresenter(bookListPresenter);
    }


    private void toAddEditBook(Bundle b)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();

        addEditBook_Frag = (AddEditBook_Fragment) fragmentManager.findFragmentByTag(AddEditBook_Fragment.TAG);

        if (addEditBook_Frag == null)
        {
            addEditBook_Frag = AddEditBook_Fragment.newInstance(b);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(android.R.id.content, addEditBook_Frag, AddEditBook_Fragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void addNewBook(Bundle b) {
        toAddEditBook(b);
    }

    // Showing selected book on DetailBook_Fragment
    @Override
    public void viewSelectedBook(Bundle b) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        detailBook_Frag = (DetailBook_Fragment) fragmentManager.findFragmentByTag(DetailBook_Fragment.TAG);

        if (detailBook_Frag == null)
        {
            detailBook_Frag = DetailBook_Fragment.newInstance(b);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(android.R.id.content, detailBook_Frag, DetailBook_Fragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    // Once edited or added, returning to the book list
    @Override
    public void returnToBookList() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
    }

    @Override
    public void editSelectedBook(Bundle b) {
        toAddEditBook(b);
    }
}
