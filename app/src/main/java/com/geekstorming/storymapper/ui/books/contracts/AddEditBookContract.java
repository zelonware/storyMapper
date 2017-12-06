package com.geekstorming.storymapper.ui.books.contracts;

import com.geekstorming.storymapper.base.BasePresenter;
import com.geekstorming.storymapper.base.BaseView;
import com.geekstorming.storymapper.data.pojo.Book;

/**
 * Created by napst on 06/12/2017.
 */

public interface AddEditBookContract {

    interface Presenter extends BasePresenter {
        void addNewBook(Book b);
        void updateBook(Book b);
        void validateBook(Book b);
    }

    interface View extends BaseView {

    }
}
