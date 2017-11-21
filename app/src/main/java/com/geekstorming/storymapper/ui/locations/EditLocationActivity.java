package com.geekstorming.storymapper.ui.locations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.data.pojo.Location;

public class EditLocationActivity extends AppCompatActivity {

    Location editableLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_location);
    }

    public void onClick_editLocation(View v) {
        switch (v.getId()) {
            case R.id.fab_LocationEdited:
                Toast.makeText(this, "Editando localizacion...", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
