package com.geekstorming.storymapper.pojo;

import android.support.annotation.NonNull;

/**
 * Book entity, creative project
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class Book implements Comparable {

    // Atts

    int bookID;
    String bookTitle;
    String bookGenre;
    int nWords;

    // Getters + Setters

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public int getnWords() {
        return nWords;
    }

    public void setnWords(int nWords) {
        this.nWords = nWords;
    }

    // Constructor

    public Book(int bookID, String bookTitle, String bookGenre, int nWords) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookGenre = bookGenre;
        this.nWords = nWords;
    }

    // toString()

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookGenre='" + bookGenre + '\'' +
                ", nWords=" + nWords +
                '}';
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return bookTitle.compareTo(((Book)o).getBookTitle());
    }
}
