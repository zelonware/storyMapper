package com.geekstorming.storymapper.ui.locations;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.data.pojo.Location;

public class EditLocationActivity extends AppCompatActivity {

    TextInputEditText tID_LocationName;
    TextInputEditText tID_LocationDesc;

    Location editableLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_location);

        initializeViews();

        editableLocation = (Location) getIntent().getExtras().getParcelable("editableLocation");

        loadEditableLocation();
    }

    void initializeViews()
    {
        tID_LocationName = (TextInputEditText) findViewById(R.id.tiD_LocationName);
        tID_LocationDesc = (TextInputEditText) findViewById(R.id.tiD_LocationDesc);
    }

    void loadEditableLocation()
    {
        tID_LocationName.setText(editableLocation.getLocationName());
        tID_LocationDesc.setText(editableLocation.getLocationDesc());
    }

    public void onClick_editLocation(View v) {
        switch (v.getId()) {
            case R.id.fab_LocationEdited:
                editableLocation = new Location(editableLocation.getLocationID(),
                        tID_LocationName.getText().toString(), tID_LocationDesc.getText().toString());
                Toast.makeText(this, "Editando localizacion...", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
