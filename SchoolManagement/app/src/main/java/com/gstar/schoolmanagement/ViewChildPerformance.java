package com.gstar.schoolmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewChildPerformance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_child_performance);
    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ViewChildPerformance.this, Parent_function.class);
        startActivity(intent);
        finish();
    }
}
