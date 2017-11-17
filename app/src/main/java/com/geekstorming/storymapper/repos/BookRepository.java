package com.geekstorming.storymapper.repos;

import com.geekstorming.storymapper.pojo.Book;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Books repository, book list
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class BookRepository {

    // Atts
    private ArrayList<Book> books;
    private static BookRepository bookRepository;

    // Constructor
    static {
        bookRepository = new BookRepository();
    }

    private BookRepository()
    {
        books = new ArrayList<>();
        initializeBooks();
    }

    // Methods

    private void initializeBooks(){

        addBook(new Book(1, "Ocaso: Imperio", "Ciencia ficcion", 30000));
        addBook(new Book(2, "Llegaron del cielo", "Ciencia ficcion", 20000));
        addBook(new Book(3, "La espiral", "Fantasía urbana", 23000));
        addBook(new Book(4, "Crónicas de Argonath", "Fantasía", 50000));
    }

    public void addBook(Book b)
    {
        books.add(b);
    }

    public ArrayList<Book> getBooks() {
        Collections.sort(books);
        return books;
    }

    public static BookRepository getInstance()
    {
        return bookRepository;
    }
}
