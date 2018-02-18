package com.geekstorming.storymapper.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.data.repos.CharacterRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

/**
 * Character Adapter
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>  {

    private ArrayList<Character> characters;

    OnItemClickListener listenerCharacterClicked;

    public CharacterAdapter(OnItemClickListener listenerClick)
    {
        characters = CharacterRepository.getInstance().getCharacters();
        this.listenerCharacterClicked = listenerClick;
    }

    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflador = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflador.inflate(R.layout.item_character, null);

        CharacterViewHolder characterViewHolder = new CharacterViewHolder(view);
        return characterViewHolder;
    }

    @Override
    public void onBindViewHolder(CharacterViewHolder holder, int position) {
        holder.txtV_CharacterName.setText(characters.get(position).getCharacterName());
        holder.txtV_CharacterFaction.setText(Integer.toString(characters.get(position).getCharacterFaction()));
        holder.icon_Character.setLetter(characters.get(position).getCharacterName().substring(0, 1));

        holder.bind(characters.get(position), this.listenerCharacterClicked);
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public static class CharacterViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        private TextView txtV_CharacterName;
        private TextView txtV_CharacterFaction;
        private MaterialLetterIcon icon_Character;

        public CharacterViewHolder (View itemView)
        {
            super(itemView);

            icon_Character = (MaterialLetterIcon) itemView.findViewById(R.id.iconCharacter);
            txtV_CharacterFaction = (TextView) itemView.findViewById(R.id.txtV_CharacterFaction);
            txtV_CharacterName = (TextView) itemView.findViewById(R.id.txtV_CharacterName);

            // WIP Context menu on RecyclerV
        }

        public void bind(final Character c, final OnItemClickListener listener)
        {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onCharacterClick(c);
                }
            });
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            // WIP Context menu on RecyclerV
        }
    }

    public Character getItem(int position) {
        return characters.get(position);
    }

    public interface OnItemClickListener {
        void onCharacterClick (Character c);
    }
}
