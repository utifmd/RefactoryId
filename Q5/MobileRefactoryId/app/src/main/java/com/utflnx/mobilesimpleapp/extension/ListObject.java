package com.utflnx.mobilesimpleapp.extension;

public abstract class ListObject {
    public static final int TYPE_GENERAL = 0;
    public static final int TYPE_CALENDAR = 1;
    public static final int TYPE_TITLE = 2;
    public static final int TYPE_HORIZONTAL = 3;

    public abstract int getViewType();
}
