package com.example.attendanceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class ProfessorView extends AppCompatActivity {

    RecyclerView pRecyclerView;
    myProfAdapter pAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_view);

        List<String> profList= Arrays.asList("Subjects", "Schedule", "Evaluation forms");

        pRecyclerView=(RecyclerView) findViewById(R.id.listProf);
        pRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        pRecyclerView.setItemAnimator(new DefaultItemAnimator());
        pAdapter=new myProfAdapter(profList, R.layout.my_profrow,this);
        pRecyclerView.setAdapter(pAdapter);
    }
}