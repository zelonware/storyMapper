package com.geekstorming.storymapper.ui.factions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.data.pojo.Faction;

public class EditFactionActivity extends AppCompatActivity {

    Faction editableFaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_faction);
    }

    public void onClick_editFaction(View v) {
        switch (v.getId()) {
            case R.id.fab_FactionEdited:
                Toast.makeText(this, "Editando facción...", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
