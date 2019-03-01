package com.gstar.schoolmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class Teacher_function extends AppCompatActivity {

    Button addexm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_function);

        addexm = findViewById(R.id.addexm);

        addexm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Teacher_function.this, AddExamResults.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Teacher_function.this, TeacherLogin.class);
        startActivity(intent);
        finish();
    }
}
