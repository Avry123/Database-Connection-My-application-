package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "MCA_FY.db";

    public DatabaseHelper(@Nullable Context context) {
//        super(context, this , null , "1");
        super(context,DB_NAME,null,1);
        SQLiteDatabase database = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS FYMCA (rollNo INTEGER PRIMARY KEY, username TEXT, password TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insertValue(Integer rollNo, String username, String password) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("rollNo", rollNo);
        values.put("username", username);
        values.put("password", password);
        long e = database.insert("FYMCA", null, values);
        if (e != -1) {
           return true;
        } else {
            return false;
        }
    }
}
