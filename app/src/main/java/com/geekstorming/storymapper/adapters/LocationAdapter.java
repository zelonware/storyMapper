package com.geekstorming.storymapper.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.geekstorming.storymapper.data.pojo.Location;
import com.geekstorming.storymapper.data.repos.LocationRepository;

/**
 * Location Adapter
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class LocationAdapter extends ArrayAdapter<Location> {

    public LocationAdapter(@NonNull Context context) {
        super(context, android.R.layout.simple_spinner_dropdown_item,
                LocationRepository.getInstance().getLocations());
    }
}
