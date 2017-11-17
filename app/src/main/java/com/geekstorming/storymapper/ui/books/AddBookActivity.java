package com.geekstorming.storymapper.ui.books;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.repos.BookRepository;

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
        Book newBook = new Book(3, tID_BookName.getText().toString(),
                tID_BookDesc.getText().toString(), tID_BookDesc.getText().toString(), 0);

        BookRepository.getInstance().addBook(newBook);
        Toast.makeText(this, "Añadiendo proyecto...", Toast.LENGTH_SHORT).show();
    }
}
