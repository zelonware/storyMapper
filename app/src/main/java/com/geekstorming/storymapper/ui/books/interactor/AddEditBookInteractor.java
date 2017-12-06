package com.geekstorming.storymapper.ui.books.interactor;

import com.geekstorming.storymapper.data.pojo.Book;

/**
 * Interactor for add or edit books
 *  @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public interface AddEditBookInteractor {

    void validateBook(String title, String desc, String genre, OnBookAddingListener oBAL);
    void addingBook(Book b);
    void updateBook(Book b);

    interface OnBookAddingListener {

        void onTitleEmpty();
        void onDescEmpty();
        void onGenreEmpty();
        void onSuccess();
    }
}
