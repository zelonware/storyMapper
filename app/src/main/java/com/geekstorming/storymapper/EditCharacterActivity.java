package com.geekstorming.storymapper;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.geekstorming.storymapper.pojo.Character;

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

    private void editCharacterToRepository() {
        if (tID_CharacterDescription.length() != 0 && tID_CharacterName.length() != 0 &&
                spn_CharacterFaction.getSelectedItemPosition() != -1 &&
                spn_CharacterHome.getSelectedItemPosition() != -1) {
            /*
            editableCharacter.setCharacterDesc(tID_CharacterDescription.getText().toString());
            editableCharacter.setCharacterName(tID_CharacterName.getText().toString());
            editableCharacter.setCharacterFaction(FactionRepository.getInstance().getFactions().get(spn_CharacterFaction.getSelectedItemPosition()));
            editableCharacter.setCharacterHome(LocationRepository.getInstance().getLocations().get(spn_CharacterHome.getSelectedItemPosition()));
           */
            Toast.makeText(this, "Modificando personaje personaje...", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "¿Faltan datos de personajes?", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick_AddCharacter(View v) {
        switch (v.getId()) {
            case R.id.fab_CharacterCorrect:
                editCharacterToRepository();
                break;
            case R.id.btn_CharacterRelationShips:
                break;
        }
    }
}
