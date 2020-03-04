package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import static java.sql.Types.INTEGER;
import static java.sql.Types.VARCHAR;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);

        myDatabase.execSQL("Create Table if not exists Users (Name VARCHAR,Age INT(3))");
        myDatabase.execSQL("INSERT INTO Users (Name,Age) VALUES ('Nick',23)");
        myDatabase.execSQL("INSERT INTO Users (Name,Age) VALUES ('Rick',28)");

        Cursor c  = myDatabase.rawQuery("SELECT * FROM Users",null);

        int NameIndex = c.getColumnIndex("Name");
        int AgeIndex  = c.getColumnIndex("Age");
        c.moveToFirst();
        while(c!= null)
        {
            Log.i("Name",c.getString(NameIndex));

            Log.i("Age",c.getString(AgeIndex));

            c.moveToNext();
        }

    }
}
