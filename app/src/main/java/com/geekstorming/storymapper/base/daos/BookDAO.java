package com.geekstorming.storymapper.base.daos;

import com.geekstorming.storymapper.data.pojo.Book;

import java.util.ArrayList;

/**
 * Book DAO interface
 */

public interface BookDAO {
    ArrayList<Book> loadAll();
    long add(Book book);
    boolean exists(Book book);
    long delete (Book book);
    long update(Book book);
}
