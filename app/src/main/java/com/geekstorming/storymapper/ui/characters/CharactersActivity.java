package com.geekstorming.storymapper.ui.characters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.base.BaseActivity;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.ui.books.BookActivity;
import com.geekstorming.storymapper.ui.characters.fragments.AddEditCharacter_Fragment;
import com.geekstorming.storymapper.ui.characters.fragments.CharacterList_Fragment;
import com.geekstorming.storymapper.ui.characters.fragments.ViewCharacter_Fragment;
import com.geekstorming.storymapper.ui.characters.presenter.CharaterListPresenter;

/**
 * Character Activity, fragment container
 *
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */
public class CharactersActivity extends BaseActivity implements AddEditCharacter_Fragment.AddNewCharacterClickListener, CharacterList_Fragment.ListCharacterListener, ViewCharacter_Fragment.ViewCharacterClickListener {

    AddEditCharacter_Fragment addEditCharacter_Frag;
    ViewCharacter_Fragment viewCharacter_Frag;

    Character selectedCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fragmentManager = getSupportFragmentManager();

        viewCharacter_Frag = (ViewCharacter_Fragment) fragmentManager.findFragmentByTag(ViewCharacter_Fragment.TAG);

        if (viewCharacter_Frag == null) {
            viewCharacter_Frag = ViewCharacter_Fragment.newInstance(getIntent().getExtras());
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.flContent, viewCharacter_Frag, ViewCharacter_Fragment.TAG);
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
            b.putParcelable(Book.TAG, selectedCharacter);
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

    @Override
    public void showBooks() {
        Intent intent = new Intent(CharactersActivity.this, BookActivity.class);
        finish();
        startActivity(intent);
    }
}
