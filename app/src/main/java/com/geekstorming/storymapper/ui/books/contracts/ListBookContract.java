package com.geekstorming.storymapper.ui.books.contracts;

import com.geekstorming.storymapper.base.BasePresenter;
import com.geekstorming.storymapper.base.BaseView;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.BookComponents;
import com.geekstorming.storymapper.data.pojo.User;

import java.util.List;

/**
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public interface ListBookContract {

    interface View extends BaseView {
        void showBooks(List<BookComponents> bookList);

        void onDatabaseError(Error error);
        void onDatabaseError(Exception exception);
        void showProgressDialog(String message);
        void dismissProgressDialog();
    }

    interface Presenter extends BasePresenter {
        void loadBooks(User loggedUser);
        void removeBook(Book b);
    }
}
