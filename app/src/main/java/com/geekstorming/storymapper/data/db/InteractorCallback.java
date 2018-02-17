package com.geekstorming.storymapper.data.db;

/**
 * Created by Beelzenef on 17/02/2018.
 */

public interface InteractorCallback {
    void onError(Error error);
    void onError(Exception exception);
    void onSuccess();
}
