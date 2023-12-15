package com.example.attendanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    Button button, profo, studento;
    TextView textView;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        String email = currentUser.getEmail();
        auth= FirebaseAuth.getInstance();
        button= findViewById(R.id.logout);
        profo=findViewById(R.id.profopen);
        studento=findViewById(R.id.studentopen);
        textView= findViewById(R.id.user_details);

        user= auth.getCurrentUser();
        if (user==null)
        {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }

        else {
            textView.setText(user.getEmail());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();

                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });



        profo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(email.contains("professor"))
                {
                Intent intent = new Intent(getApplicationContext(), ProfessorView.class);
                startActivity(intent);
                finish();}

                else
                {
                    Toast.makeText(MainActivity.this, " NOT ALLOWED",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });


        studento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.contains("student"))
                {
                    Intent intent = new Intent(getApplicationContext(), StudentView.class);
                    startActivity(intent);
                    finish();}

                else {
                Toast.makeText(MainActivity.this, " NOT ALLOWED",
                        Toast.LENGTH_SHORT).show();}
            }
        });
    }
}