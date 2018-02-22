package com.geekstorming.storymapper.data.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.geekstorming.storymapper.base.daos.AdviceDAO;
import com.geekstorming.storymapper.data.db.DBOpenHelper;
import com.geekstorming.storymapper.data.db.StoriesContract;

/**
 * Advice DAO implementation
 */

public class AdviceDAOImpl implements AdviceDAO {

    @Override
    public String getAdvice() {
        String adv = null;

        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();

        Cursor c = sqLiteDatabase.rawQuery("SELECT " + StoriesContract.AdviceItem._ID + ", " +
                        StoriesContract.AdviceItem.ADVICE + " FROM "
                        + StoriesContract.AdviceItem.TABLE + " ORDER BY RANDOM() LIMIT 1",
                null);
        if (c.moveToFirst()) {
            do {
                adv = c.getString(1);
            } while (c.moveToNext());
        }

        DBOpenHelper.getInstance().closeDB();
        return adv;
    }
}
