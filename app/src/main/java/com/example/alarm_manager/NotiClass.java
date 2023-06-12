package com.example.alarm_manager;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public class NotiClass extends Application {
    public static final String CHENNEL_ID="CHENNEL_ID";

    @Override
    public void onCreate() {
        super.onCreate();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel=new NotificationChannel(CHENNEL_ID,"mychennel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

    }
}
