package com.geekstorming.storymapper.data.repos;

import com.geekstorming.storymapper.data.dao.BookDAOImpl;
import com.geekstorming.storymapper.data.pojo.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Books repository, book list
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class BookRepository {

    // Atts
    private ArrayList<Book> books;
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

    private void initializeBooks(){

        addBook(new Book(1, "Ocaso: Imperio", "Como mola mi libro", "Ciencia ficcion", 30000));
        addBook(new Book(2, "Llegaron del cielo", "Terror y ciencia ficcion","Ciencia ficcion", 20000));
        addBook(new Book(3, "La espiral", "Una locura de fantasía urbana","Fantasía urbana", 23000));
        addBook(new Book(4, "Crónicas de Argonath", "Un libro de fantasia","Fantasía", 50000));
    }

    public void addBook(Book b)
    {
        bookDAO.add(b);
    }

    public void removeBook(Book b) {
        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getBookID() == b.getBookID()) {
                iterator.remove();
                break;
            }
        }
    }

    public ArrayList<Book> getBooks() {
        ArrayList<Book> books = bookDAO.loadAll();
        return books;
    }

    public static BookRepository getInstance()
    {
        return bookRepository;
    }

    public void editBook (Book b)
    {
        for (Book currentBook : books)
        {
            if (currentBook.getBookID() == b.getBookID())
            {
                currentBook.setBookTitle(b.getBookTitle());
                currentBook.setBookDesc(b.getBookDesc());
                currentBook.setnWords(b.getnWords());
                currentBook.setBookGenre(b.getBookGenre());
            }
        }
    }
}
