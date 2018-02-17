package com.geekstorming.storymapper.ui.books.interactor;

import android.os.AsyncTask;

import com.geekstorming.storymapper.data.db.InteractorCallback;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.repos.BookRepository;

import java.util.List;

/**
 * Interactor implementation for listin books
 *  @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class ListBookInteractorImpl implements ListBookInteractor, InteractorCallback {

    OnLoadFinishedListener listener;

    public ListBookInteractorImpl (OnLoadFinishedListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void loadBooks() {
        new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                listener.onSuccess(BookRepository.getInstance().getBooks());
                return null;
            }
        }.execute();
    }

    @Override
    public void removeBook(Book b) {
        BookRepository.getInstance().removeBook(b);
        loadBooks();
    }

    @Override
    public void onError(Error error) {
        listener.onDatabaseError(error);
    }

    @Override
    public void onError(Exception exception) {
        listener.onDatabaseError(exception);
    }

    @Override
    public void onSuccess() {
        loadBooks();
    }

    public interface OnLoadFinishedListener {
        void onSuccess(List<Book> list);

        void onDatabaseError(Error error);

        void onDatabaseError(Exception exception);
    }
}
