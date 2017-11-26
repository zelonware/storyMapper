package com.geekstorming.storymapper.ui.factions;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.data.pojo.Faction;
import com.geekstorming.storymapper.data.repos.FactionRepository;

public class AddFactionActivity extends AppCompatActivity {

    TextInputEditText tID_FactionName;
    TextInputEditText tID_FactionObjective;
    Spinner spn_FactionBarracks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_faction);

        initalizeViews();
    }

    void initalizeViews()
    {
        tID_FactionName = (TextInputEditText) findViewById(R.id.tiD_FactionName);
        tID_FactionObjective = (TextInputEditText) findViewById(R.id.tiD_FactionDesc);
        spn_FactionBarracks = (Spinner) findViewById(R.id.spn_FactionBarracks);
    }

    public void onClick_addFaction(View v) {
        switch (v.getId()) {
            case R.id.fab_FactionDone:
                Faction newFaction = new Faction(0, tID_FactionName.getText().toString(),
                        tID_FactionObjective.getText().toString(), 0);
                FactionRepository.getInstance().addFaction(newFaction);
                Toast.makeText(this, "Agregando facción...", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
