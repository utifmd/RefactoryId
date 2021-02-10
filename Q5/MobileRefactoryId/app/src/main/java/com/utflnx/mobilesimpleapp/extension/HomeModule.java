package com.utflnx.mobilesimpleapp.extension;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SuppressLint("SimpleDateFormat")
public class HomeModule {
    private static Calendar calendar(){
        return Calendar.getInstance();
    }

    private static Date date(){
        return calendar().getTime();
    }

    public static String currentDate(){
        String stringDate = new SimpleDateFormat("dd MMM yyyy").format(date());

        return stringDate.toUpperCase();
    }
}
