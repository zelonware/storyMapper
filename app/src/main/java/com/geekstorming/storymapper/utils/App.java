package com.geekstorming.storymapper.utils;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Beelzenef on 11/02/2018.
 */

public class App extends Application {

    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    public static App instances;
    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
        setDatabase();
    }

    public static App getInstances(){
        return instances;
    }

    private void setDatabase() {
        mHelper = new DaoMaster.DevOpenHelper(this, "storymapper.db", null);
        db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
    }

    public DaoSession getDaoSession() {
        return mDaoSession = mDaoMaster.newSession();
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
