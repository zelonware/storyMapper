package com.geekstorming.storymapper.data.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.utils.DaoSession;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

import static com.geekstorming.storymapper.data.dao.BookDAO.Properties.DESCRIPTION;
import static com.geekstorming.storymapper.data.dao.BookDAO.Properties.GENRE;
import static com.geekstorming.storymapper.data.dao.BookDAO.Properties.ID;
import static com.geekstorming.storymapper.data.dao.BookDAO.Properties.NWORDS;
import static com.geekstorming.storymapper.data.dao.BookDAO.Properties.TITLE;

/**
 * BookDAO
 */

public class BookDAO extends AbstractDao<Book, Long> {
    public static final String TABLENAME = "BOOK";

    public static class Properties {
        public final static Property ID = new Property(0, Long.class, "bookID", true, "_id");
        public final static Property TITLE = new Property(1, String.class, "bookTitle", false, "BOOK_TITLE");
        public final static Property DESCRIPTION = new Property(2, String.class, "bookDesc", false, "BOOK_DESC");
        public final static Property GENRE = new Property(3, String.class, "bookGenre", false, "BOOK_GENRE");
        public final static Property NWORDS = new Property(4, Integer.class, "nWords", false, "N_WORDS");
    };


    public BookDAO(DaoConfig config) {
        super(config);
    }

    public BookDAO(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        

        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"" + TABLENAME + "\" (" +
                "\"" + ID + "\" INTEGER PRIMARY KEY ," +
                "\"" + TITLE + "\" TEXT, \"" + DESCRIPTION + "\" TEXT, \"" + GENRE + "\" TEXT, \"" + NWORDS + "\" INTEGER);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"" + TABLENAME + "\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Book entity) {
        stmt.clearBindings();

        Long id = entity.getBookID();
        if (id != null) {
            stmt.bindLong(1, id);
        }

        String name = entity.getBookTitle();
        if (name != null) {
            stmt.bindString(2, name);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Book entity) {
        stmt.clearBindings();

        Long id = entity.getBookID();
        if (id != null) {
            stmt.bindLong(1, id);
        }

        String name = entity.getBookTitle();
        if (name != null) {
            stmt.bindString(2, name);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }

    @Override
    public Book readEntity(Cursor cursor, int offset) {
        Book entity = new Book(
                cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
                cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
                cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2),
                cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3),
                cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4)
        );
        return entity;
    }

    @Override
    public void readEntity(Cursor cursor, Book entity, int offset) {
        entity.setBookID(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setBookTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setBookDesc(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setBookGenre(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setnWords(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
    }

    @Override
    protected final Long updateKeyAfterInsert(Book entity, long rowId) {
        entity.setBookID(rowId);
        return rowId;
    }

    @Override
    public Long getKey(Book entity) {
        if(entity != null)
            return entity.getBookID();
        return null;
    }

    @Override
    protected boolean hasKey(Book entity) {
        if (entity != null && entity.getBookID() != null && entity.getBookID() != 0)
            return true;
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
}
