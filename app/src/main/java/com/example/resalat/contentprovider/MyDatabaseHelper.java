package com.example.resalat.contentprovider;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by resalat on 11/3/2016.
 */

public class MyDatabaseHelper  extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "student_table";
        public static final String COL_1 = "NAME";




    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME +" (NAME TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }


}
