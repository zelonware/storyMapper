package com.geekstorming.storymapper.data.repos;

import com.geekstorming.storymapper.data.dao.BookDAO;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.utils.App;

import java.util.ArrayList;

/**
 * Books repository, book list
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class BookRepository {

    // Atts
    private ArrayList<Book> books;
    private static BookRepository bookRepository;

    private BookDAO bookDAO;

    // Constructor
    static {
        bookRepository = new BookRepository();
    }

    private BookRepository()
    {
        books = new ArrayList<>();
        bookDAO = App.getInstances().getDaoSession().getBookDAO();
    }

    // Methods

    public void addBook(Book b)
    {
        bookDAO.insert(b);
    }

    public void removeBook(Book b) {
        bookDAO.delete(b);
    }

    public ArrayList<Book> getBooks() {
       books = (ArrayList<Book>) bookDAO.loadAll();
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
