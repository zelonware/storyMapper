package com.geekstorming.storymapper.ui.characters;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.utils.ModeAddEdit;

public class DetailCharactersActivity extends AppCompatActivity {

    private TextInputEditText tID_CharacterName;
    private TextInputEditText tID_CharacterDescription;
    private TextView spn_CharacterFaction;
    private TextView spn_CharacterHome;
    private FloatingActionButton fab_CharacterEdit;

    private static Character editableCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_characters);

        editableCharacter = getIntent().getBundleExtra(Character.TAG).getParcelable(Character.TAG);

        tID_CharacterName = (TextInputEditText) findViewById(R.id.tiD_CharacterName);
        tID_CharacterDescription = (TextInputEditText) findViewById(R.id.tID_CharacterDescription);
        spn_CharacterFaction = (TextView) findViewById(R.id.spn_CharacterFaction);
        spn_CharacterHome = (TextView) findViewById(R.id.spn_CharactersHome);

        fab_CharacterEdit = (FloatingActionButton) findViewById(R.id.fab_CharacterEdit);
        fab_CharacterEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putParcelable(Character.TAG, editableCharacter);

                Intent intent = new Intent(DetailCharactersActivity.this, AddEditCharacterActitivy.class);
                intent.putExtra(Character.TAG, b);
                startActivity(intent);
            }
        });

        tID_CharacterName.setText(editableCharacter.getCharacterName());
        tID_CharacterDescription.setText(editableCharacter.getCharacterDesc());
        spn_CharacterFaction.setText(Integer.toString(editableCharacter.getCharacterFaction()));
        spn_CharacterHome.setText(Integer.toString(editableCharacter.getCharacterHome()));
    }
}
