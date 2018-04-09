package com.geekstorming.storymapper.ui.locations.fragments;

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
import com.geekstorming.storymapper.data.pojo.Location;
import com.geekstorming.storymapper.utils.ModeAddEdit;

public class ViewLocation_Fragment extends BaseFragment {

    public static final String TAG = "Location";

    private TextInputEditText tID_LocationName;
    private TextInputEditText tID_LocationDescription;
    private FloatingActionButton fab_LocationEdit;

    private static Location editableLocation;

    ViewLocationClickListener callback;

    public static ViewLocation_Fragment newInstance(Bundle args) {
        ViewLocation_Fragment viewLocation_fragment = new ViewLocation_Fragment();

        if (args != null) {
            viewLocation_fragment.setArguments(args);
            editableLocation = (Location) args.getParcelable(Location.TAG);
        }

        return viewLocation_fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_location_detail, container, false);

        tID_LocationName = (TextInputEditText) viewRoot.findViewById(R.id.tiD_LocationName);
        tID_LocationDescription = (TextInputEditText) viewRoot.findViewById(R.id.tiD_LocationDesc);

        fab_LocationEdit = (FloatingActionButton) viewRoot.findViewById(R.id.fab_editLocation);
        fab_LocationEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putParcelable(Location.TAG, editableLocation);
                callback.editLocation(b, ModeAddEdit.EDIT_MODE);
            }
        });

        return viewRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tID_LocationDescription.setText(editableLocation.getLocationDesc());
        tID_LocationName.setText(editableLocation.getLocationName());
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            callback = (ViewLocationClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must be implemented");
        }
    }

    public interface ViewLocationClickListener
    {
        void editLocation(Bundle b, int mode);
    }

}