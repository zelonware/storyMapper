package com.geekstorming.storymapper.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Book entity, creative project
 *
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

@Entity
public class Book implements Parcelable {

    // Atts

    @Id(autoincrement = true)
    Long bookID;
    @NotNull
    String bookTitle;
    String bookDesc;
    String bookGenre;
    int nWords;

    public static final String TAG = "Book";

    // Getters + Setters

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(@NotNull String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(@NotNull String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(@NotNull String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public int getnWords() {
        return nWords;
    }

    public void setnWords(@NotNull int nWords) {
        this.nWords = nWords;
    }

    // Constructor

    @Keep
    public Book(Long bookID, @NotNull String bookTitle, @NotNull String bookDesc, @NotNull String bookGenre, @NotNull int nWords) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookDesc = bookDesc;
        this.bookGenre = bookGenre;
        this.nWords = nWords;
    }

    protected Book(Parcel in) {
        this.bookID = in.readLong();
        this.bookTitle = in.readString();
        this.bookDesc = in.readString();
        this.bookGenre = in.readString();
        this.nWords = in.readInt();
    }

    @Generated(hash = 1839243756)
    public Book() {
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

    // Parcelable methods

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(bookID);
        dest.writeString(bookTitle);
        dest.writeString(bookDesc);
        dest.writeString(bookGenre);
        dest.writeInt(nWords);
    }

    public int getNWords() {
        return this.nWords;
    }

    public void setNWords(int nWords) {
        this.nWords = nWords;
    }
}
