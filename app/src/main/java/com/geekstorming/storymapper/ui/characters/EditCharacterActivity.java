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
 * Editing an existing character
 *
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */
public class EditCharacterActivity extends AppCompatActivity {

    private TextInputEditText tID_CharacterName;
    private TextInputEditText tID_CharacterDescription;
    private Spinner spn_CharacterFaction;
    private Spinner spn_CharacterHome;

    Character editableCharacter;

    AddEditCharacterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_character);

        initializeViews();
        // Load character from Bundle
        loadCharacter();

        presenter = new AddEditCharacterPresenter();
    }

    //region Activity setup

    private void initializeViews() {
        tID_CharacterName = (TextInputEditText) findViewById(R.id.tID_CharacterName);
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

    private void loadCharacter() {

        editableCharacter = getIntent().getExtras().getBundle("Bundle").getParcelable(Character.TAG);

        tID_CharacterName.setText(editableCharacter.getCharacterName());
        tID_CharacterDescription.setText(editableCharacter.getCharacterDesc());
    }

    private void editCharacterToRepository() {

        presenter.editCharacter(
                new Character(0, tID_CharacterDescription.getText().toString(), tID_CharacterName.getText().toString(), 1, 1));
        Toast.makeText(this, "Modificando personaje personaje...", Toast.LENGTH_SHORT).show();

    }

    public void onClick_EditCharacter(View v) {
        switch (v.getId()) {
            case R.id.fab_CharacterCorrect:
                editCharacterToRepository();
                finish();
                break;
            case R.id.btn_CharacterRelationShips:
                break;
        }
    }
}
