package com.geekstorming.storymapper.ui.locations.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.adapters.LocationAdapter;
import com.geekstorming.storymapper.base.BasePresenter;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.data.pojo.Location;
import com.geekstorming.storymapper.ui.locations.contracts.ListLocationContract;
import com.geekstorming.storymapper.utils.CommonUIUtils;
import com.geekstorming.storymapper.utils.ModeAddEdit;

import java.util.List;

/**
 * Location list fragment
 */

public class LocationList_Fragment extends ListFragment implements ListLocationContract.View {

    private FloatingActionButton fab_addLocations;
    private ListView listView_locations;

    private LocationAdapter locationAdapter;

    private ListLocationContract.Presenter presenter;

    ListLocationListener callback;

    private static Book selectedBook;

    public static final String TAG = "locationList";

    public static LocationList_Fragment newInstance(Bundle args) {
        LocationList_Fragment locationList_fragment = new LocationList_Fragment();

        if (args != null) {
            locationList_fragment.setArguments(args);
            selectedBook = args.getParcelable(Book.TAG);
        }

        return locationList_fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_location_list, container, false);

        fab_addLocations = (FloatingActionButton) rootView.findViewById(R.id.fab_Locations);

        presenter.loadLocations(selectedBook);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            callback = (ListLocationListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must be implemented");
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setListAdapter(locationAdapter);
        listView_locations = (ListView) getListView().findViewById(android.R.id.list);
        listView_locations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle b = new Bundle();
                b.putParcelable(Location.TAG, (Location)parent.getItemAtPosition(position));
                callback.viewSelectedLocation(b);
            }
        });

        fab_addLocations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putParcelable(Book.TAG, selectedBook);
                callback.addNewLocation(b, ModeAddEdit.ADD_MODE);
            }
        });

        presenter.loadLocations(selectedBook);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.locationAdapter = new LocationAdapter(getActivity(), selectedBook);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.contextmenu_delete_book, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        switch (item.getItemId())
        {
            case R.id.action_delete_book:
                Bundle bundle = new Bundle();
                bundle.putParcelable(Character.TAG,  locationAdapter.getItem(info.position));
                bundle.putString(CommonUIUtils.MSG, "¿Quieres eliminar la localización \'" +
                        locationAdapter.getItem(info.position).getLocationName() + "\' ?");
                bundle.putString(CommonUIUtils.TITLE, "Eliminar localización");

                CommonUIUtils.showDeleteLocationDialog(bundle, getActivity(), presenter).show();
                break;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (ListLocationContract.Presenter) presenter;
    }

    @Override
    public void showLocations(List<Location> locationList) {

    }

    @Override
    public void onDatabaseError(Error error) {

    }

    @Override
    public void onDatabaseError(Exception exception) {

    }

    @Override
    public void showProgressDialog(String message) {

    }

    @Override
    public void dismissProgressDialog() {

    }

    public interface ListLocationListener {
        void addNewLocation(Bundle b, int mode);
        void viewSelectedLocation(Bundle b);
    }
}
