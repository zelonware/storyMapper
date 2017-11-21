package com.geekstorming.storymapper.ui.locations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.geekstorming.storymapper.R;

public class AddLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);
    }

    public void onClick_addLocation(View v) {
        switch (v.getId()) {
            case R.id.fab_LocationDone:
                Toast.makeText(this, "Agregando localizacion...", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
