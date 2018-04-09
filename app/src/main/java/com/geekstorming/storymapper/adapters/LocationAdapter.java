package com.geekstorming.storymapper.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Location;
import com.geekstorming.storymapper.data.repos.LocationRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * Location Adapter
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class LocationAdapter extends ArrayAdapter<Location> {

    public LocationAdapter(@NonNull Context context, Book book) {
        super(context, R.layout.item_location, LocationRepository.getInstance().getLocations(book));
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LocationHolder locationHolder;
        View view = convertView;

        if (view == null) {
            LayoutInflater inflador = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // Inflate views
            view = inflador.inflate(R.layout.item_location, null);
            locationHolder = new LocationHolder();

            // Get views from layout
            locationHolder.txtV_LocationName = (TextView) view.findViewById(R.id.txtV_LocationName);
            locationHolder.locationIcon = (MaterialLetterIcon) view.findViewById(R.id.materialLetterIcon);

            view.setTag(locationHolder);
        }
        else {
            locationHolder = (LocationHolder) view.getTag();
        }

        locationHolder.txtV_LocationName.setText(getItem(position).getLocationName());
        locationHolder.locationIcon.setLetter(getItem(position).getLocationName().substring(0, 1));

        return view;

    }

    class LocationHolder {
        MaterialLetterIcon locationIcon;
        TextView txtV_LocationName;
    }
}
