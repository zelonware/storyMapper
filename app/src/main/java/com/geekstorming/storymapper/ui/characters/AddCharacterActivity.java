package com.geekstorming.storymapper.ui.characters;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.adapters.FactionAdapter;
import com.geekstorming.storymapper.adapters.LocationAdapter;
import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.ui.characters.presenter.AddEditCharacterPresenter;

/**
 * Adding new character
 *
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */
public class AddCharacterActivity extends AppCompatActivity {

    private TextInputEditText tID_CharacterName;
    private TextInputEditText tID_CharacterDescription;
    private Spinner spn_CharacterFaction;
    private Spinner spn_CharacterHome;

    AddEditCharacterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_character);

        initializeViews();
        presenter = new AddEditCharacterPresenter();
    }

    //region Activity setup

    private void initializeViews() {
        tID_CharacterName = (TextInputEditText) findViewById(R.id.tiD_CharacterName);
        tID_CharacterDescription = (TextInputEditText) findViewById(R.id.tID_CharacterDescription);
        //spn_CharacterFaction = (Spinner) findViewById(R.id.spn_CharacterFaction);
        //spn_CharacterHome = (Spinner) findViewById(R.id.spn_CharactersHome);

        //initializeSpinners();
    }

    private void initializeSpinners() {
        // Getting factions:
        // Adapter needed!
        spn_CharacterFaction.setAdapter(new FactionAdapter(this));

        // Getting locations:

        // Adapter needed!
        spn_CharacterHome.setAdapter(new LocationAdapter(this));
    }

    //endregion

    //region Adding character to repository

    private void addCharacterToRepository() {
        // Adding character to repository
        presenter.addCharacter(new Character(1, tID_CharacterName.getText().toString(),
                tID_CharacterDescription.getText().toString(), 1, 1));

        Toast.makeText(this, "Añadiendo personaje...", Toast.LENGTH_SHORT).show();
    }

    //endregion

    public void onClick_AddCharacter(View v) {
        switch (v.getId()) {
            case R.id.fab_CharacterDone:
                addCharacterToRepository();
                finish();
                break;
            case R.id.btn_CharacterRelationShips:
                break;
        }
    }
}
