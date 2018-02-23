package com.geekstorming.storymapper.ui.characters.fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.adapters.CharacterAdapter;
import com.geekstorming.storymapper.base.BaseFragment;
import com.geekstorming.storymapper.base.BasePresenter;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.ui.characters.contracts.ListCharacterContract;
import com.geekstorming.storymapper.utils.CommonUIUtils;
import com.geekstorming.storymapper.utils.ModeAddEdit;

import java.util.List;

/**
 * Character list fragment
 */

public class CharacterList_Fragment extends BaseFragment implements ListCharacterContract.View {

    private FloatingActionButton fab_addCharacter;
    private RecyclerView recyclerV_Characters;

    private CharacterAdapter characterAdapter;

    private CharacterAdapter.OnItemClickListener onItemClickListener;

    private ListCharacterContract.Presenter presenter;

    ListCharacterListener callback;

    private static Book selectedBook;

    public static final String TAG = "characterList";

    public static CharacterList_Fragment newInstance(Bundle args) {
        CharacterList_Fragment characterList_fragment = new CharacterList_Fragment();

        if (args != null) {
            characterList_fragment.setArguments(args);
            selectedBook = args.getParcelable(Book.TAG);
        }

        return characterList_fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_character_list, container, false);

        fab_addCharacter = (FloatingActionButton) rootView.findViewById(R.id.fab_Characters);
        recyclerV_Characters = (RecyclerView) rootView.findViewById(R.id.recyclerCharacters);

        // Lets create new character!
        fab_addCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putParcelable(Book.TAG, selectedBook);
               callback.addNewCharacter(b, ModeAddEdit.ADD_MODE);
            }
        });

        // Clicking on an existing character:
        onItemClickListener = new CharacterAdapter.OnItemClickListener() {
            @Override
            public void onCharacterClick(Character c) {
                Bundle b = new Bundle();
                b.putParcelable(Character.TAG, c);
                callback.viewSelectedCharacter(b);
            }
        };

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            callback = (ListCharacterListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must be implemented");
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerV_Characters.setHasFixedSize(true);
        recyclerV_Characters.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Getting adapter
        characterAdapter = new CharacterAdapter(onItemClickListener, selectedBook);

        // Setting adapter
        recyclerV_Characters.setAdapter(characterAdapter);

        presenter.loadCharacters(selectedBook);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.characterAdapter = new CharacterAdapter(onItemClickListener, selectedBook);
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
                bundle.putParcelable(Character.TAG,  characterAdapter.getItem(info.position));
                bundle.putString(CommonUIUtils.MSG, "¿Quieres eliminar el personaje \'" +
                        characterAdapter.getItem(info.position).getCharacterName() + "\' ?");
                bundle.putString(CommonUIUtils.TITLE, "Eliminar personaje");

                CommonUIUtils.showDeleteCharacterDialog(bundle, getActivity(), presenter).show();
                break;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (ListCharacterContract.Presenter) presenter;
    }

    @Override
    public void showCharacters(List<Character> characterList) {

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

    public interface ListCharacterListener {
        void addNewCharacter(Bundle b, int mode);
        void viewSelectedCharacter(Bundle b);
    }
}
