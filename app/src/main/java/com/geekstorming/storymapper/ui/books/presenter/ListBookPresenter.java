package com.geekstorming.storymapper.ui.books.presenter;

import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.ui.books.contracts.ListBookContract;
import com.geekstorming.storymapper.ui.books.interactor.ListBookInteractor;
import com.geekstorming.storymapper.ui.books.interactor.ListBookInteractorImpl;

import java.util.List;

/**
 *  List book presenter, intermediary for interactor and view
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class ListBookPresenter implements ListBookContract.Presenter, ListBookInteractorImpl.OnLoadFinishedListener {

    ListBookContract.View view;
    ListBookInteractorImpl interactor;

    public ListBookPresenter(ListBookContract.View v)
    {
        this.view = v;
        this.interactor = new ListBookInteractorImpl(this);
    }

    @Override
    public void onSuccess(List<Book> list) {
        view.dismissProgressDialog();
        view.showBooks(list);
    }

    @Override
    public void onDatabaseError(Error error) {
        view.onDatabaseError(error);
    }

    @Override
    public void onDatabaseError(Exception exception) {
        view.onDatabaseError(exception);
    }

    @Override
    public void loadBooks() {
        interactor.loadBooks();
    }

    @Override
    public void removeBook(Book b) {
        interactor.removeBook(b);
    }
}
