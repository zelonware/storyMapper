package com.geekstorming.storymapper.ui.books.contracts;

import com.geekstorming.storymapper.base.BasePresenter;
import com.geekstorming.storymapper.base.BaseView;
import com.geekstorming.storymapper.data.pojo.Book;

import java.util.List;

/**
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public interface ListBookContract {

    interface View extends BaseView {
        void showBooks(List<Book> bookList);
    }

    interface Presenter extends BasePresenter {
        void loadBooks();
    }
}
