package com.example.resalat.contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by resalat on 11/3/2016.
 */

public class MyContentProvider extends ContentProvider {

    SQLiteDatabase db;
    static final String PROVIDER_NAME = "com.example.resalat.MyContentProvider";
    static final String URL = "content://" + PROVIDER_NAME ;
    static final Uri CONTENT_URI = Uri.parse(URL);


    @Override
    public boolean onCreate() {

        MyDatabaseHelper myDb = new MyDatabaseHelper(getContext());
        db = myDb.getWritableDatabase();
       // if(db != null)
            return true;

        //return false;



    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        Cursor cursor = db.query("student_table", null, null, null, null, null, null);
        return cursor;

    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        long rowId =  db.insert("student_table", null, contentValues);

        Uri uri2 = ContentUris.withAppendedId(CONTENT_URI, rowId);

        return uri2;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        int id = db.delete("student_table", null, null);
        return id;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        int id = db.update("student_table", contentValues, null, null);
        return id;
    }
}
