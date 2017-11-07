package com.geekstorming.storymapper;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.geekstorming.storymapper.adapters.FactionAdapter;
import com.geekstorming.storymapper.adapters.LocationAdapter;
import com.geekstorming.storymapper.pojo.Character;
import com.geekstorming.storymapper.repos.FactionRepository;
import com.geekstorming.storymapper.repos.LocationRepository;

/**
 * Editing an existing character
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */
public class EditCharacterActivity extends AppCompatActivity {

    private TextInputEditText tID_CharacterName;
    private TextInputEditText tID_CharacterDescription;
    private Spinner spn_CharacterFaction;
    private Spinner spn_CharacterHome;

    Character editableCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_character);

        // Load character from Bundle

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
        // Getting factions:
        // Adapter needed!
        spn_CharacterFaction.setAdapter(new FactionAdapter(this));

        // Getting locations:

        // Adapter needed!
        spn_CharacterHome.setAdapter(new LocationAdapter(this));
    }

    //endregion

    private void editCharacterToRepository() {
        if (tID_CharacterDescription.length() != 0 && tID_CharacterName.length() != 0 &&
                spn_CharacterFaction.getSelectedItemPosition() != -1 &&
                spn_CharacterHome.getSelectedItemPosition() != -1) {

            editableCharacter.setCharacterDesc(tID_CharacterDescription.getText().toString());
            editableCharacter.setCharacterName(tID_CharacterName.getText().toString());
            editableCharacter.setCharacterFaction(FactionRepository.getInstance().getFactions().get(spn_CharacterFaction.getSelectedItemPosition()).getFactionID());
            editableCharacter.setCharacterHome(LocationRepository.getInstance().getLocations().get(spn_CharacterHome.getSelectedItemPosition()).getLocationID());

            Toast.makeText(this, "Modificando personaje personaje...", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "¿Faltan datos de personajes?", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick_EditCharacter(View v) {
        switch (v.getId()) {
            case R.id.fab_CharacterCorrect:
                editCharacterToRepository();
                break;
            case R.id.btn_CharacterRelationShips:
                break;
        }
    }
}
