package com.utflnx.mobilesimpleapp;

public class TodoModelObject extends ListObject{
    private TodoModel todoModel;

    public TodoModel getTodoModel() {
        return todoModel;
    }

    public void setTodoModel(TodoModel todoModel) {
        this.todoModel = todoModel;
    }


    @Override
    public int getViewType() {
        return TYPE_GENERAL;
    }
}
