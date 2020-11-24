package com.mosin.myweatherapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class MyReceiver extends BroadcastReceiver {

    private int messageId = 1000;

    @Override
    public void onReceive(Context context, Intent intent) {
//        Intent intent1 = new Intent();
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        PendingIntent pendingIntent = PendingIntent
//                .getActivity(, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        // создать нотификацию

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "2")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Важное сообщение")
                .setContentText("изменен режим 'в самолете'")
                .setAutoCancel(true);
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(messageId++, builder.build());
    }

}
