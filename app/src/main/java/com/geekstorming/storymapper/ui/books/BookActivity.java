package com.geekstorming.storymapper.ui.books;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.widget.TextView;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.base.BaseActivity;
import com.geekstorming.storymapper.data.pojo.User;
import com.geekstorming.storymapper.data.repos.UserRepository;
import com.geekstorming.storymapper.ui.books.fragments.AddEditBook_Fragment;
import com.geekstorming.storymapper.ui.books.fragments.BookList_Fragment;
import com.geekstorming.storymapper.ui.books.fragments.DetailBook_Fragment;
import com.geekstorming.storymapper.ui.books.presenter.ListBookPresenter;
import com.geekstorming.storymapper.utils.ModeAddEdit;

/**
 * Books Activity, book fragment manager
 *
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class BookActivity extends BaseActivity implements BookList_Fragment.ListBookListener, AddEditBook_Fragment.AddNewBookClickListener, DetailBook_Fragment.DetailBookClickListener, NavigationView.OnNavigationItemSelectedListener {

    BookList_Fragment bookList_Frag;
    AddEditBook_Fragment addEditBook_Frag;
    DetailBook_Fragment detailBook_Frag;

    ListBookPresenter bookListPresenter;

    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        user = UserRepository.getInstance().getUser(getIntent().getExtras().getString(User.TAG));
        setDataToNavigationDrawer(user);

        bookList_Frag = (BookList_Fragment) fragmentManager.findFragmentByTag(BookList_Fragment.TAG);

        if (bookList_Frag == null) {
            Bundle b = new Bundle();
            b.putParcelable(User.TAG, user);
            bookList_Frag = BookList_Fragment.newInstance(b);
            fragmentTransaction.add(R.id.flContent, bookList_Frag, BookList_Fragment.TAG);
            fragmentTransaction.commit();
        }

        bookListPresenter = new ListBookPresenter(bookList_Frag);

        bookList_Frag.setPresenter(bookListPresenter);

    }

    private void toAddEditBook(Bundle b, int mode) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        addEditBook_Frag = (AddEditBook_Fragment) fragmentManager.findFragmentByTag(AddEditBook_Fragment.TAG);

        if (addEditBook_Frag == null) {
            b.putParcelable(User.TAG, user);
            addEditBook_Frag = AddEditBook_Fragment.newInstance(b, mode);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.flContent, addEditBook_Frag, AddEditBook_Fragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void addNewBook(Bundle b) {
        toAddEditBook(b, ModeAddEdit.ADD_MODE);
    }

    // Showing selected book on DetailBook_Fragment
    @Override
    public void viewSelectedBook(Bundle b) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        detailBook_Frag = (DetailBook_Fragment) fragmentManager.findFragmentByTag(DetailBook_Fragment.TAG);

        if (detailBook_Frag == null) {
            detailBook_Frag = DetailBook_Fragment.newInstance(b);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.flContent, detailBook_Frag, DetailBook_Fragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    // Once edited or added, returning to the book list
    @Override
    public void returnToBookList() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
        fragmentManager.popBackStack();
    }

    @Override
    public void editSelectedBook(Bundle b) {
        toAddEditBook(b, ModeAddEdit.EDIT_MODE);
    }

    @Override
    public void setDataToNavigationDrawer(User user) {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        TextView txtV_Username = (TextView) navigationView.getHeaderView(0).findViewById(R.id.txtV_username);
        TextView txtV_Email = (TextView) navigationView.getHeaderView(0).findViewById(R.id.txtV_email);
        txtV_Username.setText(user.getUsername());
        txtV_Email.setText(user.getEmail());
    }

    @Override
    public void showBooks() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
