package com.geekstorming.storymapper.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Book entity, creative project
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class Book implements Parcelable, Comparable {

    // Atts

    int bookID;
    String bookTitle;
    String bookDesc;
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

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
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

    public Book(int bookID, String bookTitle, String bookDesc, String bookGenre, int nWords) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookDesc = bookDesc;
        this.bookGenre = bookGenre;
        this.nWords = nWords;
    }

    protected Book(Parcel in)
    {
        this.bookID = in.readInt();
        this.bookTitle = in.readString();
        this.bookDesc = in.readString();
        this.bookGenre = in.readString();
        this.nWords = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

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

    // Parcelable methods

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(bookID);
        dest.writeString(bookTitle);
        dest.writeString(bookDesc);
        dest.writeString(bookGenre);
        dest.writeInt(nWords);
    }
}
