package com.geekstorming.storymapper;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.geekstorming.storymapper.pojo.Book;
import com.geekstorming.storymapper.repos.BookRepository;

public class AddBookActivity extends AppCompatActivity {

    TextInputEditText tID_BookName;
    TextInputEditText tID_BookDesc;
    TextInputEditText tID_nWords;
    Spinner spn_Genre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        initializeViews();
    }

    private void initializeViews()
    {
        tID_nWords = (TextInputEditText) findViewById(R.id.tID_nWords);
        tID_BookDesc = (TextInputEditText) findViewById(R.id.tID_BookDesc);
        tID_BookName = (TextInputEditText) findViewById(R.id.tID_BookName);
        spn_Genre = (Spinner) findViewById(R.id.spn_Genre);
    }

    public void onClick_addBook(View v)
    {
        BookRepository.getInstance().addBook(new Book(3, "Nuevo libro", "Nuevo género", 3000));
        Toast.makeText(this, "Añadiendo proyecto...", Toast.LENGTH_SHORT).show();
    }
}
