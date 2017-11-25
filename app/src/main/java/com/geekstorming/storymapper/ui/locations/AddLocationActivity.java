package com.geekstorming.storymapper.ui.locations;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.data.pojo.Location;
import com.geekstorming.storymapper.data.repos.LocationRepository;

public class AddLocationActivity extends AppCompatActivity {

    TextInputEditText tID_LocationName;
    TextInputEditText tID_LocationDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);

        initializeViews();
    }

    void initializeViews()
    {
        tID_LocationName = (TextInputEditText) findViewById(R.id.tiD_LocationName);
        tID_LocationDesc = (TextInputEditText) findViewById(R.id.tiD_LocationDesc);
    }

    public void onClick_addLocation(View v) {
        switch (v.getId()) {
            case R.id.fab_LocationDone:
                Location newLocation = new Location(0, tID_LocationName.getText().toString(),
                        tID_LocationDesc.getText().toString());

                LocationRepository.getInstance().addLocation(newLocation);
                Toast.makeText(this, "Agregando localizacion...", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
