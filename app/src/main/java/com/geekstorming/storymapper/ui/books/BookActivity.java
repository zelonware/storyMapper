package com.geekstorming.storymapper.ui.books;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.geekstorming.storymapper.AboutActivity;
import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.base.BaseActivity;
import com.geekstorming.storymapper.ui.books.fragments.AddEditBook_Fragment;
import com.geekstorming.storymapper.ui.books.fragments.BookList_Fragment;
import com.geekstorming.storymapper.ui.books.fragments.DetailBook_Fragment;
import com.geekstorming.storymapper.ui.books.presenter.ListBookPresenter;
import com.geekstorming.storymapper.ui.settings.SettingsActivity;

/**
 * Books Activity, book fragment manager
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class BookActivity extends BaseActivity implements BookList_Fragment.ListBookListener, AddEditBook_Fragment.AddNewBookClickListener, DetailBook_Fragment.DetailBookClickListener {

    BookList_Fragment bookList_Frag;
    AddEditBook_Fragment addEditBook_Frag;
    DetailBook_Fragment detailBook_Frag;

    ListBookPresenter bookListPresenter;

    private DrawerLayout drawL_base;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        bookList_Frag = (BookList_Fragment) fragmentManager.findFragmentByTag(BookList_Fragment.TAG);

        if (bookList_Frag == null)
        {
            bookList_Frag = BookList_Fragment.newInstance(null);
            fragmentTransaction.add(R.id.flContent, bookList_Frag, BookList_Fragment.TAG);
            fragmentTransaction.commit();
        }

        bookListPresenter = new ListBookPresenter(bookList_Frag);

        bookList_Frag.setPresenter(bookListPresenter);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Mostrando botón de home
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Encontrando drawer, se abre como START
        drawL_base = (DrawerLayout) findViewById(R.id.drawL_base);

        navigationView = (NavigationView) findViewById(R.id.navigationView);
        setupNavigationView();
    }

    private void toAddEditBook(Bundle b)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();

        addEditBook_Frag = (AddEditBook_Fragment) fragmentManager.findFragmentByTag(AddEditBook_Fragment.TAG);

        if (addEditBook_Frag == null)
        {
            addEditBook_Frag = AddEditBook_Fragment.newInstance(b);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.flContent, addEditBook_Frag, AddEditBook_Fragment.TAG);
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
        toAddEditBook(b);
    }

    private void setupNavigationView() {
        Toast.makeText(this, "holi", Toast.LENGTH_SHORT).show();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.action_books:
                        lanzarBooks();
                        break;
                    case R.id.action_help:
                        //lanzarHelp();
                        break;
                    case R.id.action_settings:
                        lanzarSettings();
                        break;
                    case R.id.action_about:
                        lanzarAbout();
                        break;
                }
                // Mantenemos opción seleccionada y cambiamos title de toolbar
                item.setChecked(true);
                getSupportActionBar().setTitle(item.getTitle());

                // Cualquier opción seleccionada provoca el cierre del Drawer
                drawL_base.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                //Toast.makeText(this, "Se ha pulsado HOME", Toast.LENGTH_SHORT).show();
                drawL_base.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        // Si drawL_base es visible, cerramos. Si no, ejecutamos el código suppah
        if (drawL_base.isDrawerOpen(GravityCompat.START))
            drawL_base.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    private void lanzarSettings() {
        startActivity(new Intent(BookActivity.this, SettingsActivity.class));
    }

    private void lanzarBooks() {
        startActivity(new Intent(BookActivity.this, BookActivity.class));
    }

    private void lanzarAbout() {
        startActivity(new Intent(BookActivity.this, AboutActivity.class));
    }
}
