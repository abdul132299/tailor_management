package com.example.abdul.tailormanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ABDUL on 10/24/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, Constants.DatabaseName, null, Constants.DBVERSION);    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try
        {
            db.execSQL(Constants.CREATE_CUSTOMER_TABLE);
            db.execSQL(Constants.CREATE_MANAGER_TABLE);
            db.execSQL(Constants.CREATE_EMPLOYEE_TABLE);



        }catch (SQLiteException e)
        {

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(Constants.DROP_MANAGER_TABLE);
        db.execSQL(Constants.DROP_EMPLOYEE_TABLE);
        db.execSQL(Constants.DROP_CUSTOMER_TABLE);

        onCreate(db);


    }
}
