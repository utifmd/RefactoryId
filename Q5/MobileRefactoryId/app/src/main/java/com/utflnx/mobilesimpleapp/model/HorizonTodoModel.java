package com.utflnx.mobilesimpleapp.model;

import com.utflnx.mobilesimpleapp.extension.ListObject;

public class HorizonTodoModel
//        extends ListObject
{
    private String day;
    private String date;
    private boolean isDot;

    public HorizonTodoModel() {
    }

    public HorizonTodoModel(String day, String date, boolean isDot) {
        this.day = day;
        this.date = date;
        this.isDot = isDot;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isDot() {
        return isDot;
    }

    public void setDot(boolean dot) {
        isDot = dot;
    }

//    @Override
//    public int getViewType() {
//        return TYPE_HORIZONTAL;
//    }
}
