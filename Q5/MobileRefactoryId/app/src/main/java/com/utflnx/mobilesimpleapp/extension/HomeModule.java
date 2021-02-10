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

        return new SimpleDateFormat("EEE, MMM dd yyyy").format(date());
    }
}
