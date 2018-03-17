package com.geekstorming.storymapper.ui;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.ui.characters.fragments.CharacterList_Fragment;
import com.geekstorming.storymapper.ui.characters.presenter.CharaterListPresenter;

public class BookManagerActivity extends AppCompatActivity {

    CharacterList_Fragment characterList_Frag;

    Book viewBook;

    CharaterListPresenter presenter;

    private BottomNavigationView bottomnv_bookManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_manager);

        viewBook = getIntent().getExtras().getParcelable(Book.TAG);
        bottomnv_bookManager = (BottomNavigationView) findViewById(R.id.bottomnv_bookManager);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        characterList_Frag = (CharacterList_Fragment) fragmentManager.findFragmentByTag(CharacterList_Fragment.TAG);

        if (characterList_Frag == null) {
            characterList_Frag = CharacterList_Fragment.newInstance(getIntent().getExtras());
            fragmentTransaction.add(R.id.flContent, characterList_Frag, CharacterList_Fragment.TAG);
            fragmentTransaction.commit();
        }

        presenter = new CharaterListPresenter(characterList_Frag);
        characterList_Frag.setPresenter(presenter);

        bottomnv_bookManager.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.action_seeChapters:
                        loadChaptersFragment();
                        break;
                    case R.id.action_seeCharacters:
                        loadCharactersFragment();
                        break;
                    case R.id.action_seeFactions:
                        loadFactionsFragment();
                        break;
                }

                return true;
            }
        });
    }

    private void loadCharactersFragment() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        characterList_Frag = (CharacterList_Fragment) fragmentManager.findFragmentByTag(CharacterList_Fragment.TAG);

        if (characterList_Frag == null) {
            characterList_Frag = CharacterList_Fragment.newInstance(getIntent().getExtras());
            fragmentTransaction.replace(R.id.flContent, characterList_Frag, CharacterList_Fragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        presenter = new CharaterListPresenter(characterList_Frag);
        characterList_Frag.setPresenter(presenter);
    }

    private void loadChaptersFragment() {


    }

    private void loadFactionsFragment() {

    }
}
