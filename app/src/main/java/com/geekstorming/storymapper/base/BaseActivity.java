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
import android.widget.TextView;
import android.widget.Toast;

import com.geekstorming.storymapper.AboutActivity;
import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.base.daos.AdviceDAO;
import com.geekstorming.storymapper.data.dao.AdviceDAOImpl;
import com.geekstorming.storymapper.data.pojo.User;
import com.geekstorming.storymapper.ui.books.BookActivity;
import com.geekstorming.storymapper.ui.receivers.AdviceReceiver;
import com.geekstorming.storymapper.ui.settings.SettingsActivity;
import com.geekstorming.storymapper.utils.CommonUIUtils;

/**
 * Base for Activities
 * Management for NavigationDrawer
 *  @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class BaseActivity extends AppCompatActivity {

    private DrawerLayout drawL_base;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private TextView txtV_username;
    private TextView txtV_email;

    AdviceDAOImpl dao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        dao = new AdviceDAOImpl();

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
                        lanzarHelp();
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
        startActivity(new Intent(BaseActivity.this, SettingsActivity.class));
    }

    public void showBooks() {
        //startActivity(new Intent(BaseActivity.this, BookActivity.class));
    }

    private void showAbout() {
        startActivity(new Intent(BaseActivity.this, AboutActivity.class));
    }

    private void showLocations() {
        Toast.makeText(this, "Por implementar", Toast.LENGTH_SHORT).show();
    }

    private void showFactions() {
        Toast.makeText(this, "Por implementar", Toast.LENGTH_SHORT).show();
    }

    private void getAdvice() {
        //Toast.makeText(this, "keep trying, KEEP TRYING!", Toast.LENGTH_SHORT).show();

        // Notification for writing advice

        Intent adviceMsg = new Intent("com.geekstorming.storymapper.writingadvice");
        Bundle b = new Bundle();
        b.putString(AdviceReceiver.ADVICETAG, dao.getAdvice());
        adviceMsg.putExtras(b);
        sendBroadcast(adviceMsg);
    }

    private void lanzarHelp() {
        CommonUIUtils.showHelpDialog(BaseActivity.this).show();
    }

    public void setDataToNavigationDrawer(User user) {
        txtV_email = (TextView) findViewById(R.id.txtV_email);
        txtV_username = (TextView) findViewById(R.id.txtV_username);
        txtV_username.setText(user.getUser());
        txtV_email.setText(user.getEmail());
    }
}
