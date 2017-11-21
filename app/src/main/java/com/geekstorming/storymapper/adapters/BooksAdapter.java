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
import com.geekstorming.storymapper.data.repos.BookRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * Books Adapter
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class BooksAdapter extends ArrayAdapter<Book> {

    public BooksAdapter(@NonNull Context context) {
        super(context, R.layout.item_books, BookRepository.getInstance().getBooks());
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

            view.setTag(bookHolder);
        }
        else {
            bookHolder = (BookHolder) view.getTag();
        }

        bookHolder.txtV_BookName.setText(getItem(position).getBookTitle());
        bookHolder.txtV_BookGenre.setText(getItem(position).getBookGenre());
        bookHolder.bookIcon.setLetter(getItem(position).getBookTitle().substring(0, 1));

        return view;

    }

    class BookHolder {

        MaterialLetterIcon bookIcon;
        TextView txtV_BookName;
        TextView txtV_BookGenre;
        //TextView txtV_nWords;
    }
}
