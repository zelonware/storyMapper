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
import android.widget.Toast;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.base.BaseFragment;
import com.geekstorming.storymapper.base.BasePresenter;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.ui.books.presenter.AddEditBookPresenter;
import com.geekstorming.storymapper.ui.characters.contracts.AddEditCharacterContract;
import com.geekstorming.storymapper.ui.characters.presenter.AddEditCharacterPresenter;
import com.geekstorming.storymapper.utils.ModeAddEdit;

/**
 * Adding new character
 *
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */
public class AddEditCharacter_Fragment extends BaseFragment implements AddEditCharacterContract.View {

    public static final String TAG = "addeditCharacter";

    private TextInputEditText tID_CharacterName;
    private TextInputEditText tID_CharacterDescription;
    private Spinner spn_CharacterFaction;
    private Spinner spn_CharacterHome;
    private Button btn_CharacterRelationShips;
    private FloatingActionButton fab_CharacterDone;

    AddEditCharacterPresenter presenter;

    static ModeAddEdit mode;

    private static Character editableCharacter;
    private static Book selectedBook;

    AddNewCharacterClickListener callback;

    public static AddEditCharacter_Fragment newInstance(Bundle args, int selectedMode) {
        AddEditCharacter_Fragment addEditCharacter_fragment = new AddEditCharacter_Fragment();
        mode = new ModeAddEdit(ModeAddEdit.ADD_MODE);

        if (args != null) {
            if (selectedMode == ModeAddEdit.EDIT_MODE) {
                addEditCharacter_fragment.setArguments(args);
                editableCharacter = (Character) args.getParcelable(Character.TAG);
            }
            else {
                selectedBook = (Book) args.getParcelable(Book.TAG);
            }

            mode.setMode(selectedMode);
        }

        return addEditCharacter_fragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_character_add, container, false);

        presenter = new AddEditCharacterPresenter(this);

        tID_CharacterName = (TextInputEditText) viewRoot.findViewById(R.id.tiD_CharacterName);
        tID_CharacterDescription = (TextInputEditText) viewRoot.findViewById(R.id.tID_CharacterDescription);
        spn_CharacterFaction = (Spinner) viewRoot.findViewById(R.id.spn_CharacterFaction);
        spn_CharacterHome = (Spinner) viewRoot.findViewById(R.id.spn_CharactersHome);

        btn_CharacterRelationShips = (Button) viewRoot.findViewById(R.id.btn_CharacterRelationShips);
        if (mode.getMode() == ModeAddEdit.ADD_MODE)
        {
            btn_CharacterRelationShips.setEnabled(false);
        }
        else {
            btn_CharacterRelationShips.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        fab_CharacterDone = (FloatingActionButton) viewRoot.findViewById(R.id.fab_CharacterDone);
        fab_CharacterDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //addOrEditCharacter();
                presenter.validateCharacterData(tID_CharacterName.getText().toString(),
                        tID_CharacterDescription.getText().toString());
            }
        });

        return viewRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (mode.getMode() == ModeAddEdit.EDIT_MODE)
        {
            tID_CharacterName.setText(editableCharacter.getCharacterName());
            tID_CharacterDescription.setText(editableCharacter.getCharacterDesc());
        }
    }

    private void addOrEditCharacter() {
        if (mode.getMode() == ModeAddEdit.ADD_MODE) {
            presenter.addCharacter(new Character(0, tID_CharacterName.getText().toString(),
                    tID_CharacterDescription.getText().toString(), 1, 1, selectedBook.getBookID()));
        }
        if (mode.getMode() == ModeAddEdit.EDIT_MODE) {
            presenter.editCharacter(new Character(editableCharacter.getCharacterID(),
                    tID_CharacterName.getText().toString(),
                    tID_CharacterDescription.getText().toString(),
                    editableCharacter.getCharacterFaction(),
                    editableCharacter.getCharacterHome(),
                    editableCharacter.getCharacterBook()));
        }

        callback.returnToList();
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            callback = (AddNewCharacterClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must be implemented");
        }
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddEditCharacterPresenter) presenter;
    }

    @Override
    public void onNameEmtpy() {
        Toast.makeText(getActivity(), getResources().getString(R.string.characterNameEmpty), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDescriptionEmpy() {
        Toast.makeText(getActivity(), getResources().getString(R.string.characterDescEmpty), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void doAddOrEdit() {
        addOrEditCharacter();
    }

    public interface AddNewCharacterClickListener
    {
        void returnToList();
    }
}
