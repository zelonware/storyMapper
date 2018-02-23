package com.geekstorming.storymapper.ui.characters;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.adapters.CharacterAdapter;
import com.geekstorming.storymapper.base.BaseActivity;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.ui.books.fragments.BookList_Fragment;
import com.geekstorming.storymapper.ui.books.presenter.ListBookPresenter;
import com.geekstorming.storymapper.ui.characters.fragments.AddEditCharacter_Fragment;
import com.geekstorming.storymapper.ui.characters.fragments.CharacterList_Fragment;
import com.geekstorming.storymapper.ui.characters.fragments.ViewCharacter_Fragment;

/**
 * Character Activity, fragment container
 *
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */
public class CharactersActivity extends BaseActivity implements AddEditCharacter_Fragment.AddNewCharacterClickListener, CharacterList_Fragment.ListCharacterListener {

    CharacterList_Fragment characterList_Frag;
    AddEditCharacter_Fragment addEditCharacter_Frag;
    ViewCharacter_Fragment viewCharacter_Frag;

    Book viewBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBook = getIntent().getExtras().getParcelable(Book.TAG);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        characterList_Frag = (CharacterList_Fragment) fragmentManager.findFragmentByTag(CharacterList_Fragment.TAG);

        if (characterList_Frag == null) {
            characterList_Frag = CharacterList_Fragment.newInstance(getIntent().getExtras());
            fragmentTransaction.add(R.id.flContent, characterList_Frag, CharacterList_Fragment.TAG);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void returnToList() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
        fragmentManager.popBackStack();
    }

    @Override
    public void addNewCharacter(Bundle b) {
        toAddEditCharacter(b);
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

    private void toAddEditCharacter(Bundle b) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        addEditCharacter_Frag = (AddEditCharacter_Fragment) fragmentManager.findFragmentByTag(AddEditCharacter_Fragment.TAG);

        if (addEditCharacter_Frag == null) {
            addEditCharacter_Frag = AddEditCharacter_Fragment.newInstance(b);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.flContent, addEditCharacter_Frag, AddEditCharacter_Fragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
