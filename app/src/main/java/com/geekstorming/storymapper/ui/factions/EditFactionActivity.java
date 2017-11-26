package com.geekstorming.storymapper.ui.factions;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.data.pojo.Faction;

public class EditFactionActivity extends AppCompatActivity {

    TextInputEditText tID_FactionName;
    TextInputEditText tID_FactionObjective;
    Spinner spn_FactionBarracks;

    Faction editableFaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_faction);

        initalizeViews();

        editableFaction = (Faction) getIntent().getExtras().getParcelable("editableFaction");

        loadEditableFaction();
    }

    void initalizeViews()
    {
        tID_FactionName = (TextInputEditText) findViewById(R.id.tiD_FactionName);
        tID_FactionObjective = (TextInputEditText) findViewById(R.id.tiD_FactionDesc);
        spn_FactionBarracks = (Spinner) findViewById(R.id.spn_FactionBarracks);
    }

    void loadEditableFaction()
    {
       tID_FactionName.setText(editableFaction.getFactionName());
       tID_FactionObjective.setText(editableFaction.getFactionObjetive());
    }

    public void onClick_editFaction(View v) {
        switch (v.getId()) {
            case R.id.fab_FactionEdited:
                editableFaction = new Faction(0, tID_FactionName.getText().toString(),
                        tID_FactionObjective.getText().toString(), 0);
                Toast.makeText(this, "Editando facción...", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
