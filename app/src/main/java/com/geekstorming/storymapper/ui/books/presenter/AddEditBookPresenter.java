package com.geekstorming.storymapper.ui.books.presenter;

import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.ui.books.contracts.AddEditBookContract;
import com.geekstorming.storymapper.ui.books.interactor.AddEditBookInteractorImpl;

/**
 * Add or edit book presenter, intermediary for interactor and view
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class AddEditBookPresenter implements AddEditBookContract.Presenter, AddEditBookInteractorImpl.OnBookAddingListener {

    AddEditBookContract.View view;
    AddEditBookInteractorImpl interactor;

    public AddEditBookPresenter (AddEditBookContract.View v)
    {
        this.view = v;
        interactor = new AddEditBookInteractorImpl();
    }

    @Override
    public void addNewBook(Book b) {
        interactor.addingBook(b);
    }

    @Override
    public void updateBook(Book b) {
        interactor.updateBook(b);
    }

    @Override
    public void validateBook(Book b) {
        interactor.validateBook(b.getBookTitle(), b.getBookDesc(), b.getBookGenre(), this);
    }

    @Override
    public void onTitleEmpty() {

    }

    @Override
    public void onDescEmpty() {

    }

    @Override
    public void onGenreEmpty() {

    }

    @Override
    public void onSuccess() {

    }
}
