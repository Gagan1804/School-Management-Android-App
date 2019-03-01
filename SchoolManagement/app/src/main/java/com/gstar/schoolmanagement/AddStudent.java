package com.gstar.schoolmanagement;

import android.content.Context;
import android.content.Intent;
import android.database.AbstractCursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.gstar.schoolmanagement.DatabaseHelper.TABLE_NAME1;
import static com.gstar.schoolmanagement.DatabaseHelper.stud_1;
import static com.gstar.schoolmanagement.DatabaseHelper.stud_10;
import static com.gstar.schoolmanagement.DatabaseHelper.stud_2;
import static com.gstar.schoolmanagement.DatabaseHelper.stud_3;
import static com.gstar.schoolmanagement.DatabaseHelper.stud_4;
import static com.gstar.schoolmanagement.DatabaseHelper.stud_5;
import static com.gstar.schoolmanagement.DatabaseHelper.stud_6;
import static com.gstar.schoolmanagement.DatabaseHelper.stud_7;
import static com.gstar.schoolmanagement.DatabaseHelper.stud_8;
import static com.gstar.schoolmanagement.DatabaseHelper.stud_9;

public class AddStudent extends AppCompatActivity {

    DatabaseHelper myDb;
    Button AddStudentData;
    EditText name,fatherName, motherName, fatherNumber, motherNumber, address, number, email, username, password;
    public SQLiteDatabase databasehelper;
    public boolean EditTextEmptyHolder;
    private AbstractCursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        myDb = new DatabaseHelper(this);

        AddStudentData = findViewById(R.id.button3);

        name = findViewById(R.id.name);
        fatherName = findViewById(R.id.fname);
        motherName = findViewById(R.id.mname);
        fatherNumber = findViewById(R.id.fnumber);
        motherNumber = findViewById(R.id.mnumber);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        AddData();

    }

    public void AddData()
    {
        AddStudentData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        // Creating SQLite database if doesn't exists
                        SQLiteDataBaseBuild();

                        // Creating SQLite table if doesn't exists.
                        SQLiteTableBuild();

                        CheckEditTextStatus();

                        InsertDataIntoSQLiteDatabase();

                        EmptyEditTextAfterDataInsert();
                    }
                }
        );
    }

    public void SQLiteDataBaseBuild(){
        databasehelper = openOrCreateDatabase(DatabaseHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }

    public void SQLiteTableBuild() {
        String query1 = "CREATE TABLE IF NOT EXISTS \"student_and_parent_table1\" ( `ID` integer PRIMARY KEY AUTOINCREMENT, `Name` TEXT, `FatherName` TEXT, `MotherName` TEXT, `ParentEmail` TEXT, `FatherPhoneNumber` INTEGER, `MotherPhoneNumber` INTEGER, `Address` text, `UserName` TEXT, `Password` TEXT )";
        databasehelper.execSQL(query1);
    }



    public void InsertDataIntoSQLiteDatabase(){
        if(EditTextEmptyHolder == true)
        {
            myDb.insertStudentData(name.getText().toString(), fatherName.getText().toString(), motherName.getText().toString(), fatherNumber.getText().toString(), motherNumber.getText().toString(), email.getText().toString(), address.getText().toString(), username.getText().toString(), password.getText().toString());
            databasehelper.close();
            Toast.makeText(AddStudent.this,"User Registered Successfully", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(AddStudent.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();
        }
    }

    public void EmptyEditTextAfterDataInsert(){

     name.getText().clear();
     fatherName.getText().clear();
     motherName.getText().clear();
     fatherNumber.getText().clear();
     motherNumber.getText().clear();
     email.getText().clear();
     address.getText().clear();
     username.getText().clear();
     password.getText().clear();
    }

    public void CheckEditTextStatus(){

        if(TextUtils.isEmpty(name.toString()) || TextUtils.isEmpty(fatherName.toString()) || TextUtils.isEmpty(motherName.toString()) || TextUtils.isEmpty(fatherNumber.toString()) || TextUtils.isEmpty(motherNumber.toString()) || TextUtils.isEmpty(email.toString()) || TextUtils.isEmpty(address.toString()) || TextUtils.isEmpty(username.toString()) || TextUtils.isEmpty(password.toString())){

            EditTextEmptyHolder = false ;

        }
        else {
            EditTextEmptyHolder = true ;
        }
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(AddStudent.this, admin_student.class);
        startActivity(intent);
        finish();
    }

}
