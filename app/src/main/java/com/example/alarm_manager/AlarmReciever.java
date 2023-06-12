package com.example.alarm_manager;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class AlarmReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        pushNotification(context);
    }

    private void pushNotification(Context context) {
        Bitmap bitm=BitmapFactory.decodeResource(context.getResources(),R.drawable.download_has);
        NotificationCompat.BigPictureStyle style=new NotificationCompat.BigPictureStyle().
                bigPicture(bitm)
                .setBigContentTitle("new air pods in store");
                //.setSummaryText("get new air pods and free coupon ijij ijiojk ");

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.S){
            style.setContentDescription("this description for android S");
        }

        NotificationCompat.Builder builder=getBuilder(context);
        builder.setStyle(style);
        NotificationManager manager=(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(123,builder.build());
    }


    private NotificationCompat.Builder getBuilder(Context cont){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(cont,NotiClass.CHENNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_mail_24)
                .setContentTitle("new message")
                .setContentText("you have a new message");
        return builder;

    }
}