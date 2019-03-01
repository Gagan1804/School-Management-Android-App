package com.gstar.schoolmanagement;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;


public class ViewStudent extends AppCompatActivity {

    private DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);

        myDb = new DatabaseHelper(this);

        viewData();

    }

    private void viewData() {

        Cursor cursor = myDb.viewStudent_ParentData();

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
                buffer.append("ID :"+cursor.getString(0)+"\n");
                buffer.append("Name :"+cursor.getString(1)+"\n");
                buffer.append("Fathers's Name :"+cursor.getString(2)+"\n");
                buffer.append("Mother's Name :"+cursor.getString(3)+"\n");
                buffer.append("Parent's Email :"+cursor.getString(4)+"\n");
                buffer.append("Father's Ph.No. :"+cursor.getString(5)+"\n");
                buffer.append("Mother's Ph.No. :"+cursor.getString(6)+"\n");
                buffer.append("Address :"+cursor.getString(7)+"\n");

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
        Intent intent = new Intent(ViewStudent.this, admin_student.class);
        startActivity(intent);
        finish();
    }

}
