package com.geekstorming.storymapper.ui.factions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.geekstorming.storymapper.R;

public class AddFactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_faction);
    }

    public void onClick_addFaction(View v) {
        switch (v.getId()) {
            case R.id.fab_FactionDone:
                Toast.makeText(this, "Agregando facción...", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
