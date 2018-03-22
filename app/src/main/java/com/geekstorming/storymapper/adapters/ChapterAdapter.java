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
import com.geekstorming.storymapper.data.pojo.Chapter;
import com.geekstorming.storymapper.data.repos.ChapterRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

public class ChapterAdapter extends ArrayAdapter<Chapter> {

    public ChapterAdapter(@NonNull Context context, Book book) {
        super(context, R.layout.item_chapter, ChapterRepository.getInstance().getChapters(book));
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        FactionHolder factionHolder;
        View view = convertView;

        if (view == null) {
            LayoutInflater inflador = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // Inflate views
            view = inflador.inflate(R.layout.item_chapter, null);
            factionHolder = new FactionHolder();

            // Get views from layout
            factionHolder.txtV_ChapterName = (TextView) view.findViewById(R.id.txtV_ChapterName);
            factionHolder.ChapterIcon = (MaterialLetterIcon) view.findViewById(R.id.materialLetterIcon);

            view.setTag(factionHolder);
        }
        else {
            factionHolder = (FactionHolder) view.getTag();
        }

        factionHolder.txtV_ChapterName.setText(getItem(position).getChapterName());
        factionHolder.ChapterIcon.setLetter(getItem(position).getChapterName().substring(0, 1));

        return view;

    }

    class FactionHolder {
        MaterialLetterIcon ChapterIcon;
        TextView txtV_ChapterName;
    }
}