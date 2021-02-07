package com.utflnx.mobilesimpleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
public class MainActivity extends AppCompatActivity{
    private final String TAG = getClass().getSimpleName();
    private TodoAdapter todoAdapter;
    private RecyclerView todoRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}