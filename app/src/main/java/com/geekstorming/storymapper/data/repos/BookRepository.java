package com.geekstorming.storymapper.data.repos;

import com.geekstorming.storymapper.data.dao.BookDAOImpl;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.BookComponents;
import com.geekstorming.storymapper.data.pojo.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Books repository, book list
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class BookRepository {

    // Atts
    private ArrayList<BookComponents> books;
    private static BookRepository bookRepository;

    private BookDAOImpl bookDAO;

    private boolean loadedData;

    // Constructor
    static {
        bookRepository = new BookRepository();
    }

    private BookRepository()
    {
       this.bookDAO = new BookDAOImpl();
       this.loadedData = false;
    }

    // Methods

    public void addBook(Book b)
    {
        bookDAO.add(b);
    }

    public void removeBook(Book b) {
        bookDAO.delete(b);
    }

    public ArrayList<BookComponents> getBooks(User loggedUser) {
        ArrayList<BookComponents> books = bookDAO.loadAll(loggedUser);
        return books;
    }

    public static BookRepository getInstance()
    {
        return bookRepository;
    }

    public void editBook (Book b)
    {
        bookDAO.update(b);
    }
}
