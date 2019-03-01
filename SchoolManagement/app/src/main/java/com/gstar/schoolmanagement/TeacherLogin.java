package com.gstar.schoolmanagement;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TeacherLogin extends AppCompatActivity {

    Button back, login;
    private EditText username,password;
    SQLiteDatabase sqLiteDatabaseOB;
    SQLiteOpenHelper myDb;
    Cursor cursor;
    String UsernameHolder, PasswordHolder;
    private String TempPassword;
    private String UserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);

        back = findViewById(R.id.back_to_main);
        login = findViewById(R.id.login_teacher);
        username=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);

        myDb = new DatabaseHelper(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TeacherLogin.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UsernameHolder = username.getText().toString();
                PasswordHolder = password.getText().toString();

                sqLiteDatabaseOB = myDb.getWritableDatabase();
                cursor = sqLiteDatabaseOB.query(DatabaseHelper.TABLE_NAME2,null,"" + DatabaseHelper.tch_5 + "=?",new String[]{UsernameHolder}, null,null,null);

                while(cursor.moveToNext())
                {
                    if(cursor.moveToFirst())
                    {
                        TempPassword = cursor.getString(cursor.getColumnIndex(DatabaseHelper.tch_6));
                        UserName = cursor.getString(cursor.getColumnIndex(DatabaseHelper.tch_5));
                        cursor.close();
                    }

                }
                CheckFinalResult();

                //Intent intent = new Intent(TeacherLogin.this, Teacher_function.class);
                //startActivity(intent);
                //finish();

                }
        });
    }

    public void CheckFinalResult() {

        if(TempPassword.equals(PasswordHolder))
        {
            Toast.makeText(TeacherLogin.this,"Login Successfully",Toast.LENGTH_LONG).show();

            Intent intent = new Intent(TeacherLogin.this, Teacher_function.class);
            startActivity(intent);
            //intent.putExtra(UserName,UserName);
            finish();
        }
        else
        {
            Toast.makeText(TeacherLogin.this,"Username or Password is Incorrect, Please Try Again",Toast.LENGTH_LONG).show();
        }
        TempPassword = "NOT_FOUND";
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(TeacherLogin.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}