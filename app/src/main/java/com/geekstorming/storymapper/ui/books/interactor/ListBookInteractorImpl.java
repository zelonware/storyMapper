package com.geekstorming.storymapper.ui.books.interactor;

import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.repos.BookRepository;

/**
 * Interactor implementation for listin books
 *  @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class ListBookInteractorImpl implements ListBookInteractor {

    OnLoadBooksListener listener;

    public ListBookInteractorImpl (OnLoadBooksListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void loadBooks() {
        listener.onSuccess(BookRepository.getInstance().getBooks());
    }

    @Override
    public void removeBook(Book b) {
        BookRepository.getInstance().removeBook(b);
        loadBooks();
    }
}
