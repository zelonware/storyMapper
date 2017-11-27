package com.geekstorming.storymapper.ui.books.interactor;

import com.geekstorming.storymapper.data.repos.BookRepository;

/**
 * Created by Beelzenef on 27/11/2017.
 */

public class ListBookInteractorImpl implements ListBookInteractor {

    OnLoadBooksListener listener;

    public ListBookInteractorImpl (OnLoadBooksListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void loadBooks() {
        listener.onSucess(BookRepository.getInstance().getBooks());
    }
}
