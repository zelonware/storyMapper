package com.geekstorming.storymapper.data.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.geekstorming.storymapper.base.daos.CharacterDAO;
import com.geekstorming.storymapper.data.db.DBOpenHelper;
import com.geekstorming.storymapper.data.db.StoriesContract;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Character;

import java.util.ArrayList;

public class CharacterDAOImpl implements CharacterDAO {

    @Override
    public ArrayList<Character> loadAll(Book bookID) {
        ArrayList<Character> characterList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();
        Cursor cursor = sqLiteDatabase.query(StoriesContract.CharacterItem.TABLE,
                StoriesContract.CharacterItem.ALL_COLUMNS,
                StoriesContract.CharacterItem.BOOKID + " = ?",
                new String[] { Integer.toString(bookID.getBookID()) },
                null,null,
                StoriesContract.CharacterItem.DEFAULT_SORT, null);

        if (cursor.moveToFirst()) {

            do {
                Character tmp = new Character(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5));
                characterList.add(tmp);
                try {
                    Thread.sleep(350);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (cursor.moveToNext());
        }

        DBOpenHelper.getInstance().closeDB();

        return characterList;
    }

    @Override
    public long add(Character character) {
        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();

        ContentValues datosColumnas = createCharacterCV(character);

        long id = sqLiteDatabase.insert(StoriesContract.CharacterItem.TABLE, null, datosColumnas);

        DBOpenHelper.getInstance().closeDB();

        return id;
    }

    @Override
    public boolean exists(Character character) {
        return false;
    }

    @Override
    public long delete(Character character) {
        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();
        ContentValues datosColumnas = createCharacterCV(character);
        long id = sqLiteDatabase.update(StoriesContract.BookItem.TABLE, datosColumnas,
                StoriesContract.CharacterItem._ID + " = ?",
                new String[] {Integer.toString(character.getCharacterID())});

        DBOpenHelper.getInstance().closeDB();
        return id;
    }

    @Override
    public long update(Character character) {
        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();
        ContentValues datosColumnas = createCharacterCV(character);
        long id = sqLiteDatabase.update(StoriesContract.CharacterItem.TABLE, datosColumnas,
                StoriesContract.CharacterItem._ID + " = ?",
                new String[] {Integer.toString(character.getCharacterID())});

        DBOpenHelper.getInstance().closeDB();;
        return id;
    }

    private ContentValues createCharacterCV(Character c) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(StoriesContract.CharacterItem.NAME, c.getCharacterName());
        contentValues.put(StoriesContract.CharacterItem.DESCRIPTION, c.getCharacterDesc());
        contentValues.put(StoriesContract.CharacterItem.FACTION, c.getCharacterFaction());
        contentValues.put(StoriesContract.CharacterItem.HOME, c.getCharacterHome());
        contentValues.put(StoriesContract.CharacterItem.BOOKID, c.getCharacterBook());

        return contentValues;
    }
}
