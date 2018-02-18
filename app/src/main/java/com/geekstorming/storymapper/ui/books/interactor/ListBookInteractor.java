package com.geekstorming.storymapper.ui.books.interactor;

import com.geekstorming.storymapper.data.pojo.Book;

import java.util.List;

/**
 * Interactor list book
 *  @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public interface ListBookInteractor {

    void loadBooks();
    void removeBook(Book b);
}
