package com.geekstorming.storymapper.ui.factions.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.base.BaseFragment;
import com.geekstorming.storymapper.base.BasePresenter;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Faction;
import com.geekstorming.storymapper.ui.factions.contracts.AddEditFactionContract;
import com.geekstorming.storymapper.ui.factions.presenter.AddEditFactionPresenter;
import com.geekstorming.storymapper.utils.ModeAddEdit;

/**
 * Adding new faction
 *
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */
public class AddEditFaction_Fragment extends BaseFragment implements AddEditFactionContract.View {

    public static final String TAG = "addeditFaction";

    private TextInputEditText tID_FactionName;
    private TextInputEditText tID_FactionDescription;
    private FloatingActionButton fab_FactionDone;

    AddEditFactionPresenter presenter;

    static ModeAddEdit mode;

    private static Faction editableFaction;
    private static Book selectedBook;

    AddNewFactionClickListener callback;

    public static AddEditFaction_Fragment newInstance(Bundle args, int selectedMode) {
        AddEditFaction_Fragment addEditFaction_fragment = new AddEditFaction_Fragment();
        mode = new ModeAddEdit(ModeAddEdit.ADD_MODE);

        if (args != null) {
            if (selectedMode == ModeAddEdit.EDIT_MODE) {
                addEditFaction_fragment.setArguments(args);
                editableFaction = (Faction) args.getParcelable(Faction.TAG);
            }
            else {
                selectedBook = (Book) args.getParcelable(Book.TAG);
            }

            mode.setMode(selectedMode);
        }

        return addEditFaction_fragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_faction_add, container, false);

        presenter = new AddEditFactionPresenter(this);

        tID_FactionName = (TextInputEditText) viewRoot.findViewById(R.id.tiD_FactionName);
        tID_FactionDescription = (TextInputEditText) viewRoot.findViewById(R.id.tiD_FactionDesc);

        fab_FactionDone = (FloatingActionButton) viewRoot.findViewById(R.id.fab_FactionDone);
        fab_FactionDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //addOrEditFaction();
                presenter.validateCharacterData(tID_FactionName.getText().toString(),
                        tID_FactionDescription.getText().toString());
            }
        });

        return viewRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (mode.getMode() == ModeAddEdit.EDIT_MODE)
        {
            tID_FactionName.setText(editableFaction.getFactionName());
            tID_FactionDescription.setText(editableFaction.getFactionObjetive());
        }
    }

    private void addOrEditFaction() {
        if (mode.getMode() == ModeAddEdit.ADD_MODE) {
            presenter.addFaction(new Faction(0, tID_FactionName.getText().toString(),
                    tID_FactionDescription.getText().toString(), selectedBook.getBookID()));
        }
        if (mode.getMode() == ModeAddEdit.EDIT_MODE) {
            presenter.editFaction(new Faction(editableFaction.getFactionID(),
                    tID_FactionName.getText().toString(),
                    tID_FactionDescription.getText().toString(),
                    editableFaction.getIDBook()));
        }

        callback.returnToList();
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            callback = (AddNewFactionClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must be implemented");
        }
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddEditFactionPresenter) presenter;
    }

    @Override
    public void onNameEmtpy() {
        Toast.makeText(getActivity(), getResources().getString(R.string.factionNameEmpty), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDescriptionEmpy() {
        Toast.makeText(getActivity(), getResources().getString(R.string.factionDescEmpty), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void doAddOrEdit() {
        addOrEditFaction();
    }

    public interface AddNewFactionClickListener
    {
        void returnToList();
    }
}
