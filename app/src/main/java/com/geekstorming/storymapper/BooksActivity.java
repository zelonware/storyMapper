package com.geekstorming.storymapper;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.geekstorming.storymapper.adapters.BooksAdapter;
import com.geekstorming.storymapper.settings.SettingsActivity;

/**
 * Books Activity
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_projects, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(BooksActivity.this, SettingsActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
