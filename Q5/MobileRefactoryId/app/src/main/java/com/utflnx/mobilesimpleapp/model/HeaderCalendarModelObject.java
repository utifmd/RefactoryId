package com.utflnx.mobilesimpleapp.model;

import com.utflnx.mobilesimpleapp.extension.ListObject;

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
