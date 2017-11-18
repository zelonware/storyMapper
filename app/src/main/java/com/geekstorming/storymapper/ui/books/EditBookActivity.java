package com.geekstorming.storymapper.ui.books;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.repos.BookRepository;
import com.geekstorming.storymapper.ui.characters.CharactersActivity;

public class EditBookActivity extends AppCompatActivity {

    TextInputEditText tID_BookName;
    TextInputEditText tID_BookDesc;
    TextInputEditText tID_nWords;
    Spinner spn_Genre;

    Book editableBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_book);

        initializeViews();

        editableBook = (Book) getIntent().getExtras().getParcelable("editableBook");

        loadEditableBook();
    }

    private void initializeViews() {
        tID_nWords = (TextInputEditText) findViewById(R.id.tID_nWords);
        tID_BookDesc = (TextInputEditText) findViewById(R.id.tID_BookDesc);
        tID_BookName = (TextInputEditText) findViewById(R.id.tID_BookName);
        spn_Genre = (Spinner) findViewById(R.id.spn_Genre);
    }

    private void loadEditableBook() {
        tID_BookName.setText(editableBook.getBookTitle());
        tID_BookDesc.setText(editableBook.getBookDesc());
    }

    public void onClick_editBook(View v) {
        switch (v.getId()) {
            case R.id.btn_SeeCharacters:
                startActivity(new Intent(EditBookActivity.this, CharactersActivity.class));
                break;
            case R.id.fab_BookEdited:
                editableBook = new Book(3, tID_BookName.getText().toString(),
                        tID_BookDesc.getText().toString(), tID_BookDesc.getText().toString(), 0);
                Toast.makeText(this, "Editando proyecto...", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}