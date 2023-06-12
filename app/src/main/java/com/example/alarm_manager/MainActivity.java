package com.example.alarm_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {
    Button btnPick;
    TextView txtTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPick=findViewById(R.id.button);
        btnPick.setOnClickListener(this);
        txtTime=findViewById(R.id.textView);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        txtTime.setText(i+":"+i1);
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,i);
        calendar.set(Calendar.MINUTE,i1);

        setAlarm(calendar);
    }

    private void setAlarm(Calendar calendar) {
        AlarmManager manager=(AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent=new Intent(this,AlarmReciever.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(this,001,intent,PendingIntent.FLAG_IMMUTABLE);

        manager.setExact(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);

        Log.d("hello",String.valueOf(Build.VERSION.BASE_OS));
        Log.d("hello",String.valueOf(Build.VERSION.CODENAME));
        Log.d("hello",String.valueOf(Build.VERSION.RELEASE));
        Log.d("hello",String.valueOf(Build.VERSION.SDK_INT));
        Log.d("hello",String.valueOf(Build.VERSION.RELEASE_OR_CODENAME));

    }

    @Override
    public void onClick(View view) {
        MyTimePicker myTimePicker=new MyTimePicker();
        myTimePicker.show(getSupportFragmentManager(),"timePick");
    }
}