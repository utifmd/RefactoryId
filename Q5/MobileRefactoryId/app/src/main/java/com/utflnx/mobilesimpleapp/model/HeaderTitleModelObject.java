package com.utflnx.mobilesimpleapp.model;

import com.utflnx.mobilesimpleapp.extension.ListObject;

public class HeaderTitleModelObject extends ListObject {
    private HeaderTitleModel model;

    public HeaderTitleModel getModel() {
        return model;
    }

    public void setModel(HeaderTitleModel model) {
        this.model = model;
    }

    @Override
    public int getViewType() {
        return TYPE_TITLE;
    }
}
