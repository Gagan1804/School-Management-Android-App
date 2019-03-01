package com.gstar.schoolmanagement;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ViewTeachers extends AppCompatActivity {

    private DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_teachers);

        myDb = new DatabaseHelper(this);

        viewTeacherData();
    }

    private void viewTeacherData() {

        Cursor cursor = myDb.viewTeacherData();

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
                buffer.append("Email :"+cursor.getString(2)+"\n");
                buffer.append("Mobile Number :"+cursor.getString(3)+"\n");
                buffer.append("Address :"+cursor.getString(6)+"\n");
                buffer.append("Qualification :"+cursor.getString(7)+"\n");

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
        Intent intent = new Intent(ViewTeachers.this, admin_teacher.class);
        startActivity(intent);
        finish();
    }
}
