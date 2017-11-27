package com.geekstorming.storymapper.ui.books.presenter;

import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.ui.books.contracts.ListBookContract;
import com.geekstorming.storymapper.ui.books.interactor.ListBookInteractor;
import com.geekstorming.storymapper.ui.books.interactor.ListBookInteractorImpl;

import java.util.List;

/**
 * Created by Beelzenef on 27/11/2017.
 */

public class ListBookPresenter implements ListBookContract.Presenter, ListBookInteractorImpl.OnLoadBooksListener {

    ListBookContract.View view;
    ListBookInteractorImpl interactor;

    public ListBookPresenter(ListBookContract.View v)
    {
        this.view = v;
        this.interactor = new ListBookInteractorImpl(this);
    }

    @Override
    public void onSucess(List<Book> list) {
        view.showBooks(list);
    }

    @Override
    public void loadBooks() {
        interactor.loadBooks();
    }
}
