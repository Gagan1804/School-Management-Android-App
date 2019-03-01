package com.gstar.schoolmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Address;

import static android.os.Build.ID;
import static android.os.Build.PRODUCT;

public class DatabaseHelper extends SQLiteOpenHelper
{

    static String DATABASE_NAME = "gagan_School.db";

    public static final String TABLE_NAME1 = "student_and_parent_table1";
    public static final String stud_1 = "ID";
    // ID is the primary key here
    //it is also foreign key for exam_table column StudentRegNo
    public static final String stud_2 = "Name";
    public static final String stud_3 = "FatherName";
    public static final String stud_4 = "MotherName";
    public static final String stud_5 = "ParentEmail";
    public static final String stud_6 = "FatherPhoneNumber";
    public static final String stud_7 = "MotherPhoneNumber";
    public static final String stud_8 = "Address";
    public static final String stud_9 = "UserName";
    public static final String stud_10 = "Password";


    public static final String TABLE_NAME2 = "teacher_table1";
    public static final String tch_1 = "ID";
    // ID is the primary key here
    public static final String tch_2 = "Name";
    public static final String tch_3 = "Email";
    public static final String tch_4 = "MobileNumber";
    public static final String tch_5 = "Username";
    public static final String tch_6 = "Password";
    public static final String tch_7 = "Address";
    public static final String tch_8 = "Qualification";


    public static final String TABLE_NAME3 = "exam_table1";
    public static final String exm_1 = "StudentName";
    public static final String exm_2 = "StudentID";
    // StudentRegNo is the primary key here because it is always unique for everyone... but Actually it has values from ID column of student_table
    public static final String exm_3 = "SubjectName";
    public static final String exm_4 = "SubjectCode";
    public static final String exm_5 = "MaxMarks";
    public static final String exm_6 = "MarksScoredByStudent";
    public static final String exm_7 = "Grade";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        //String query3 = "CREATE TABLE IF NOT EXISTS \"teacher_table1\" ( `ID` integer PRIMARY KEY AUTOINCREMENT, `Name` TEXT, `Email` TEXT, `MobileNumber` INTEGER, `Username` TEXT, `Password` text, `Address` text, `Qualification` TEXT )";
        //db.execSQL(query3);

       // String query4 = "CREATE TABLE IF NOT EXISTS \"exam_table1\" ( `StudentName` TEXT, `Student RegNo` TEXT, `SubjectName` TEXT, `SubjectCode` TEXT, `MaxMarks` INTEGER, `MarksScoredByStudent` INTEGER, `Grade` TEXT, PRIMARY KEY(`SubjectCode`,`Student RegNo`))";
        //db.execSQL(query4);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        onCreate(db);

    }

    public boolean insertStudentData(String name, String FatherName, String MotherName, String ParentEmail, String FatherPhoneNumber, String MotherPhoneNumber, String Address, String UserName, String Password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(stud_2,name);
        contentValues1.put(stud_3,FatherName);
        contentValues1.put(stud_4,MotherName);
        contentValues1.put(stud_5,ParentEmail);
        contentValues1.put(stud_6,FatherPhoneNumber);
        contentValues1.put(stud_7,MotherPhoneNumber);
        contentValues1.put(stud_8,Address);
        contentValues1.put(stud_9,UserName);
        contentValues1.put(stud_10,Password);


        long result1 = db.insert(TABLE_NAME1, null, contentValues1);
        if(result1 == -1)
        {
            return false;
        }
        else
            {
                return true;
            }
    }

    public boolean insertTeacherData(String Name, String Username, String Password, String MobileNumber, String Email, String Address,String Qualification)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put(tch_2,Name);
        contentValues3.put(tch_3,Email);
        contentValues3.put(tch_4,MobileNumber);
        contentValues3.put(tch_5,Username);
        contentValues3.put(tch_6,Password);
        contentValues3.put(tch_7,Address);
        contentValues3.put(tch_8,Qualification);

        long result3 = db.insert(TABLE_NAME2, null, contentValues3);
        if(result3 == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean insertResultData(String StudentName, String SubjectName, String SubjectCode, String MaxMarks, String MarksScoredByStudent, String Grade)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues4 = new ContentValues();
        contentValues4.put(exm_1,StudentName);
        //contentValues4.put(exm_2,StudentID);
        contentValues4.put(exm_3,SubjectName);
        contentValues4.put(exm_4,SubjectCode);
        contentValues4.put(exm_5,MaxMarks);
        contentValues4.put(exm_6,MarksScoredByStudent);
        contentValues4.put(exm_7,Grade);

        long result4 = db.insert(TABLE_NAME3, null, contentValues4);
        if(result4 == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Cursor viewStudent_ParentData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query1 = "SELECT * FROM " + TABLE_NAME1;
        Cursor cursor = db.rawQuery(query1,null);
        return cursor;
    }

    public Cursor viewTeacherData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query2 = "SELECT * FROM " + TABLE_NAME2;
        Cursor cursor = db.rawQuery(query2,null);
        return cursor;
    }

    public Cursor viewExamData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query3 = "SELECT * FROM " + TABLE_NAME3;
        Cursor cursor = db.rawQuery(query3,null);
        return cursor;
    }

    /*public String searchStudentPass(String uname)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT UserName, Password FROM "+TABLE_NAME1;
        Cursor cursor = db.rawQuery(query,null);
        cursor = db.query()
        String a,b;
        b = "Not Found";

        if(cursor.moveToFirst())
        {
            do {
                a = cursor.getString(0);
                if(a.equals(uname))
                {
                    b=cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return  b;
    }*/

}
