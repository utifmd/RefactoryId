package com.utflnx.mobilesimpleapp.model;

import com.utflnx.mobilesimpleapp.extension.ListObject;

public class VerticalTodoModel extends ListObject{
    private String title;
    private String subtitle;
    private String time;
    private boolean complete;

    public VerticalTodoModel(){}
    public VerticalTodoModel(String title, String subtitle, String time, boolean complete) {
        this.title = title;
        this.subtitle = subtitle;
        this.time = time;
        this.complete = complete;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public int getViewType() {
        return TYPE_GENERAL;
    }
}