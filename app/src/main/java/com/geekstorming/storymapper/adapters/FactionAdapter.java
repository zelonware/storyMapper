package com.geekstorming.storymapper.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.geekstorming.storymapper.data.pojo.Faction;
import com.geekstorming.storymapper.data.repos.FactionRepository;

/**
 * Faction Adapter
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class FactionAdapter extends ArrayAdapter<Faction> {

    public FactionAdapter(@NonNull Context context) {
        super(context, android.R.layout.simple_spinner_dropdown_item,
                FactionRepository.getInstance().getFactions());
    }
}
