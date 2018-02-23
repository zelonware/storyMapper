package com.geekstorming.storymapper.ui.characters.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.base.BaseFragment;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.ui.characters.presenter.AddEditCharacterPresenter;
import com.geekstorming.storymapper.utils.ModeAddEdit;

/**
 * Created by napst on 22/02/2018.
 */

public class ViewCharacter_Fragment extends BaseFragment {

    public static final String TAG = "View";

    private TextInputEditText tID_CharacterName;
    private TextInputEditText tID_CharacterDescription;
    private TextView spn_CharacterFaction;
    private TextView spn_CharacterHome;
    private FloatingActionButton fab_CharacterEdit;

    private static Character editableCharacter;

    ViewCharacterClickListener callback;

    public static ViewCharacter_Fragment newInstance(Bundle args) {
        ViewCharacter_Fragment viewCharacter_fragment = new ViewCharacter_Fragment();

        if (args != null) {
            viewCharacter_fragment.setArguments(args);
            editableCharacter = (Character) args.getParcelable(Character.TAG);
        }

        return viewCharacter_fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_character_detail, container, false);

        tID_CharacterName = (TextInputEditText) viewRoot.findViewById(R.id.tiD_CharacterName);
        tID_CharacterDescription = (TextInputEditText) viewRoot.findViewById(R.id.tID_CharacterDescription);
        spn_CharacterFaction = (TextView) viewRoot.findViewById(R.id.spn_CharacterFaction);
        spn_CharacterHome = (TextView) viewRoot.findViewById(R.id.spn_CharactersHome);

        fab_CharacterEdit = (FloatingActionButton) viewRoot.findViewById(R.id.fab_CharacterEdit);
        fab_CharacterEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putParcelable(Character.TAG, editableCharacter);
                callback.editCharacter(b, ModeAddEdit.EDIT_MODE);
            }
        });

        return viewRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tID_CharacterName.setText(editableCharacter.getCharacterName());
        tID_CharacterDescription.setText(editableCharacter.getCharacterDesc());
        spn_CharacterFaction.setText(Integer.toString(editableCharacter.getCharacterFaction()));
        spn_CharacterHome.setText(Integer.toString(editableCharacter.getCharacterHome()));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            callback = (ViewCharacterClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must be implemented");
        }
    }

    public interface ViewCharacterClickListener
    {
        void editCharacter(Bundle b, int mode);
    }

}