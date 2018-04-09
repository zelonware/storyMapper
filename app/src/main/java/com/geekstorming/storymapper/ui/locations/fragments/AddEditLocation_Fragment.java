package com.geekstorming.storymapper.ui.locations.fragments;

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
import com.geekstorming.storymapper.data.pojo.Location;
import com.geekstorming.storymapper.ui.locations.contracts.AddEditLocationContract;
import com.geekstorming.storymapper.ui.locations.presenter.AddEditLocationPresenter;
import com.geekstorming.storymapper.utils.ModeAddEdit;

/**
 * Adding new location
 *
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */
public class AddEditLocation_Fragment extends BaseFragment implements AddEditLocationContract.View {

    public static final String TAG = "addeditLocation";

    private TextInputEditText tID_LocationName;
    private TextInputEditText tID_LocationDescription;
    private FloatingActionButton fab_LocationDone;

    AddEditLocationPresenter presenter;

    static ModeAddEdit mode;

    private static Location editableLocation;
    private static Book selectedBook;

    AddNewLocationClickListener callback;

    public static AddEditLocation_Fragment newInstance(Bundle args, int selectedMode) {
        AddEditLocation_Fragment addEditLocation_fragment = new AddEditLocation_Fragment();
        mode = new ModeAddEdit(ModeAddEdit.ADD_MODE);

        if (args != null) {
            if (selectedMode == ModeAddEdit.EDIT_MODE) {
                addEditLocation_fragment.setArguments(args);
                editableLocation = (Location) args.getParcelable(Location.TAG);
            }
            else {
                selectedBook = (Book) args.getParcelable(Book.TAG);
            }

            mode.setMode(selectedMode);
        }

        return addEditLocation_fragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_location_add, container, false);

        presenter = new AddEditLocationPresenter(this);

        tID_LocationName = (TextInputEditText) viewRoot.findViewById(R.id.tiD_LocationName);
        tID_LocationDescription = (TextInputEditText) viewRoot.findViewById(R.id.tiD_LocationDesc);

        fab_LocationDone = (FloatingActionButton) viewRoot.findViewById(R.id.fab_LocationDone);
        fab_LocationDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.validateLocationData(tID_LocationName.getText().toString(),
                        tID_LocationDescription.getText().toString());
            }
        });

        return viewRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (mode.getMode() == ModeAddEdit.EDIT_MODE)
        {
            tID_LocationName.setText(editableLocation.getLocationName());
            tID_LocationDescription.setText(editableLocation.getLocationDesc());
        }
    }

    private void addOrEditLocation() {
        if (mode.getMode() == ModeAddEdit.ADD_MODE) {
            presenter.addLocation(new Location(0, tID_LocationName.getText().toString(),
                    tID_LocationDescription.getText().toString(), selectedBook.getBookID()));
        }
        if (mode.getMode() == ModeAddEdit.EDIT_MODE) {
            presenter.editLocation(new Location(editableLocation.getLocationID(),
                    tID_LocationName.getText().toString(),
                    tID_LocationDescription.getText().toString(),
                    editableLocation.getIDBook()));
        }

        callback.returnToList();
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            callback = (AddNewLocationClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must be implemented");
        }
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddEditLocationPresenter) presenter;
    }

    @Override
    public void onNameEmtpy() {
        Toast.makeText(getActivity(), getResources().getString(R.string.locationNameEmpty), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDescriptionEmpy() {
        Toast.makeText(getActivity(), getResources().getString(R.string.locationDescEmpty), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void doAddOrEdit() {
        addOrEditLocation();
    }

    public interface AddNewLocationClickListener
    {
        void returnToList();
    }
}
