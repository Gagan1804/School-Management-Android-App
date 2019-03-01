package com.gstar.schoolmanagement;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddExamResults extends AppCompatActivity {

    DatabaseHelper myDb;
    Button AddResultData;
    EditText studenName, studentID, subjectName, subjectCode, maxMarks, marksByStudent, grade;
    public SQLiteDatabase databasehelper;
    public boolean EditTextEmptyHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exam_results);

        myDb = new DatabaseHelper(this);

        AddResultData = findViewById(R.id.addr);

        studenName = findViewById(R.id.editText3);
        studentID = findViewById(R.id.editText4);
        subjectName = findViewById(R.id.editText5);
        subjectCode = findViewById(R.id.editText11);
        maxMarks = findViewById(R.id.editText10);
        marksByStudent = findViewById(R.id.editText12);
        grade = findViewById(R.id.editText13);

        AddResultData.setOnClickListener(
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


    private void SQLiteTableBuild() {
        String query2 = "CREATE TABLE IF NOT EXISTS \"exam_table1\" ( `StudentName` TEXT, `StudentID` integer PRIMARY KEY AUTOINCREMENT, `SubjectName` TEXT, `SubjectCode` TEXT, `MaxMarks` INTEGER, `MarksScoredByStudent` INTEGER, `Grade` TEXT)";
        databasehelper.execSQL(query2);
    }

    private void SQLiteDataBaseBuild() {
        databasehelper = openOrCreateDatabase(DatabaseHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }

    private void CheckEditTextStatus() {
        if(TextUtils.isEmpty(studenName.toString()) || TextUtils.isEmpty(studentID.toString()) || TextUtils.isEmpty(subjectName.toString()) || TextUtils.isEmpty(subjectCode.toString()) || TextUtils.isEmpty(maxMarks.toString()) || TextUtils.isEmpty(marksByStudent.toString()) || TextUtils.isEmpty(grade.toString())){

            EditTextEmptyHolder = false ;

        }
        else {
            EditTextEmptyHolder = true ;
        }
    }

    private void InsertDataIntoSQLiteDatabase() {
        if(EditTextEmptyHolder == true)
        {
            myDb.insertResultData(subjectName.getText().toString(),subjectName.getText().toString(), subjectCode.getText().toString(), maxMarks.getText().toString(), marksByStudent.getText().toString(), grade.getText().toString());
            databasehelper.close();
            Toast.makeText(AddExamResults.this,"Exam Results entered Successfully", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(AddExamResults.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();
        }
    }

    private void EmptyEditTextAfterDataInsert() {

        studenName.getText().clear();
       // studentID.getText().clear();
        subjectName.getText().clear();
        subjectCode.getText().clear();
        maxMarks.getText().clear();
        marksByStudent.getText().clear();
        grade.getText().clear();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(AddExamResults.this, Teacher_function.class);
        startActivity(intent);
        finish();
    }

}
