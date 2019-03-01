package com.gstar.schoolmanagement;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class AddTeacher extends AppCompatActivity {

    DatabaseHelper myDb;
    Button AddTeacherData;
    EditText name, address, number, email, username, password,qualification;
    public SQLiteDatabase databasehelper;
    public boolean EditTextEmptyHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);

        myDb = new DatabaseHelper(this);

        AddTeacherData = findViewById(R.id.button4);

        name = findViewById(R.id.editText3);
        qualification = findViewById(R.id.editText15);
        address = findViewById(R.id.editText14);
        number = findViewById(R.id.editText4);
        email = findViewById(R.id.editText5);
        username = findViewById(R.id.editText11);
        password = findViewById(R.id.editText10);

        AddTeacherData.setOnClickListener(
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


    private void SQLiteDataBaseBuild() {
        databasehelper = openOrCreateDatabase(DatabaseHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }


    private void SQLiteTableBuild() {
        String query3 = "CREATE TABLE IF NOT EXISTS \"teacher_table1\" ( `ID` integer PRIMARY KEY AUTOINCREMENT, `Name` TEXT, `Email` TEXT, `MobileNumber` INTEGER, `Username` TEXT, `Password` text, `Address` text, `Qualification` TEXT )";
        databasehelper.execSQL(query3);
    }


    private void CheckEditTextStatus() {
        if(TextUtils.isEmpty(name.toString()) || TextUtils.isEmpty(qualification.toString()) || TextUtils.isEmpty(address.toString()) || TextUtils.isEmpty(number.toString()) || TextUtils.isEmpty(email.toString()) || TextUtils.isEmpty(username.toString()) || TextUtils.isEmpty(password.toString())){

            EditTextEmptyHolder = false ;

        }
        else {
            EditTextEmptyHolder = true ;
        }
    }


    private void InsertDataIntoSQLiteDatabase() {

        if(EditTextEmptyHolder == true)
        {
            myDb.insertTeacherData(name.getText().toString(), username.getText().toString(), password.getText().toString(), number.getText().toString(), email.getText().toString(), address.getText().toString(), qualification.getText().toString());
            databasehelper.close();
            Toast.makeText(AddTeacher.this,"Teacher Registered Successfully", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(AddTeacher.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();
        }
    }


    private void EmptyEditTextAfterDataInsert() {

        name.getText().clear();
        username.getText().clear();
        email.getText().clear();
        number.getText().clear();
        password.getText().clear();
        qualification.getText().clear();
        address.getText().clear();

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(AddTeacher.this, admin_teacher.class);
        startActivity(intent);
        finish();
    }

}
