package com.geekstorming.storymapper;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.geekstorming.storymapper.adapters.CharacterAdapter;
import com.geekstorming.storymapper.pojo.Character;

/**
 * Character Activity
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */
public class CharactersActivity extends AppCompatActivity {

    private FloatingActionButton fab_addCharacter;
    private Toolbar toolBar_Characters;
    private RecyclerView recyclerV_Characters;

    private CharacterAdapter characterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);

        // Getting Views
        fab_addCharacter = (FloatingActionButton) findViewById( R.id.fab_Characters );
        toolBar_Characters = (Toolbar) findViewById(R.id.toolbar_Characters);

        // Setting recyclerView
        recyclerV_Characters = (RecyclerView) findViewById(R.id.recyclerCharacters);
        recyclerV_Characters.setHasFixedSize(true);
        recyclerV_Characters.setLayoutManager(new LinearLayoutManager(this));

        // Getting adapter
        characterAdapter = new CharacterAdapter();

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




    }
}
