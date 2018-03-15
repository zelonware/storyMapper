package com.geekstorming.storymapper.data.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.geekstorming.storymapper.base.daos.BookDAO;
import com.geekstorming.storymapper.data.db.DBOpenHelper;
import com.geekstorming.storymapper.data.db.StoriesContract;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.BookComponents;
import com.geekstorming.storymapper.data.pojo.Chapter;
import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.data.pojo.Faction;
import com.geekstorming.storymapper.data.pojo.User;

import java.util.ArrayList;

/**
 * DAO implementation for books
 */

public class BookDAOImpl implements BookDAO {

    @Override
    public ArrayList<BookComponents> loadAll(User loggedUser) {
        ArrayList<BookComponents> bookList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();
        Cursor cursor = sqLiteDatabase.query(StoriesContract.BookItem.TABLE,
                StoriesContract.BookItem.ALL_COLUMNS,
                StoriesContract.BookItem.USER + " = ?",
                new String[]{Integer.toString(loggedUser.getId())},
                null, null,
                StoriesContract.BookItem.DEFAULT_SORT, null);

        if (cursor.moveToFirst()) {

            do {
                BookComponents tmp = new BookComponents(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4), cursor.getInt(5));

                tmp.setChapters(getChaptersFromBook(tmp));
                tmp.setFactions(getFactionFromBook(tmp));
                tmp.setCharacters(getCharactersFromBook(tmp));

                bookList.add(tmp);
                try {
                    Thread.sleep(350);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (cursor.moveToNext());
        }

        DBOpenHelper.getInstance().closeDB();

        return bookList;
    }

    public ArrayList<Chapter> getChaptersFromBook(BookComponents book) {

        ArrayList<Chapter> chapters = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();
        Cursor cursor = sqLiteDatabase.query(StoriesContract.CharacterItem.TABLE,
                StoriesContract.CharacterItem.ALL_COLUMNS,
                StoriesContract.CharacterItem.BOOKID + " = ?",
                new String[] { Integer.toString(book.getBookID())},
                null, null,
                StoriesContract.CharacterItem.DEFAULT_SORT, null);

        if (cursor.moveToFirst()) {

            do {
                Chapter tmp = new Chapter(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
                chapters.add(tmp);
                try {
                    Thread.sleep(350);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (cursor.moveToNext());
        }

        DBOpenHelper.getInstance().closeDB();

        return chapters;
    }

    public ArrayList<Character> getCharactersFromBook(BookComponents book) {

        ArrayList<Character> characters = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();
        Cursor cursor = sqLiteDatabase.query(StoriesContract.CharacterItem.TABLE,
                StoriesContract.CharacterItem.ALL_COLUMNS,
                StoriesContract.CharacterItem.BOOKID + " = ?",
                new String[] { Integer.toString(book.getBookID())},
                null, null,
                StoriesContract.CharacterItem.DEFAULT_SORT, null);

        if (cursor.moveToFirst()) {

            do {
                Character tmp = new Character(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5));
                characters.add(tmp);
                try {
                    Thread.sleep(350);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (cursor.moveToNext());
        }

        DBOpenHelper.getInstance().closeDB();

        return characters;
    }

    public ArrayList<Faction> getFactionFromBook(BookComponents book) {

        ArrayList<Faction> factions = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();
        Cursor cursor = sqLiteDatabase.query(StoriesContract.CharacterItem.TABLE,
                StoriesContract.CharacterItem.ALL_COLUMNS,
                StoriesContract.CharacterItem.BOOKID + " = ?",
                new String[] { Integer.toString(book.getBookID())},
                null, null,
                StoriesContract.CharacterItem.DEFAULT_SORT, null);

        if (cursor.moveToFirst()) {

            do {
                Faction tmp = new Faction(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
                factions.add(tmp);
                try {
                    Thread.sleep(350);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (cursor.moveToNext());
        }

        DBOpenHelper.getInstance().closeDB();

        return factions;
    }

    @Override
    public long add(Book book) {
        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();

        ContentValues datosColumnas = createBookCV(book);

        long id = sqLiteDatabase.insert(StoriesContract.BookItem.TABLE, null, datosColumnas);

        DBOpenHelper.getInstance().closeDB();

        return id;
    }

    @Override
    public boolean exists(Book book) {
        return false;
    }

    @Override
    public long delete(Book book) {
        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();
        ContentValues datosColumnas = createBookCV(book);
        long id = sqLiteDatabase.delete(StoriesContract.BookItem.TABLE,
                StoriesContract.BookItem._ID + " = ?",
                new String[]{Integer.toString(book.getBookID())});

        DBOpenHelper.getInstance().closeDB();
        return id;

    }

    @Override
    public long update(Book book) {
        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();
        ContentValues datosColumnas = createBookCV(book);
        long id = sqLiteDatabase.update(StoriesContract.BookItem.TABLE, datosColumnas,
                StoriesContract.BookItem._ID + " = ?",
                new String[]{Integer.toString(book.getBookID())});

        DBOpenHelper.getInstance().closeDB();
        ;
        return id;
    }

    private ContentValues createBookCV(Book b) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(StoriesContract.BookItem.TITLE, b.getBookTitle());
        contentValues.put(StoriesContract.BookItem.DESCRIPTION, b.getBookDesc());
        contentValues.put(StoriesContract.BookItem.GENRE, b.getBookGenre());
        contentValues.put(StoriesContract.BookItem.NWORDS, b.getnWords());
        contentValues.put(StoriesContract.BookItem.USER, b.getUser());

        return contentValues;
    }
}
