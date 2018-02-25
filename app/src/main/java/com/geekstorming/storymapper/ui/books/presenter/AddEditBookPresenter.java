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
        interactor = new AddEditBookInteractorImpl(this);
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
    public void validateBook(String title, String desc, String words) {
        interactor.validateBook(title, desc, words);
    }

    @Override
    public void onTitleEmpty() {
        view.onEmptyTitle();
    }

    @Override
    public void onDescEmpty() {
        view.onEmptyDesc();
    }

    @Override
    public void onGenreEmpty() {
        view.onEmptyGenero();
    }

    @Override
    public void onNWordsEmpty() {
        view.onEmptyWords();
    }

    @Override
    public void onSuccess() {
        view.doAddOrEdit();
    }
}
