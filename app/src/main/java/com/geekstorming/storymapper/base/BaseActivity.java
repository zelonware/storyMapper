package com.geekstorming.storymapper.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.geekstorming.storymapper.AboutActivity;
import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.ui.books.BookActivity;
import com.geekstorming.storymapper.ui.settings.SettingsActivity;

/**
 * Base for Activities
 *  @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class BaseActivity extends AppCompatActivity {

    private DrawerLayout drawL_base;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawL_base = (DrawerLayout) findViewById(R.id.drawL_base);

        navigationView = (NavigationView) findViewById(R.id.navigationView);
        setupNavigationView();
    }

    private void setupNavigationView() {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.action_books:
                        closeDrawerAndChangeTitle(item);
                        showBooks();
                        break;
                    case R.id.action_help:
                        //lanzarHelp();
                        break;
                    case R.id.action_settings:
                        closeDrawerAndChangeTitle(item);
                        showSettings();
                        break;
                    case R.id.action_about:
                        closeDrawerAndChangeTitle(item);
                        showAbout();
                        break;
                    case R.id.action_factions:
                        showFactions();
                        break;
                    case R.id.action_locations:
                        showLocations();
                        break;
                    case R.id.action_advice:
                        getAdvice();
                        break;
                }
                item.setChecked(true);

                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                drawL_base.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawL_base.isDrawerOpen(GravityCompat.START))
            drawL_base.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    private void closeDrawerAndChangeTitle(MenuItem item) {
        getSupportActionBar().setTitle(item.getTitle());
        drawL_base.closeDrawer(GravityCompat.START);
    }

    private void showSettings() {
        startActivity(new Intent(this, SettingsActivity.class));
    }

    private void showBooks() {
        startActivity(new Intent(this, BookActivity.class));
    }

    private void showAbout() {
        startActivity(new Intent(this, AboutActivity.class));
    }

    private void showLocations() {
        Toast.makeText(this, "Por implementar", Toast.LENGTH_SHORT).show();
    }

    private void showFactions() {
        Toast.makeText(this, "Por implementar", Toast.LENGTH_SHORT).show();
    }

    private void getAdvice() {
        Toast.makeText(this, "keep trying, KEEP TRYING!", Toast.LENGTH_SHORT).show();
    }
}
