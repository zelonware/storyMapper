package com.geekstorming.storymapper.data.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.geekstorming.storymapper.base.daos.LocationDAO;
import com.geekstorming.storymapper.data.db.DBOpenHelper;
import com.geekstorming.storymapper.data.db.StoriesContract;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Location;

import java.util.ArrayList;

public class LocationDAOImpl implements LocationDAO {
    @Override
    public ArrayList<Location> loadAll(Book bookID) {
        ArrayList<Location> locationList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();
        Cursor cursor = sqLiteDatabase.query(StoriesContract.ChapterItem.TABLE,
                StoriesContract.LocationItem.ALLCOLUMNS,
                StoriesContract.LocationItem.BOOKID + " = ?",
                new String[] { Integer.toString(bookID.getBookID()) },
                null,null,
                StoriesContract.LocationItem.DEFAULT_SORT, null);

        if (cursor.moveToFirst()) {

            do {
                Location tmp = new Location(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
                locationList.add(tmp);
                try {
                    Thread.sleep(350);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (cursor.moveToNext());
        }

        DBOpenHelper.getInstance().closeDB();

        return locationList;
    }

    @Override
    public long add(Location location) {
        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();

        ContentValues datosColumnas = creataLocationCV(location);

        long id = sqLiteDatabase.insert(StoriesContract.LocationItem.TABLE, null, datosColumnas);

        DBOpenHelper.getInstance().closeDB();

        return id;
    }

    @Override
    public boolean exists(Location location) {
        return false;
    }

    @Override
    public long delete(Location location) {
        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();
        ContentValues datosColumnas = creataLocationCV(location);
        long id = sqLiteDatabase.update(StoriesContract.LocationItem.TABLE, datosColumnas,
                StoriesContract.LocationItem._ID + " = ?",
                new String[] {Integer.toString(location.getLocationID())});

        DBOpenHelper.getInstance().closeDB();;
        return id;
    }

    @Override
    public long update(Location location) {
        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();
        ContentValues datosColumnas = creataLocationCV(location);
        long id = sqLiteDatabase.update(StoriesContract.LocationItem.TABLE, datosColumnas,
                StoriesContract.LocationItem._ID + " = ?",
                new String[] {Integer.toString(location.getLocationID())});

        DBOpenHelper.getInstance().closeDB();;
        return id;
    }

    private ContentValues creataLocationCV(Location l) {
        ContentValues cV = new ContentValues();

        cV.put(StoriesContract.LocationItem.NAME, l.getLocationName());
        cV.put(StoriesContract.LocationItem.DESCRIPTION, l.getLocationDesc());
        cV.put(StoriesContract.LocationItem.BOOKID, l.getIDBook());

        return cV;
    }
}
