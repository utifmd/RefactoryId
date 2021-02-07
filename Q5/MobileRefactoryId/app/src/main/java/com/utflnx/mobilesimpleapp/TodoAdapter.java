package com.utflnx.mobilesimpleapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.GeneralViewHolder> {
    private List<TodoModel> mTodoModels;

    public void setData(List<TodoModel> todoModels){

    }

    @NonNull @Override
    public GeneralViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new GeneralViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull GeneralViewHolder holder, int position) {
        TodoModel todoModel = mTodoModels.get(position);

        ((GeneralViewHolder)holder).bind(todoModel, position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class GeneralViewHolder extends RecyclerView.ViewHolder {

        public GeneralViewHolder(@NonNull View itemView) {
            super(itemView);

//            itemView.findViewById(R.layout.)
        }

        public void bind(TodoModel todoModel, int position) {

        }
    }
}
