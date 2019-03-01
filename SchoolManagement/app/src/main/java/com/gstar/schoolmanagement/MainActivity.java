package com.gstar.schoolmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Admin, Teacher, Student, Parent, About;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Admin = findViewById(R.id.admin);
        Teacher = findViewById(R.id.teacher);
        Student = findViewById(R.id.student);
        Parent = findViewById(R.id.parent);
        About = findViewById(R.id.button2);

        Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, AdminLogin.class);
                startActivity(intent);
                finish();

            }
        });

        Teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, TeacherLogin.class);
                startActivity(intent);
                finish();

            }
        });

        Student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, StudentLogin.class);
                startActivity(intent);
                finish();

            }
        });

        Parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ParentLogin.class);
                startActivity(intent);
                finish();

            }
        });

        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, AboutUs.class);
                startActivity(intent);
                finish();

            }
        });



    }
}
