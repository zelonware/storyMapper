package com.geekstorming.storymapper;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.geekstorming.storymapper.repos.CharacterRepository;

public class AddCharacterActivity extends AppCompatActivity {

    private TextInputEditText tID_CharacterName;
    private TextInputEditText tID_CharacterDescription;
    private Spinner spn_CharacterFaction;
    private Spinner spn_CharacterHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_character);

        initializeViews();

    }

    //region Activity setup

    private void initializeViews()
    {
        tID_CharacterName = (TextInputEditText) findViewById(R.id.tID_CharacterName);
        tID_CharacterDescription = (TextInputEditText) findViewById(R.id.tID_CharacterDescription);
        spn_CharacterFaction = (Spinner) findViewById(R.id.spn_CharacterFaction);
        spn_CharacterHome = (Spinner) findViewById(R.id.spn_CharactersHome);

        initializeSpinners();
    }

    private void initializeSpinners()
    {

    }

    //endregion

    //region Adding character to repository

    private void addCharacterToRepository()
    {
        if (tID_CharacterDescription.length() != 0 && tID_CharacterName.length() != 0 &&
                spn_CharacterFaction.getSelectedItemPosition() != -1 &&
                spn_CharacterHome.getSelectedItemPosition() != -1)
        {
            // Adding character to repository
            /*
            new Character(1, tID_CharacterName.getText().toString(), tID_CharacterDescription.getText().toString(),
                FactionRepository.getInstance().getFactions().get(spn_CharacterFaction.getSelectedItemPosition())
                 LocationRepository.getInstance().getLocations().get(spn_CharacterHome.getSelectedItemPosition())
                 );
            */
            Toast.makeText(this, "Añadiendo personaje...", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "¿Faltan datos de personajes?", Toast.LENGTH_SHORT).show();
        }
    }

    //endregion

    public void onClick_AddCharacter(View v)
    {
        switch (v.getId())
        {
            case R.id.fab_CharacterDone:
                addCharacterToRepository();
                break;
            case R.id.btn_CharacterRelationShips:
                break;
        }
    }
}
