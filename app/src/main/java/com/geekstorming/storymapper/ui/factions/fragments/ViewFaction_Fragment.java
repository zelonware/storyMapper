package com.geekstorming.storymapper.ui.factions.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.base.BaseFragment;
import com.geekstorming.storymapper.data.pojo.Faction;
import com.geekstorming.storymapper.utils.ModeAddEdit;

public class ViewFaction_Fragment extends BaseFragment {

    public static final String TAG = "Faction";

    private TextInputEditText tID_FactionName;
    private TextInputEditText tID_FactionDescription;
    private FloatingActionButton fab_FactionEdit;

    private static Faction editableFaction;

    ViewFactionClickListener callback;

    public static ViewFaction_Fragment newInstance(Bundle args) {
        ViewFaction_Fragment viewFaction_fragment = new ViewFaction_Fragment();

        if (args != null) {
            viewFaction_fragment.setArguments(args);
            editableFaction = (Faction) args.getParcelable(Faction.TAG);
        }

        return viewFaction_fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_faction_detail, container, false);

        tID_FactionName = (TextInputEditText) viewRoot.findViewById(R.id.tiD_FactionName);
        tID_FactionDescription = (TextInputEditText) viewRoot.findViewById(R.id.tiD_FactionDesc);

        fab_FactionEdit = (FloatingActionButton) viewRoot.findViewById(R.id.fab_editFaction);
        fab_FactionEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putParcelable(Faction.TAG, editableFaction);
                callback.editFaction(b, ModeAddEdit.EDIT_MODE);
            }
        });

        return viewRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tID_FactionDescription.setText(editableFaction.getFactionObjetive());
        tID_FactionName.setText(editableFaction.getFactionName());
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            callback = (ViewFactionClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must be implemented");
        }
    }

    public interface ViewFactionClickListener
    {
        void editFaction(Bundle b, int mode);
    }

}