package com.example.attendanceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class Subjects extends AppCompatActivity {

    RecyclerView sRecyclerView;
    mySubjectAdapter sAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);

        List<String> subjects= Arrays.asList("Maths", "Android programming", "Digital telecommunications");

        sRecyclerView=(RecyclerView) findViewById(R.id.listSub);
        sRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        sRecyclerView.setItemAnimator(new DefaultItemAnimator());
        sAdapter=new mySubjectAdapter(subjects,R.layout.my_subjectrow,this);
        sRecyclerView.setAdapter(sAdapter);
    }
}