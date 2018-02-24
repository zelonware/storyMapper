package com.geekstorming.storymapper.data.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.geekstorming.storymapper.base.daos.UserDAO;
import com.geekstorming.storymapper.data.db.DBOpenHelper;
import com.geekstorming.storymapper.data.db.StoriesContract;
import com.geekstorming.storymapper.data.pojo.User;

/**
 * User DAO implementation
 */

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean checkUser(String user, String password) {

        boolean userExists = false;

        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();

        Cursor c = sqLiteDatabase.query(StoriesContract.UserItem.TABLE, StoriesContract.UserItem.SEARCHCOLUMNS,
                StoriesContract.UserItem.USER + " = ? AND " + StoriesContract.UserItem.PASSWORD + " = ? ",
                new String[] { user, password}, null, null, StoriesContract.UserItem.DEFAULT_SORT);

        if (c.moveToFirst()) {
            do {
                if (c.getString(0).equals(user) && c.getString(1).equals(password))
                    userExists = true;
            } while (c.moveToNext() && !userExists);
        }

        DBOpenHelper.getInstance().closeDB();

        return userExists;
    }

    @Override
    public void registerUser(User user) {
        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();

        ContentValues datosColumnas = createUserCV(user);

        long id = sqLiteDatabase.insert(StoriesContract.UserItem.TABLE, null, datosColumnas);

        DBOpenHelper.getInstance().closeDB();
    }

    @Override
    public boolean checkUserExists(String user) {
        boolean userExists = false;

        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();

        Cursor c = sqLiteDatabase.query(StoriesContract.UserItem.TABLE,
                new String[] { StoriesContract.UserItem.USER},
                StoriesContract.UserItem.USER + " = ?",
                new String[] { user }, null, null, StoriesContract.UserItem.DEFAULT_SORT);

        if (c.moveToFirst()) {
            do {
                if (c.getString(0).equals(user))
                    userExists = true;
            } while (c.moveToNext() && !userExists);
        }

        DBOpenHelper.getInstance().closeDB();

        return userExists;
    }

    @Override
    public boolean checkEmailExists(String email) {
        boolean emailExists = false;

        SQLiteDatabase sqLiteDatabase = DBOpenHelper.getInstance().openDB();

        Cursor c = sqLiteDatabase.query(StoriesContract.UserItem.TABLE,
                new String[] { StoriesContract.UserItem.EMAIL},
                StoriesContract.UserItem.EMAIL + " = ?",
                new String[] { email }, null, null, StoriesContract.UserItem.DEFAULT_SORT);

        if (c.moveToFirst()) {
            do {
                if (c.getString(0).equals(email))
                    emailExists = true;
            } while (c.moveToNext() && !emailExists);
        }

        DBOpenHelper.getInstance().closeDB();

        return emailExists;
    }

    private ContentValues createUserCV(User user) {

        ContentValues cV = new ContentValues();

        cV.put(StoriesContract.UserItem.USERNAME, user.getUsername());
        cV.put(StoriesContract.UserItem.USER, user.getUser());
        cV.put(StoriesContract.UserItem.EMAIL, user.getEmail());
        cV.put(StoriesContract.UserItem.PASSWORD, user.getPassword());

        return cV;
    }
}
