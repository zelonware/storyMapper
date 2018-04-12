package com.geekstorming.storymapper.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.base.BaseActivity;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.data.pojo.Faction;
import com.geekstorming.storymapper.data.pojo.Location;
import com.geekstorming.storymapper.ui.characters.fragments.AddEditCharacter_Fragment;
import com.geekstorming.storymapper.ui.characters.fragments.CharacterList_Fragment;
import com.geekstorming.storymapper.ui.characters.fragments.ViewCharacter_Fragment;
import com.geekstorming.storymapper.ui.characters.presenter.CharaterListPresenter;
import com.geekstorming.storymapper.ui.factions.fragments.AddEditFaction_Fragment;
import com.geekstorming.storymapper.ui.factions.fragments.FactionList_Fragment;
import com.geekstorming.storymapper.ui.factions.fragments.ViewFaction_Fragment;
import com.geekstorming.storymapper.ui.factions.presenter.FactionListPresenter;
import com.geekstorming.storymapper.ui.locations.fragments.AddEditLocation_Fragment;
import com.geekstorming.storymapper.ui.locations.fragments.LocationList_Fragment;
import com.geekstorming.storymapper.ui.locations.fragments.ViewLocation_Fragment;
import com.geekstorming.storymapper.ui.locations.presenter.LocationListPresenter;

public class BookManagerActivity extends BaseActivity implements AddEditCharacter_Fragment.AddNewCharacterClickListener, CharacterList_Fragment.ListCharacterListener, ViewCharacter_Fragment.ViewCharacterClickListener,
        AddEditFaction_Fragment.AddNewFactionClickListener, FactionList_Fragment.ListFactionListener, ViewFaction_Fragment.ViewFactionClickListener,
        AddEditLocation_Fragment.AddNewLocationClickListener, LocationList_Fragment.ListLocationListener, ViewLocation_Fragment.ViewLocationClickListener

