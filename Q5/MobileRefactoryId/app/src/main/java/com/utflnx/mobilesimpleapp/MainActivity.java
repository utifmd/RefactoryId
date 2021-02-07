package com.utflnx.mobilesimpleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
        TodoModel item1 = new TodoModel();
        TodoModel item2 = new TodoModel();

        HeaderCalendarModelObject headerCalendarModel = new HeaderCalendarModelObject();
        headerCalendarModel.setModel(new HeaderCalendarModel(HomeModule.currentDate()));

        HeaderTitleModelObject headerTitleModel = new HeaderTitleModelObject();
        headerTitleModel.setModel(new HeaderTitleModel("Task List"));

        item1.setTitle("Daily Stand Up");
        item1.setComplete(false);
        item1.setSubtitle("09.00 - 09.30");
        item1.setTime("09.00");

        item2.setTitle("Meeting Client A");
        item2.setComplete(false);
        item2.setSubtitle("10.00 - 19.30");
        item2.setTime("10.00");

        listObjects.add(item1);
        //listObjects.add(headerCalendarModel);
        listObjects.add(item2);
        //listObjects.add(headerTitleModel);

        todoAdapter.setData(listObjects);
        todoRecyclerView.setAdapter(todoAdapter);
    }
}