package com.gstar.schoolmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Student_function extends AppCompatActivity {

    Button teachers, exams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_function);

        teachers = findViewById(R.id.teachers);
        exams = findViewById(R.id.exam);

        teachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Student_function.this, ViewTeachersbyStudents.class);
                startActivity(intent);
                finish();
            }
        });

        exams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Student_function.this, ViewExamMarksByStudents.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Student_function.this, StudentLogin.class);
        startActivity(intent);
        finish();
    }
}
