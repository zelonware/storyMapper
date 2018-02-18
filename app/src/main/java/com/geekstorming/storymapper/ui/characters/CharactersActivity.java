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
import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.ui.books.fragments.BookList_Fragment;
import com.geekstorming.storymapper.ui.books.presenter.ListBookPresenter;
import com.geekstorming.storymapper.ui.characters.fragments.AddEditCharacter_Fragment;
import com.geekstorming.storymapper.ui.characters.fragments.CharacterList_Fragment;

/**
 * Character Activity, fragment container
 *
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */
public class CharactersActivity extends BaseActivity {

    CharacterList_Fragment characterList_Frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        characterList_Frag = (CharacterList_Fragment) fragmentManager.findFragmentByTag(CharacterList_Fragment.TAG);

        if (characterList_Frag == null) {
            characterList_Frag = CharacterList_Fragment.newInstance(null);
            fragmentTransaction.add(R.id.flContent, characterList_Frag, CharacterList_Fragment.TAG);
            fragmentTransaction.commit();
        }

        //characterList_Frag = new ListBookPresenter(characterList_Frag);

        //characterList_Frag.setPresenter(bookListPresenter);

    }
}
