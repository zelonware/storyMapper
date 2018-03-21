package com.geekstorming.storymapper.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.base.BaseActivity;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.ui.characters.fragments.AddEditCharacter_Fragment;
import com.geekstorming.storymapper.ui.characters.fragments.CharacterList_Fragment;
import com.geekstorming.storymapper.ui.characters.fragments.ViewCharacter_Fragment;
import com.geekstorming.storymapper.ui.characters.presenter.CharaterListPresenter;

public class BookManagerActivity extends BaseActivity implements AddEditCharacter_Fragment.AddNewCharacterClickListener, CharacterList_Fragment.ListCharacterListener, ViewCharacter_Fragment.ViewCharacterClickListener {

    CharacterList_Fragment characterList_Frag;
    AddEditCharacter_Fragment addEditCharacter_Frag;
    ViewCharacter_Fragment viewCharacter_Frag;

    Book viewBook;

    Character selectedCharacter;

    CharaterListPresenter presenter;

    private BottomNavigationView bottomnv_bookManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_manager);

        initViews();

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

    // CharacterFragments implementation

    @Override
    public void returnToList() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
        fragmentManager.popBackStack();
    }

    @Override
    public void addNewCharacter(Bundle b, int mode) {
        toAddEditCharacter(b, mode);
    }

    @Override
    public void viewSelectedCharacter(Bundle b) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        viewCharacter_Frag = (ViewCharacter_Fragment) fragmentManager.findFragmentByTag(ViewCharacter_Fragment.TAG);

        if (viewCharacter_Frag == null) {
            viewCharacter_Frag = ViewCharacter_Fragment.newInstance(b);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.flContent, viewCharacter_Frag, ViewCharacter_Fragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    private void toAddEditCharacter(Bundle b, int mode) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        addEditCharacter_Frag = (AddEditCharacter_Fragment) fragmentManager.findFragmentByTag(AddEditCharacter_Fragment.TAG);

        if (addEditCharacter_Frag == null) {
            b.putParcelable(Book.TAG, viewBook);
            b.putParcelable(Character.TAG, selectedCharacter);
            addEditCharacter_Frag = AddEditCharacter_Fragment.newInstance(b, mode);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.flContent, addEditCharacter_Frag, AddEditCharacter_Fragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void editCharacter(Bundle b, int mode) {
        toAddEditCharacter(b, mode);
    }


}
