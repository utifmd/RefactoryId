package com.utflnx.mobilesimpleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.utflnx.mobilesimpleapp.extension.HomeModule;
import com.utflnx.mobilesimpleapp.extension.ListObject;
import com.utflnx.mobilesimpleapp.extension.TodoAdapter;
import com.utflnx.mobilesimpleapp.model.HeaderCalendarModel;
import com.utflnx.mobilesimpleapp.model.HeaderTitleModel;
import com.utflnx.mobilesimpleapp.model.HorizonTodoModel;
import com.utflnx.mobilesimpleapp.model.HorizonTodoModelObject;
import com.utflnx.mobilesimpleapp.model.TodoModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private final String TAG = getClass().getSimpleName();
    private TodoAdapter todoAdapter;
    private RecyclerView todoRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoRecyclerView = findViewById(R.id.rv_main);

        todoAdapter = new TodoAdapter(this);
        todoRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        todoRecyclerView.setHasFixedSize(true);

        List<ListObject> listObjects = new ArrayList<>();

        HeaderCalendarModel headerCalendarModel = new HeaderCalendarModel(HomeModule.currentDate());
        listObjects.add(headerCalendarModel);

        List<HorizonTodoModel> horizonTodoModels = new ArrayList<>();
        horizonTodoModels.add(new HorizonTodoModel("S", "10", false));
        horizonTodoModels.add(new HorizonTodoModel("S", "11", true));
        horizonTodoModels.add(new HorizonTodoModel("R", "12", false));
        horizonTodoModels.add(new HorizonTodoModel("K", "13", false));
        horizonTodoModels.add(new HorizonTodoModel("J", "14", false));
        horizonTodoModels.add(new HorizonTodoModel("S", "15", false));
        horizonTodoModels.add(new HorizonTodoModel("M", "16", false));
        horizonTodoModels.add(new HorizonTodoModel("S", "17", false));
        horizonTodoModels.add(new HorizonTodoModel("S", "18", true));
        horizonTodoModels.add(new HorizonTodoModel("R", "19", false));
        listObjects.add(new HorizonTodoModelObject(horizonTodoModels));

        HeaderTitleModel headerTitleModel = new HeaderTitleModel("Task List");
        listObjects.add(headerTitleModel);

        listObjects.add(new TodoModel("Meeting Client A", "10.00 - 09.30", "10.00", false));
        listObjects.add(new TodoModel("Daily Stand Up", "10.00 - 09.30", "10.00", false));
        listObjects.add(new TodoModel("Get breakfast", "09.00 - 09.30", "09.00", false));
        listObjects.add(new TodoModel("Drink water", "07.00 - 08.30", "07.00", true));
        listObjects.add(new TodoModel("Pray subuh", "05.00 - 06.30", "05.00", true));

        todoAdapter.setData(listObjects);
        todoRecyclerView.setAdapter(todoAdapter);
    }
}