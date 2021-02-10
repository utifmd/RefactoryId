package com.utflnx.mobilesimpleapp.model;

import com.utflnx.mobilesimpleapp.extension.ListObject;

public class HeaderTitleModel extends ListObject {
    private String title;

    public HeaderTitleModel() {}
    public HeaderTitleModel(String title) {
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
        return TYPE_TITLE;
    }
}
