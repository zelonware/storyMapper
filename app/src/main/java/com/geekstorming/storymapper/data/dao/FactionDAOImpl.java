package com.geekstorming.storymapper.data.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.geekstorming.storymapper.base.daos.FactionDAO;
import com.geekstorming.storymapper.data.db.DBOpenHelper;
import com.geekstorming.storymapper.data.db.StoriesContract;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Faction;

import java.util.ArrayList;

public class FactionDAOImpl implements FactionDAO {
    @Override
    public ArrayList<Faction> loadAll(Book bookID) {
        ArrayList<Faction> factionList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();
        Cursor cursor = sqLiteDatabase.query(StoriesContract.ChapterItem.TABLE,
                StoriesContract.FactionItem.ALLCOLUMNS,
                StoriesContract.FactionItem.BOOKID + " = ?",
                new String[] { Integer.toString(bookID.getBookID()) },
                null,null,
                StoriesContract.FactionItem.DEFAULT_SORT, null);

        if (cursor.moveToFirst()) {

            do {
                Faction tmp = new Faction(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
                factionList.add(tmp);
                try {
                    Thread.sleep(350);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (cursor.moveToNext());
        }

        DBOpenHelper.getInstance().closeDB();

        return factionList;
    }

    @Override
    public long add(Faction faction) {
        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();

        ContentValues datosColumnas = creataFactionCV(faction);

        long id = sqLiteDatabase.insert(StoriesContract.FactionItem.TABLE, null, datosColumnas);

        DBOpenHelper.getInstance().closeDB();

        return id;
    }

    @Override
    public boolean exists(Faction faction) {
        return false;
    }

    @Override
    public long delete(Faction faction) {
        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();
        ContentValues datosColumnas = creataFactionCV(faction);
        long id = sqLiteDatabase.update(StoriesContract.FactionItem.TABLE, datosColumnas,
                StoriesContract.FactionItem._ID + " = ?",
                new String[] {Integer.toString(faction.getFactionID())});

        DBOpenHelper.getInstance().closeDB();;
        return id;
    }

    @Override
    public long update(Faction faction) {
        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();
        ContentValues datosColumnas = creataFactionCV(faction);
        long id = sqLiteDatabase.update(StoriesContract.FactionItem.TABLE, datosColumnas,
                StoriesContract.FactionItem._ID + " = ?",
                new String[] {Integer.toString(faction.getFactionID())});

        DBOpenHelper.getInstance().closeDB();;
        return id;
    }

    private ContentValues creataFactionCV (Faction f) {
        ContentValues cV = new ContentValues();

        cV.put(StoriesContract.FactionItem.NAME, f.getFactionName());
        cV.put(StoriesContract.FactionItem.OBJECTIVE, f.getFactionName());
        cV.put(StoriesContract.FactionItem.BOOKID, f.getIDBook());

        return cV;
    }
}
