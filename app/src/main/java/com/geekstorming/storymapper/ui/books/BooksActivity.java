package com.geekstorming.storymapper.ui.books;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.adapters.BooksAdapter;
import com.geekstorming.storymapper.data.repos.BookRepository;
import com.geekstorming.storymapper.ui.settings.SettingsActivity;

/**
 * Books Activity
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */
public class BooksActivity extends AppCompatActivity {

    private BooksAdapter adapter;
    Toolbar toolBar_Projects;
    FloatingActionButton fab_AddBook;
    ListView bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        fab_AddBook = (FloatingActionButton) findViewById(R.id.fab_Books);
        toolBar_Projects = (Toolbar) findViewById(R.id.toolbar_Books);

        // Setting listView
        bookList = (ListView) findViewById(android.R.id.list);
        bookList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BooksActivity.this, EditBookActivity.class);

                intent.putExtra("editableBook", BookRepository.getInstance().getBooks().get(position));
                startActivity(intent);
            }
        });

        fab_AddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BooksActivity.this, AddBookActivity.class));
            }
        });

        setSupportActionBar(toolBar_Projects);
        adapter = new BooksAdapter(this);
        bookList.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter = new BooksAdapter(this);
        bookList.setAdapter(adapter);
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
