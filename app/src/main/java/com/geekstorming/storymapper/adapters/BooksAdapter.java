package com.geekstorming.storymapper.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.BookComponents;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Books Adapter
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class BooksAdapter extends ArrayAdapter<BookComponents> {

    public BooksAdapter(@NonNull Context context) {
        super(context, R.layout.item_books, new ArrayList<BookComponents>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        BookHolder bookHolder;
        View view = convertView;

        if (view == null) {
            LayoutInflater inflador = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // Inflate views
            view = inflador.inflate(R.layout.item_books, null);
            bookHolder = new BookHolder();

            // Get views from layout
            bookHolder.txtV_BookName = (TextView) view.findViewById(R.id.txtV_LocationName);
            bookHolder.txtV_BookGenre = (TextView) view.findViewById(R.id.txtV_BookGenre);
            bookHolder.bookIcon = (MaterialLetterIcon) view.findViewById(R.id.materialLetterIcon);
            bookHolder.prgB_nWords = (ProgressBar) view.findViewById(R.id.progressBar);
            bookHolder.txtV_nChapters = (TextView) view.findViewById(R.id.txtV_NChapters);
            bookHolder.txtV_nCharacters = (TextView) view.findViewById(R.id.txtV_NCharacters);
            bookHolder.txtV_nFactions = (TextView) view.findViewById(R.id.txtV_NFactions);

            view.setTag(bookHolder);
        }
        else {
            bookHolder = (BookHolder) view.getTag();
        }

        bookHolder.txtV_BookName.setText(getItem(position).getBookTitle());
        bookHolder.txtV_BookGenre.setText(getItem(position).getBookGenre());
        bookHolder.bookIcon.setLetter(getItem(position).getBookTitle().substring(0, 1));

        bookHolder.prgB_nWords.setMax(getItem(position).getnWords());
        bookHolder.prgB_nWords.setProgress(getItem(position).getCurrentWords());

        bookHolder.txtV_nChapters.setText(Integer.toString(getItem(position).getChapters().size()));
        bookHolder.txtV_nFactions.setText(Integer.toString(getItem(position).getFactions().size()));
        bookHolder.txtV_nCharacters.setText(Integer.toString(getItem(position).getCharacters().size()));

        return view;

    }

    class BookHolder {

        MaterialLetterIcon bookIcon;
        TextView txtV_BookName;
        TextView txtV_BookGenre;
        ProgressBar prgB_nWords;

        TextView txtV_nCharacters;
        TextView txtV_nChapters;
        TextView txtV_nFactions;
    }
}
