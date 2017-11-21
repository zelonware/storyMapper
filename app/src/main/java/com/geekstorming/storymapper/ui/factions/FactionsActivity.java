package com.geekstorming.storymapper.ui.factions;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.adapters.BooksAdapter;
import com.geekstorming.storymapper.adapters.FactionAdapter;
import com.geekstorming.storymapper.data.repos.FactionRepository;
import com.geekstorming.storymapper.ui.books.AddBookActivity;
import com.geekstorming.storymapper.ui.books.BooksActivity;
import com.geekstorming.storymapper.ui.settings.SettingsActivity;

public class FactionsActivity extends AppCompatActivity {

    private FactionAdapter adapter;
    Toolbar toolBar_Factions;
    FloatingActionButton fab_AddFaction;
    ListView factionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factions);

        fab_AddFaction = (FloatingActionButton) findViewById(R.id.fab_Factions);
        toolBar_Factions = (Toolbar) findViewById(R.id.toolbar_Factions);

        // Setting listView
        factionList = (ListView) findViewById(android.R.id.list);
        factionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FactionsActivity.this, EditFactionActivity.class);

                intent.putExtra("editableFaction", FactionRepository.getInstance().getFactions().get(position));
                startActivity(intent);
            }
        });

        fab_AddFaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FactionsActivity.this, AddFactionActivity.class));
            }
        });

        setSupportActionBar(toolBar_Factions);
        adapter = new FactionAdapter(this);
        factionList.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter = new FactionAdapter(this);
        factionList.setAdapter(adapter);
    }
}
