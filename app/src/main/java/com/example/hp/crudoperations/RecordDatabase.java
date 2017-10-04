package com.example.hp.crudoperations;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HP on 8/26/2017.
 */
public class RecordDatabase extends SQLiteOpenHelper {
    public static final String Database_name = "Student_Record.db";
    public static final String Table_name = "students";
    public static final String id = "Id";
    public static final String name = "Name";
    public static final String email = "Email";
    public static final String address = "Address";
    public static String contact = "Contact";


    public RecordDatabase(Context context) {
        super(context, Database_name, null, 1);
        SQLiteDatabase db= this.getWritableDatabase();


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Students(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,ADDRESS VARCHAR,EMAIL VARCHAR,CONTACT INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_name);
        onCreate(db);
    }

    public boolean Insert_data(String Name, String Email, String Address, int Contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("NAME", Name);
        value.put("ADDRESS", Email);
        value.put("EMAIL", Address);
        value.put("CONTACT", Contact);
        long result = db.insert(Table_name, null, value);
        if (result == -1) {
            return false;
        } else {
            return true;
        }


    }
}