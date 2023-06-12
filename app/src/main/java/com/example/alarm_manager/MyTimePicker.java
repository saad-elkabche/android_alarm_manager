package com.example.alarm_manager;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class MyTimePicker extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        int hour= Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int minute= Calendar.getInstance().get(Calendar.MINUTE);
      TimePickerDialog timePickerDialog=new TimePickerDialog(getContext(),(TimePickerDialog.OnTimeSetListener) getActivity()
              ,hour,minute, DateFormat.is24HourFormat(getContext()));

        return timePickerDialog;
    }
}
