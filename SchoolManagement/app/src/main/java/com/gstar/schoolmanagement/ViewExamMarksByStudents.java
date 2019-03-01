package com.gstar.schoolmanagement;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewExamMarksByStudents extends AppCompatActivity {

    private DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exam_marks);

        myDb = new DatabaseHelper(this);

        viewExamData();
    }

    private void viewExamData() {

        Cursor cursor = myDb.viewExamData();

        if(cursor.getCount()==0)
        {
            showMessage("Error","No Data Found");
            return;
        }
        else
        {
            StringBuffer buffer = new StringBuffer();
            while(cursor.moveToNext())
            {
                buffer.append("Student Name :"+cursor.getString(0)+"\n");
                buffer.append("Student ID :"+cursor.getString(1)+"\n");
                buffer.append("Subject Name :"+cursor.getString(2)+"\n");
                buffer.append("Subject Code :"+cursor.getString(3)+"\n");
                buffer.append("Max Exam Marks :"+cursor.getString(4)+"\n");
                buffer.append("Marks scored :"+cursor.getString(5)+"\n");
                buffer.append("Grade :"+cursor.getString(6)+"\n");

            }

            showMessage("Data",buffer.toString());
        }

    }

    public void showMessage(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ViewExamMarksByStudents.this, Student_function.class);
        startActivity(intent);
        finish();
    }
}
