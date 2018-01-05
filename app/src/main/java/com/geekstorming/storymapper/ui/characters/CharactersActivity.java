package com.geekstorming.storymapper.ui.characters;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.adapters.CharacterAdapter;
import com.geekstorming.storymapper.data.pojo.Character;

/**
 * Character Activity
 *
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */
public class CharactersActivity extends AppCompatActivity {

    private FloatingActionButton fab_addCharacter;
    private Toolbar toolBar_Characters;
    private RecyclerView recyclerV_Characters;

    private CharacterAdapter characterAdapter;

    private CharacterAdapter.OnItemClickListener onItemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);

        // Getting Views
        fab_addCharacter = (FloatingActionButton) findViewById(R.id.fab_Characters);
        toolBar_Characters = (Toolbar) findViewById(R.id.toolbar_Characters);

        // Setting recyclerView
        recyclerV_Characters = (RecyclerView) findViewById(R.id.recyclerCharacters);
        recyclerV_Characters.setHasFixedSize(true);
        recyclerV_Characters.setLayoutManager(new LinearLayoutManager(this));

        // Getting adapter
        characterAdapter = new CharacterAdapter(onItemClickListener);

        // Setting adapter
        recyclerV_Characters.setAdapter(characterAdapter);

        // Setting toolbar
        setSupportActionBar(toolBar_Characters);

        // Lets create new character!
        fab_addCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CharactersActivity.this, AddCharacterActivity.class));
            }
        });

        // Clicking on an existing character:
        onItemClickListener = new CharacterAdapter.OnItemClickListener() {
            @Override
            public void onCharacterClick(Character c) {
               Bundle b = new Bundle();
               b.putParcelable(Character.TAG, c);
               startActivity(new Intent(CharactersActivity.this, EditCharacterActivity.class)
                       .putExtra("Bundle", b));
            }
        };

    }

    @Override
    protected void onResume() {
        super.onResume();

        // Getting adapter
        characterAdapter = new CharacterAdapter(onItemClickListener);

        // Setting adapter
        recyclerV_Characters.setAdapter(characterAdapter);
    }
}
