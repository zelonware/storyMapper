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
import com.geekstorming.storymapper.data.pojo.Faction;
import com.geekstorming.storymapper.data.repos.FactionRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * Faction Adapter
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class FactionAdapter extends ArrayAdapter<Faction> {

    public FactionAdapter(@NonNull Context context) {
        super(context, R.layout.item_faction, FactionRepository.getInstance().getFactions());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        FactionHolder factionHolder;
        View view = convertView;

        if (view == null) {
            LayoutInflater inflador = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // Inflate views
            view = inflador.inflate(R.layout.item_faction, null);
            factionHolder = new FactionHolder();

            // Get views from layout
            factionHolder.txtV_FactionName = (TextView) view.findViewById(R.id.txtV_FactionName);
            factionHolder.FactionIcon = (MaterialLetterIcon) view.findViewById(R.id.materialLetterIcon);

            view.setTag(factionHolder);
        }
        else {
            factionHolder = (FactionHolder) view.getTag();
        }

        factionHolder.txtV_FactionName.setText(getItem(position).getFactionName());
        factionHolder.FactionIcon.setLetter(getItem(position).getFactionName().substring(0, 1));

        return view;

    }

    class FactionHolder {
        MaterialLetterIcon FactionIcon;
        TextView txtV_FactionName;
    }
}
