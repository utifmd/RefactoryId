package com.utflnx.mobilesimpleapp;

public class HeaderCalendarModelObject extends ListObject {
    private HeaderCalendarModel model;

    public HeaderCalendarModel getModel() {
        return model;
    }

    public void setModel(HeaderCalendarModel model) {
        this.model = model;
    }

    @Override
    public int getViewType() {
        return TYPE_CALENDAR;
    }
}
