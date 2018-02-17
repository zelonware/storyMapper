package com.geekstorming.storymapper.base;

import android.app.Application;
import android.content.Context;

import com.geekstorming.storymapper.data.db.DBOpenHelper;

/**
 * App from Application
 */

public class App extends Application {

    private AppPreferencesHelper appPreferencesHelper;
    private DBOpenHelper inventoryOpenHelper;
    private static Context context;

    public App() {
        this.context = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appPreferencesHelper = AppPreferencesHelper.getInstance();
        DBOpenHelper.getInstance().openDB();
    }


    public static Context getContext() {
        return context;
    }

    public AppPreferencesHelper getAppPreferencesHelper() {
        return appPreferencesHelper;
    }
}


