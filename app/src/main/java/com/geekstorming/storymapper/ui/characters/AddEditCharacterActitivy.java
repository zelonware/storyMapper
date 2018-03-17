package com.geekstorming.storymapper.ui.characters;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.base.BasePresenter;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.ui.characters.contracts.AddEditCharacterContract;
import com.geekstorming.storymapper.ui.characters.fragments.AddEditCharacter_Fragment;
import com.geekstorming.storymapper.ui.characters.presenter.AddEditCharacterPresenter;
import com.geekstorming.storymapper.utils.ModeAddEdit;

public class AddEditCharacterActitivy extends AppCompatActivity implements AddEditCharacterContract.View {

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

    private int selectedMode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_character_actitivy);

        presenter = new AddEditCharacterPresenter(this);

        mode = new ModeAddEdit(ModeAddEdit.ADD_MODE);

            if (selectedMode == ModeAddEdit.EDIT_MODE) {
                editableCharacter = (Character) getIntent().getBundleExtra(Character.TAG).getParcelable(Character.TAG);
            }
            else {
                selectedBook = (Book) getIntent().getBundleExtra(Character.TAG).getParcelable(Book.TAG);
            }

            mode.setMode(selectedMode);

        tID_CharacterName = (TextInputEditText) findViewById(R.id.tiD_CharacterName);
        tID_CharacterDescription = (TextInputEditText) findViewById(R.id.tID_CharacterDescription);
        spn_CharacterFaction = (Spinner) findViewById(R.id.spn_CharacterFaction);
        spn_CharacterHome = (Spinner) findViewById(R.id.spn_CharactersHome);

        btn_CharacterRelationShips = (Button) findViewById(R.id.btn_CharacterRelationShips);
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

        fab_CharacterDone = (FloatingActionButton) findViewById(R.id.fab_CharacterDone);
        fab_CharacterDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //addOrEditCharacter();
                presenter.validateCharacterData(tID_CharacterName.getText().toString(),
                        tID_CharacterDescription.getText().toString());
            }
        });

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

    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddEditCharacterPresenter) presenter;
    }

    @Override
    public void onNameEmtpy() {
        Toast.makeText(this, getResources().getString(R.string.characterNameEmpty), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDescriptionEmpy() {
        Toast.makeText(this, getResources().getString(R.string.characterDescEmpty), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void doAddOrEdit() {
        addOrEditCharacter();
    }
}
