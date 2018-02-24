package com.geekstorming.storymapper.data.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.geekstorming.storymapper.base.App;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * SqliteOpenHelper for stories!
 */

public class DBOpenHelper extends SQLiteOpenHelper {

    private volatile static DBOpenHelper singleton;
    private SQLiteDatabase sqLiteDatabase;
    private AtomicInteger openCounter = new AtomicInteger();

    static {
        singleton = new DBOpenHelper();
    }

    public synchronized static DBOpenHelper getInstance() {
        return singleton;
    }

    public DBOpenHelper() {
        super(App.getContext(), StoriesContract.DATABASE_NAME, null, StoriesContract.DATABASE_VERSION);
    }

    public synchronized SQLiteDatabase openDB() {
        if (openCounter.incrementAndGet() == 1) {
            sqLiteDatabase = singleton.getWritableDatabase();
        }
        return sqLiteDatabase;
    }

    public synchronized void closeDB() {
        if (openCounter.decrementAndGet() == 0) {
            sqLiteDatabase.close();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.beginTransaction();

            db.execSQL(StoriesContract.UserItem.SQL_CREATE_TABLE);
            db.execSQL(StoriesContract.UserItem.SQL_INSERT_TOTABLE);
            db.execSQL(StoriesContract.AdviceItem.SQL_CREATE_TABLE);
            db.execSQL(StoriesContract.AdviceItem.SQL_INSERT_TOTABLE);
            db.execSQL(StoriesContract.BookItem.SQL_CREATE_TABLE);
            db.execSQL(StoriesContract.CharacterItem.SQL_CREATE_TABLE);

            db.setTransactionSuccessful();
        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.beginTransaction();

            db.execSQL(StoriesContract.UserItem.SQL_DROP_TABLE);
            db.execSQL(StoriesContract.UserItem.SQL_CREATE_TABLE);
            db.execSQL(StoriesContract.UserItem.SQL_INSERT_TOTABLE);
            db.execSQL(StoriesContract.AdviceItem.SQL_DROP_TABLE);
            db.execSQL(StoriesContract.AdviceItem.SQL_CREATE_TABLE);
            db.execSQL(StoriesContract.AdviceItem.SQL_INSERT_TOTABLE);
            db.execSQL(StoriesContract.BookItem.SQL_DROP_TABLE);
            db.execSQL(StoriesContract.BookItem.SQL_CREATE_TABLE);
            db.execSQL(StoriesContract.CharacterItem.SQL_DROP_TABLE);
            db.execSQL(StoriesContract.CharacterItem.SQL_CREATE_TABLE);

            db.setTransactionSuccessful();
        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                db.setForeignKeyConstraintsEnabled(true);
            } else {
                db.execSQL("PRAGMA foreign_keys=1");
            }
        }
    }
}
