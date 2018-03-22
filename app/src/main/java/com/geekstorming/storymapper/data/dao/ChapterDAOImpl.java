package com.geekstorming.storymapper.data.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.geekstorming.storymapper.base.daos.ChapterDAO;
import com.geekstorming.storymapper.data.db.DBOpenHelper;
import com.geekstorming.storymapper.data.db.StoriesContract;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Chapter;

import java.util.ArrayList;

public class ChapterDAOImpl implements ChapterDAO {
    @Override
    public ArrayList<Chapter> loadAll(Book bookID) {
        ArrayList<Chapter> chapterList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();
        Cursor cursor = sqLiteDatabase.query(StoriesContract.ChapterItem.TABLE,
                StoriesContract.ChapterItem.ALLCOLUMNS,
                StoriesContract.ChapterItem.BOOKID + " = ?",
                new String[] { Integer.toString(bookID.getBookID()) },
                null,null,
                StoriesContract.ChapterItem.DEFAULT_SORT, null);

        if (cursor.moveToFirst()) {

            do {
                Chapter tmp = new Chapter(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
                chapterList.add(tmp);
                try {
                    Thread.sleep(350);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (cursor.moveToNext());
        }

        DBOpenHelper.getInstance().closeDB();

        return chapterList;
    }

    @Override
    public long add(Chapter chapter) {
        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();

        ContentValues datosColumnas = createChapterCV(chapter);

        long id = sqLiteDatabase.insert(StoriesContract.ChapterItem.TABLE, null, datosColumnas);

        DBOpenHelper.getInstance().closeDB();

        return id;
    }

    @Override
    public boolean exists(Chapter chapter) {
        return false;
    }

    @Override
    public long delete(Chapter chapter) {
        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();
        ContentValues datosColumnas = createChapterCV(chapter);
        long id = sqLiteDatabase.update(StoriesContract.ChapterItem.TABLE, datosColumnas,
                StoriesContract.ChapterItem._ID + " = ?",
                new String[] {Integer.toString(chapter.getIDChapter())});

        DBOpenHelper.getInstance().closeDB();;
        return id;
    }

    @Override
    public long update(Chapter chapter) {
        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();
        ContentValues datosColumnas = createChapterCV(chapter);
        long id = sqLiteDatabase.update(StoriesContract.ChapterItem.TABLE, datosColumnas,
                StoriesContract.ChapterItem._ID + " = ?",
                new String[] {Integer.toString(chapter.getIDChapter())});

        DBOpenHelper.getInstance().closeDB();;
        return id;
    }

    private ContentValues createChapterCV (Chapter c) {
        ContentValues cV = new ContentValues();

        cV.put(StoriesContract.ChapterItem.NAME, c.getChapterName());
        cV.put(StoriesContract.ChapterItem.PROGRESS, c.getStoryProgress());
        cV.put(StoriesContract.ChapterItem.BOOKID, c.getIDBook());

        return cV;
    }
}
