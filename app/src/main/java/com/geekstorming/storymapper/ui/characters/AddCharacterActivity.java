package com.geekstorming.storymapper.ui.characters;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.adapters.FactionAdapter;
import com.geekstorming.storymapper.adapters.LocationAdapter;
import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.data.repos.CharacterRepository;

/**
 * Adding new character
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */
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
        tID_CharacterName = (TextInputEditText) findViewById(R.id.tiD_CharacterName);
        tID_CharacterDescription = (TextInputEditText) findViewById(R.id.tID_CharacterDescription);
        spn_CharacterFaction = (Spinner) findViewById(R.id.spn_CharacterFaction);
        spn_CharacterHome = (Spinner) findViewById(R.id.spn_CharactersHome);

        initializeSpinners();
    }

    private void initializeSpinners()
    {
        // Getting factions:
        // Adapter needed!
        spn_CharacterFaction.setAdapter(new FactionAdapter(this));

        // Getting locations:

        // Adapter needed!
        spn_CharacterHome.setAdapter(new LocationAdapter(this));
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

            CharacterRepository.getInstance().addCharacter(new Character(1,  tID_CharacterName.getText().toString(),
                   tID_CharacterDescription.getText().toString(), spn_CharacterFaction.getSelectedItemPosition(),
                    spn_CharacterFaction.getSelectedItemPosition()
                    /*
                    FactionRepository.getInstance().getFactions().get(spn_CharacterFaction.getSelectedItemPosition()).getFactionID(),
                    LocationRepository.getInstance().getLocations().get(spn_CharacterHome.getSelectedItemPosition()).getLocationID())
                    */));

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
