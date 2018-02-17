package com.geekstorming.storymapper.base;

/**
 * Created by Beelzenef on 17/02/2018.
 */

public class AppPreferencesHelper {

    private static AppPreferencesHelper instance;

    private AppPreferencesHelper () {
    }

    public static AppPreferencesHelper getInstance() {
        if (instance == null)
            instance = new AppPreferencesHelper();
        return instance;
    }
}
