package com.utflnx.mobilesimpleapp.model;

import com.utflnx.mobilesimpleapp.extension.ListObject;

import java.util.List;

public class HorizonTodoModelObject extends ListObject {
    private HorizonTodoModel model;
    private List<HorizonTodoModel> modelList;

    public HorizonTodoModelObject() {
    }

    public HorizonTodoModelObject(List<HorizonTodoModel> modelList) {
        this.modelList = modelList;
    }

    public HorizonTodoModel getModel() {
        return model;
    }

    public void setModel(HorizonTodoModel model) {
        this.model = model;
    }

    public List<HorizonTodoModel> getModelList() {
        return modelList;
    }

    public void setModelList(List<HorizonTodoModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public int getViewType() {
        return TYPE_HORIZONTAL;
    }
}
