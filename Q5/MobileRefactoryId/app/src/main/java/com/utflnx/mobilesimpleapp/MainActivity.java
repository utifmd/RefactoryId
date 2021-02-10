package com.utflnx.mobilesimpleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import com.utflnx.mobilesimpleapp.extension.HomeModule;
import com.utflnx.mobilesimpleapp.extension.ListObject;
import com.utflnx.mobilesimpleapp.extension.VerticalAdapter;
import com.utflnx.mobilesimpleapp.model.HeadOfHorizon;
import com.utflnx.mobilesimpleapp.model.HeadOfVertical;
import com.utflnx.mobilesimpleapp.model.HorizonTodoModel;
import com.utflnx.mobilesimpleapp.model.HorizonTodoModelObject;
import com.utflnx.mobilesimpleapp.model.VerticalTodoModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView verticalRecyclerView = findViewById(R.id.rv_main);

        VerticalAdapter verticalAdapter = new VerticalAdapter(this);
        verticalRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        verticalRecyclerView.setHasFixedSize(true);

        List<ListObject> hetero = new ArrayList<>();

        HeadOfHorizon headOfHorizon = new HeadOfHorizon(HomeModule.currentDate());
        hetero.add(headOfHorizon);

        List<HorizonTodoModel> daysOfWeeks = new ArrayList<>();
        daysOfWeeks.add(new HorizonTodoModel("S", "10", false));
        daysOfWeeks.add(new HorizonTodoModel("S", "11", true));
        daysOfWeeks.add(new HorizonTodoModel("R", "12", false));
        daysOfWeeks.add(new HorizonTodoModel("K", "13", false));
        daysOfWeeks.add(new HorizonTodoModel("J", "14", false));
        daysOfWeeks.add(new HorizonTodoModel("S", "15", true));
        daysOfWeeks.add(new HorizonTodoModel("M", "16", false));
        daysOfWeeks.add(new HorizonTodoModel("S", "17", false));
        daysOfWeeks.add(new HorizonTodoModel("S", "18", true));
        daysOfWeeks.add(new HorizonTodoModel("R", "19", false));
        hetero.add(new HorizonTodoModelObject(daysOfWeeks));

        HeadOfVertical headOfList = new HeadOfVertical("Task List");
        hetero.add(headOfList);

        hetero.add(new VerticalTodoModel("Meeting Client A", "10.00 - 09.30", "10.00", false));
        hetero.add(new VerticalTodoModel("Daily Stand Up", "10.00 - 09.30", "10.00", false));
        hetero.add(new VerticalTodoModel("Get breakfast", "09.00 - 09.30", "09.00", false));
        hetero.add(new VerticalTodoModel("Drink water", "07.00 - 08.30", "07.00", true));
        hetero.add(new VerticalTodoModel("Pray subuh", "05.00 - 06.30", "05.00", true));

        verticalAdapter.setData(hetero);
        verticalRecyclerView.setAdapter(verticalAdapter);
    }
}