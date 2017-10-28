package com.geekstorming.storymapper;

import android.app.ListActivity;
import android.os.Bundle;

import com.geekstorming.storymapper.adapters.BooksAdapter;

/**
 * Books Adapter
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */
public class BooksActivity extends ListActivity {

    private BooksAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        adapter = new BooksAdapter(this);
        getListView().setAdapter(adapter);
    }
}
