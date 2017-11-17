package com.geekstorming.storymapper.data.repos;

import com.geekstorming.storymapper.data.pojo.Book;

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

        addBook(new Book(1, "Ocaso: Imperio", "Como mola mi libro", "Ciencia ficcion", 30000));
        addBook(new Book(2, "Llegaron del cielo", "Terror y ciencia ficcion","Ciencia ficcion", 20000));
        addBook(new Book(3, "La espiral", "Una locura de fantasía urbana","Fantasía urbana", 23000));
        addBook(new Book(4, "Crónicas de Argonath", "Un libro de fantasia","Fantasía", 50000));
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
