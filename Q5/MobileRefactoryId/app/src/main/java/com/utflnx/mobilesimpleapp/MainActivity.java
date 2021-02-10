package com.utflnx.mobilesimpleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.utflnx.mobilesimpleapp.extension.HomeModule;
import com.utflnx.mobilesimpleapp.extension.ListObject;
import com.utflnx.mobilesimpleapp.extension.TodoAdapter;
import com.utflnx.mobilesimpleapp.model.HeadOfHorizon;
import com.utflnx.mobilesimpleapp.model.HeadOfVertical;
import com.utflnx.mobilesimpleapp.model.HorizonTodoModel;
import com.utflnx.mobilesimpleapp.model.HorizonTodoModelObject;
import com.utflnx.mobilesimpleapp.model.TodoModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView todoRecyclerView = findViewById(R.id.rv_main);

        TodoAdapter todoAdapter = new TodoAdapter(this);
        todoRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        todoRecyclerView.setHasFixedSize(true);

        List<ListObject> hetero = new ArrayList<>();

        HeadOfHorizon headOfHorizon = new HeadOfHorizon(HomeModule.currentDate());
        hetero.add(headOfHorizon);

        List<HorizonTodoModel> daysOfWeeks = new ArrayList<>();
        daysOfWeeks.add(new HorizonTodoModel("S", "10", false));
        daysOfWeeks.add(new HorizonTodoModel("S", "11", true));
        daysOfWeeks.add(new HorizonTodoModel("R", "12", false));
        daysOfWeeks.add(new HorizonTodoModel("K", "13", false));
        daysOfWeeks.add(new HorizonTodoModel("J", "14", false));
        daysOfWeeks.add(new HorizonTodoModel("S", "15", false));
        daysOfWeeks.add(new HorizonTodoModel("M", "16", false));
        daysOfWeeks.add(new HorizonTodoModel("S", "17", false));
        daysOfWeeks.add(new HorizonTodoModel("S", "18", true));
        daysOfWeeks.add(new HorizonTodoModel("R", "19", false));
        hetero.add(new HorizonTodoModelObject(daysOfWeeks));

        HeadOfVertical headOfList = new HeadOfVertical("Task List");
        hetero.add(headOfList);

        hetero.add(new TodoModel("Meeting Client A", "10.00 - 09.30", "10.00", false));
        hetero.add(new TodoModel("Daily Stand Up", "10.00 - 09.30", "10.00", false));
        hetero.add(new TodoModel("Get breakfast", "09.00 - 09.30", "09.00", false));
        hetero.add(new TodoModel("Drink water", "07.00 - 08.30", "07.00", true));
        hetero.add(new TodoModel("Pray subuh", "05.00 - 06.30", "05.00", true));

        todoAdapter.setData(hetero);
        todoRecyclerView.setAdapter(todoAdapter);
    }
}