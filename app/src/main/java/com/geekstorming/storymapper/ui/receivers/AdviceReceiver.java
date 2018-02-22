package com.geekstorming.storymapper.ui.receivers;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.geekstorming.storymapper.R;

/**
 * Advice Receiver
 * Receives a writing advice message and raises a notification
 */

public class AdviceReceiver extends BroadcastReceiver {

    public static final String ADVICETAG = "adviceMsg";

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getExtras() != null) {

            Bundle infoB = intent.getExtras();

            String msg = infoB.getString(ADVICETAG);

            Intent intentInfo = new Intent();

            // Building notification
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 1, intentInfo, 0);

            Notification.Builder builder = new Notification.Builder(context);
            builder
                    .setContentTitle("storyMapper about writing")
                    .setContentText(msg)
                    .setSmallIcon(R.drawable.ic_books)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(1, builder.build());
        }

    }
}
