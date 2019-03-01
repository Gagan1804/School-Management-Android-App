package com.gstar.schoolmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Parent_function extends AppCompatActivity {

    Button viewPerformance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_function);

        viewPerformance = findViewById(R.id.button);

        viewPerformance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parent_function.this, ViewExamMarksByParents.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Parent_function.this, ParentLogin.class);
        startActivity(intent);
        finish();
    }
}
