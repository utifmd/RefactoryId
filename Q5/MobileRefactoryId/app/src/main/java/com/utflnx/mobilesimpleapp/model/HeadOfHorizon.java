package com.utflnx.mobilesimpleapp.model;

import com.utflnx.mobilesimpleapp.extension.ListObject;

public class HeadOfHorizon extends ListObject {
    private String title;

    public HeadOfHorizon() {}
    public HeadOfHorizon(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getViewType() {
        return TYPE_CALENDAR;
    }
}
