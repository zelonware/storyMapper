package com.geekstorming.storymapper.ui.factions.fragments;

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
import com.geekstorming.storymapper.adapters.FactionAdapter;
import com.geekstorming.storymapper.base.BasePresenter;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Faction;
import com.geekstorming.storymapper.ui.factions.contracts.ListFactionContract;
import com.geekstorming.storymapper.utils.CommonUIUtils;
import com.geekstorming.storymapper.utils.ModeAddEdit;

import java.util.List;

/**
 * Faction list fragment
 */

public class FactionList_Fragment extends ListFragment implements ListFactionContract.View {

    private FloatingActionButton fab_addFactions;
    private ListView listView_factions;

    private FactionAdapter factionAdapter;

    private ListFactionContract.Presenter presenter;

    ListFactionListener callback;

    private static Book selectedBook;

    public static final String TAG = "factionList";

    public static FactionList_Fragment newInstance(Bundle args) {
        FactionList_Fragment factionList_fragment = new FactionList_Fragment();

        if (args != null) {
            factionList_fragment.setArguments(args);
            selectedBook = args.getParcelable(Book.TAG);
        }

        return factionList_fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_faction_list, container, false);

        fab_addFactions = (FloatingActionButton) rootView.findViewById(R.id.fab_Factions);

        presenter.loadFactions(selectedBook);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            callback = (ListFactionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must be implemented");
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setListAdapter(factionAdapter);
        listView_factions = (ListView) getListView().findViewById(android.R.id.list);
        listView_factions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle b = new Bundle();
                b.putParcelable(Faction.TAG, (Faction)parent.getItemAtPosition(position));
                callback.viewSelectedFaction(b);
            }
        });

        fab_addFactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putParcelable(Book.TAG, selectedBook);
                callback.addNewFaction(b, ModeAddEdit.ADD_MODE);
            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.factionAdapter = new FactionAdapter(getActivity(), selectedBook);
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
                bundle.putParcelable(Faction.TAG,  factionAdapter.getItem(info.position));
                bundle.putString(CommonUIUtils.MSG, "¿Quieres eliminar la facción \'" +
                        factionAdapter.getItem(info.position).getFactionName() + "\' ?");
                bundle.putString(CommonUIUtils.TITLE, "Eliminar facción");

                CommonUIUtils.showDeleteFactionDialog(bundle, getActivity(), presenter).show();
                break;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (ListFactionContract.Presenter) presenter;
    }

    @Override
    public void showFactions(List<Faction> factionList) {

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

    public interface ListFactionListener {
        void addNewFaction(Bundle b, int mode);
        void viewSelectedFaction(Bundle b);
    }
}
