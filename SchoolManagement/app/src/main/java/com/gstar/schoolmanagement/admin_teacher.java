package com.gstar.schoolmanagement;

import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class admin_teacher extends AppCompatActivity {

    Button addt,viewt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_teacher);

        addt = findViewById(R.id.Add);
        viewt = findViewById(R.id.View);

        addt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_teacher.this, AddTeacher.class);
                startActivity(intent);
                finish();
            }
        });

        viewt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_teacher.this, ViewTeachers.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(admin_teacher.this, AdminActivity.class);
        startActivity(intent);
        finish();
    }

}
