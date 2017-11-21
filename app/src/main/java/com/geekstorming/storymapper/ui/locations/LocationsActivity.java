package com.geekstorming.storymapper.ui.locations;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.adapters.LocationAdapter;
import com.geekstorming.storymapper.data.repos.FactionRepository;
import com.geekstorming.storymapper.data.repos.LocationRepository;

public class LocationsActivity extends AppCompatActivity {

    private LocationAdapter adapter;
    Toolbar toolBar_Locations;
    FloatingActionButton fab_AddLocation;
    ListView locationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);

        fab_AddLocation = (FloatingActionButton) findViewById(R.id.fab_Locations);
        toolBar_Locations = (Toolbar) findViewById(R.id.toolbar_Locations);

        // Setting listView
        locationList = (ListView) findViewById(android.R.id.list);
        locationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LocationsActivity.this, EditLocationActivity.class);

                intent.putExtra("editableLocation", LocationRepository.getInstance().getLocations().get(position));
                startActivity(intent);
            }
        });

        fab_AddLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LocationsActivity.this, AddLocationActivity.class));
            }
        });

        setSupportActionBar(toolBar_Locations);
        adapter = new LocationAdapter(this);
        locationList.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter = new LocationAdapter(this);
        locationList.setAdapter(adapter);
    }
}