{

    CharacterList_Fragment characterList_Frag;
    AddEditCharacter_Fragment addEditCharacter_Frag;
    ViewCharacter_Fragment viewCharacter_Frag;

    LocationList_Fragment locationList_Frag;
    AddEditLocation_Fragment addEditLocation_Frag;
    ViewLocation_Fragment viewLocation_Frag;

    FactionList_Fragment factionList_Frag;
    AddEditFaction_Fragment addEditFaction_Frag;
    ViewFaction_Fragment viewFaction_Frag;

    Book viewBook;

    Character selectedCharacter;
    Faction selectedFaction;
    Location selectedLocation;

    CharaterListPresenter presenterCharacters;
    LocationListPresenter presenterLocations;
    FactionListPresenter presenterFactions;

    private BottomNavigationView bottomnv_bookManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();

        setContentView(R.layout.activity_book_manager);
        bottomnv_bookManager = (BottomNavigationView) findViewById(R.id.bottomnv_bookManager);

        viewBook = getIntent().getExtras().getParcelable(Book.TAG);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        characterList_Frag = (CharacterList_Fragment) fragmentManager.findFragmentByTag(CharacterList_Fragment.TAG);

        if (characterList_Frag == null) {
            characterList_Frag = CharacterList_Fragment.newInstance(getIntent().getExtras());
            fragmentTransaction.add(R.id.flContent, characterList_Frag, CharacterList_Fragment.TAG);
            fragmentTransaction.commit();
        }

        presenterCharacters = new CharaterListPresenter(characterList_Frag);
        characterList_Frag.setPresenter(presenterCharacters);

        bottomnv_bookManager.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.action_seeChapters:
                        loadLocationsFragment();
                        break;
                    case R.id.action_seeCharacters:
                        loadCharactersFragment();
                        break;
                    case R.id.action_seeFactions:
                        loadFactionsFragment();
                        break;
                }

                return true;
            }
        });
    }

    private void loadCharactersFragment() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        characterList_Frag = (CharacterList_Fragment) fragmentManager.findFragmentByTag(CharacterList_Fragment.TAG);

        if (characterList_Frag == null) {
            characterList_Frag = CharacterList_Fragment.newInstance(getIntent().getExtras());
            fragmentTransaction.replace(R.id.flContent, characterList_Frag, CharacterList_Fragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        presenterCharacters = new CharaterListPresenter(characterList_Frag);
        characterList_Frag.setPresenter(presenterCharacters);
    }

    private void loadLocationsFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        locationList_Frag = (LocationList_Fragment) fragmentManager.findFragmentByTag(LocationList_Fragment.TAG);

        if (locationList_Frag == null) {
            locationList_Frag = LocationList_Fragment.newInstance(getIntent().getExtras());
            fragmentTransaction.replace(R.id.flContent, locationList_Frag, LocationList_Fragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        presenterLocations = new LocationListPresenter(locationList_Frag);
        locationList_Frag.setPresenter(presenterLocations);

    }

    private void loadFactionsFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        factionList_Frag = (FactionList_Fragment) fragmentManager.findFragmentByTag(FactionList_Fragment.TAG);

        if (factionList_Frag == null) {
            factionList_Frag = FactionList_Fragment.newInstance(getIntent().getExtras());
            fragmentTransaction.replace(R.id.flContent, factionList_Frag, FactionList_Fragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        presenterFactions = new FactionListPresenter(factionList_Frag);
        factionList_Frag.setPresenter(presenterLocations);
    }

    // CharacterFragments implementation

    @Override
    public void returnToList() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
        fragmentManager.popBackStack();
    }

    @Override
    public void addNewCharacter(Bundle b, int mode) {
        toAddEditCharacter(b, mode);
    }

    @Override
    public void viewSelectedCharacter(Bundle b) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        viewCharacter_Frag = (ViewCharacter_Fragment) fragmentManager.findFragmentByTag(ViewCharacter_Fragment.TAG);

        if (viewCharacter_Frag == null) {
            viewCharacter_Frag = ViewCharacter_Fragment.newInstance(b);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.flContent, viewCharacter_Frag, ViewCharacter_Fragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    private void toAddEditCharacter(Bundle b, int mode) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        addEditCharacter_Frag = (AddEditCharacter_Fragment) fragmentManager.findFragmentByTag(AddEditCharacter_Fragment.TAG);

        if (addEditCharacter_Frag == null) {
            b.putParcelable(Book.TAG, viewBook);
            b.putParcelable(Character.TAG, selectedCharacter);
            addEditCharacter_Frag = AddEditCharacter_Fragment.newInstance(b, mode);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.flContent, addEditCharacter_Frag, AddEditCharacter_Fragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    private void toAddEditFaction(Bundle b, int mode) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        addEditFaction_Frag = (AddEditFaction_Fragment) fragmentManager.findFragmentByTag(AddEditFaction_Fragment.TAG);

        if (addEditFaction_Frag == null) {
            b.putParcelable(Book.TAG, viewBook);
            b.putParcelable(Faction.TAG, selectedFaction);
            addEditFaction_Frag = AddEditFaction_Fragment.newInstance(b, mode);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.flContent, addEditFaction_Frag, AddEditFaction_Fragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    private void toAddEditLocation(Bundle b, int mode) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        addEditLocation_Frag = (AddEditLocation_Fragment) fragmentManager.findFragmentByTag(AddEditLocation_Fragment.TAG);

        if (addEditLocation_Frag == null) {
            b.putParcelable(Book.TAG, viewBook);
            b.putParcelable(Location.TAG, selectedLocation);
            addEditLocation_Frag = AddEditLocation_Fragment.newInstance(b, mode);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.flContent, addEditLocation_Frag, AddEditLocation_Fragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void editCharacter(Bundle b, int mode) {
        toAddEditCharacter(b, mode);
    }


    @Override
    public void editFaction(Bundle b, int mode) {
        toAddEditFaction(b, mode);
    }

    @Override
    public void editLocation(Bundle b, int mode) {
        toAddEditLocation(b, mode);
    }

    @Override
    public void addNewFaction(Bundle b, int mode) {
        toAddEditFaction(b, mode);
    }

    @Override
    public void viewSelectedFaction(Bundle b) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        viewFaction_Frag = (ViewFaction_Fragment) fragmentManager.findFragmentByTag(ViewFaction_Fragment.TAG);

        if (viewFaction_Frag == null) {
            viewFaction_Frag = ViewFaction_Fragment.newInstance(b);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.flContent, viewFaction_Frag, ViewFaction_Fragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void addNewLocation(Bundle b, int mode) {
        toAddEditLocation(b, mode);
    }

    @Override
    public void viewSelectedLocation(Bundle b) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        viewLocation_Frag = (ViewLocation_Fragment) fragmentManager.findFragmentByTag(ViewLocation_Fragment.TAG);

        if (viewLocation_Frag == null) {
            viewLocation_Frag = ViewLocation_Fragment.newInstance(b);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.flContent, viewLocation_Frag, ViewLocation_Fragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
