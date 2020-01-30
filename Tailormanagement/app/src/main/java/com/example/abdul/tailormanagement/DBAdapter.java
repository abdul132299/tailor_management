package com.example.abdul.tailormanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;

import static com.example.abdul.tailormanagement.Constants.ADDRESS;
import static com.example.abdul.tailormanagement.Constants.ARRIVALDATE;
import static com.example.abdul.tailormanagement.Constants.BLOUSELENGTH;
import static com.example.abdul.tailormanagement.Constants.BUST;
import static com.example.abdul.tailormanagement.Constants.Balance;
import static com.example.abdul.tailormanagement.Constants.COMMENT;
import static com.example.abdul.tailormanagement.Constants.CUSTOMERGENDER;
import static com.example.abdul.tailormanagement.Constants.CUSTOMERNAME;
import static com.example.abdul.tailormanagement.Constants.CUSTOMERSTABLE;
import static com.example.abdul.tailormanagement.Constants.CustomerID;
import static com.example.abdul.tailormanagement.Constants.Deposit;
import static com.example.abdul.tailormanagement.Constants.EMAIL;
import static com.example.abdul.tailormanagement.Constants.EMAIL_PASSWORD;
import static com.example.abdul.tailormanagement.Constants.EMPLOYEEADDRESS;
import static com.example.abdul.tailormanagement.Constants.EMPLOYEEGENDER;
import static com.example.abdul.tailormanagement.Constants.EMPLOYEEID;
import static com.example.abdul.tailormanagement.Constants.EMPLOYEENAME;
import static com.example.abdul.tailormanagement.Constants.EMPLOYEEPHONENUMBER;
import static com.example.abdul.tailormanagement.Constants.EMPLOYEERANK;
import static com.example.abdul.tailormanagement.Constants.EMPLOYEESALARY;
import static com.example.abdul.tailormanagement.Constants.EMPLOYEESTABLE;
import static com.example.abdul.tailormanagement.Constants.FINALDATE;
import static com.example.abdul.tailormanagement.Constants.FULLLENGTH;
import static com.example.abdul.tailormanagement.Constants.GARMENTPHOTO;
import static com.example.abdul.tailormanagement.Constants.HALFLENGTH;
import static com.example.abdul.tailormanagement.Constants.HANDLENGTH;
import static com.example.abdul.tailormanagement.Constants.HIPS;
import static com.example.abdul.tailormanagement.Constants.LENGTH;
import static com.example.abdul.tailormanagement.Constants.LoginTable;
import static com.example.abdul.tailormanagement.Constants.MANAGER_NAME;
import static com.example.abdul.tailormanagement.Constants.NECK;
import static com.example.abdul.tailormanagement.Constants.PASSWORD;
import static com.example.abdul.tailormanagement.Constants.PHONENUMBER;
import static com.example.abdul.tailormanagement.Constants.REENTER_PASSWORD;
import static com.example.abdul.tailormanagement.Constants.ROUNDHANDLENGTH;
import static com.example.abdul.tailormanagement.Constants.SEWINGTYPE;
import static com.example.abdul.tailormanagement.Constants.SHOULDER;
import static com.example.abdul.tailormanagement.Constants.SKIRTLENGTH;
import static com.example.abdul.tailormanagement.Constants.STYLE;
import static com.example.abdul.tailormanagement.Constants.TROUSERLENGTH;
import static com.example.abdul.tailormanagement.Constants.TotalPayment;
import static com.example.abdul.tailormanagement.Constants.USERNAME;
import static com.example.abdul.tailormanagement.Constants.WAIST;

/**
 * Created by ABDUL on 10/24/2017.
 */

public class DBAdapter {

    Context c;
    SQLiteDatabase db;
    DBHelper helper;

    public DBAdapter(Context c) {
        this.c = c;
        helper = new DBHelper(c);
    }

    //OPEN CON
    public void openDB()
    {
        try
        {
            db = helper.getWritableDatabase();
        }catch (SQLiteException e)
        {

        }
    }

    //CLOSE DB
    public void closeDB()
    {
        try
        {
            helper.close();
        }catch (SQLiteException e)
        {

        }

    }

    // Inserting data into Login Table
    public boolean insertData(String name, String email, String emailPassword, String Username, String password, String reenterPassword) {
        db = helper.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put(Constants.MANAGER_NAME, name);
        contentValue.put(Constants.EMAIL, email);
        contentValue.put(Constants.EMAIL_PASSWORD,emailPassword);
        contentValue.put(Constants.USERNAME,Username);
        contentValue.put(Constants.PASSWORD,password);
        contentValue.put(Constants.REENTER_PASSWORD, reenterPassword);
        long result = db.insert(LoginTable, null, contentValue);
        if (result == -1)
            return false;
        else
            return true;

    }

    //SAVING EMPLOYEE DATA
    public boolean addEmployee(String employeename,String employeephonenumber,String employeeaddress,String employeeGender,String employeeRank,String salary)
    {
        try
        {
            ContentValues cv = new ContentValues();
            cv.put(EMPLOYEENAME,employeename);
            cv.put(EMPLOYEEPHONENUMBER,employeephonenumber);
            cv.put(EMPLOYEEADDRESS,employeeaddress);
            cv.put(EMPLOYEEGENDER,employeeGender);
            cv.put(EMPLOYEERANK,employeeRank);
            cv.put(EMPLOYEESALARY,salary);

            long result = db.insert(EMPLOYEESTABLE, EMPLOYEEID,cv);
            if (result > 0){
                return true;
            }
        }catch (SQLiteException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    //SELECTING USERNAME
    public String getUsername() {
        db = helper.getReadableDatabase();
        String selectQuery = "SELECT Username FROM " + LoginTable;
        Cursor cursor = db.rawQuery(selectQuery, null);
        // if (cursor.getCount() != 0) {
        if (cursor.moveToFirst()) {

            String data1 = cursor.getString(cursor.getColumnIndex(USERNAME));
            return data1;
        }
        //}
        else
            return null;
    }

    //SELECTING PASSWORD
    public String getPassword() {
        db = helper.getReadableDatabase();
        String selectQuery = "SELECT password FROM " + LoginTable;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {

            String data2 = cursor.getString(cursor.getColumnIndex(PASSWORD));

            return data2;

        }
        else
            return null;
    }

    //SELECTING EMPLOYEE NAME
 public Cursor retrieveEmployeeName() {
        String [] columns= { Constants. EMPLOYEEID ,Constants. EMPLOYEENAME,Constants.EMPLOYEEPHONENUMBER,Constants.EMPLOYEEADDRESS,Constants.EMPLOYEEGENDER,Constants.EMPLOYEERANK,Constants.EMPLOYEESALARY} ;
         Cursor c=db. query( Constants. EMPLOYEESTABLE ,columns,null,null,null,null,null );
         return c;
         }

    //SELECTING All EMPLOYEE DATA
    public Cursor retrieveEmployeeData(int id) {

        String selection = "WHERE EMPLOYEEID = " + id;
        String [] columns= { Constants. EMPLOYEEID ,Constants. EMPLOYEENAME,Constants.EMPLOYEEPHONENUMBER,Constants.EMPLOYEEADDRESS,Constants.EMPLOYEEGENDER,Constants.EMPLOYEERANK,Constants.EMPLOYEESALARY} ;
        Cursor c = db. query( Constants. EMPLOYEESTABLE ,columns,selection ,null,null,null,null);
        return c;
    }

    public int getOveralTotal() {
        db = helper.getReadableDatabase();
        int total = 0;
        Cursor cursor = db.rawQuery("SELECT SUM(" + Constants.TotalPayment + ") as TotalPayment FROM " + Constants.CUSTOMERSTABLE, null);

            if (cursor.moveToFirst())
             total = cursor.getInt(cursor.getColumnIndex("TotalPayment"));// get final total

        return total;


    }


    //UPDATING OR EDIT
    public boolean updateEmployeeData(String newName,int newId,String newEmployeePhoneNumber,String newEmployeeAddress,String newEmployeeGender,String newEmployeeRank,String newEmployeeSalary)
    {
        try
            {
                ContentValues cv= new ContentValues () ;
                cv.put(EMPLOYEENAME,newName);
                cv.put(EMPLOYEEPHONENUMBER,newEmployeePhoneNumber);
                cv.put(EMPLOYEEADDRESS,newEmployeeAddress);
                cv.put(EMPLOYEEGENDER,newEmployeeGender);
                cv.put(EMPLOYEERANK,newEmployeeRank);
                cv.put(EMPLOYEESALARY,newEmployeeSalary);

                int result=db. update( Constants.EMPLOYEESTABLE ,cv, Constants.EMPLOYEEID + " =?" , new String []{ String .valueOf( newId )}) ;
                if ( result> 0)
                 {
                    return true;
                 }
            } catch ( SQLException e ) {
                 e.printStackTrace ();
                }
             return false;
    }



    //DELETING EMPLOYEE
    public boolean deleteEmployee(int id)
    {
        try
        {
            int result = db.delete(EMPLOYEESTABLE, EMPLOYEEID+" =?",new String[]{String.valueOf(id)});
            if (result > 0)
            {
                return true;
            }
        }catch (SQLiteException e)
        {
            e.printStackTrace();
        }

        return false;
    }
    //SAVING CUSTOMER INTO THE DATABASE
    public boolean addCustomer(String Customername, String phonenumber, String address, String Customergender, String arrivaldate, String finaldate,
                               String bust, String waist, String hips, String blouselength, String halflength, String fulllength, String handlength,
                               String roundhandlength, String skirtlengtth, String shoulder, String length, String neck, String trouserlength, String sewingtype,
                               byte[] garmentphoto,byte[] style,String comment,String totalpayment,String deposit,String balance)
    {
        try
        {
            ContentValues cv = new ContentValues();
            cv.put(CUSTOMERNAME,Customername);
            cv.put(PHONENUMBER,phonenumber);
            cv.put(ADDRESS,address);
            cv.put(CUSTOMERGENDER,Customergender);
            cv.put(ARRIVALDATE,arrivaldate);
            cv.put(FINALDATE,finaldate);
            cv.put(BUST,bust);
            cv.put(WAIST,waist);
            cv.put(HIPS,hips);
            cv.put(BLOUSELENGTH,blouselength);
            cv.put(HALFLENGTH,halflength);
            cv.put(FULLLENGTH,fulllength);
            cv.put(HANDLENGTH,handlength);
            cv.put(ROUNDHANDLENGTH,roundhandlength);
            cv.put(SKIRTLENGTH,skirtlengtth);
            cv.put(SHOULDER,shoulder);
            cv.put(LENGTH,length);
            cv.put(NECK,neck);
            cv.put(TROUSERLENGTH,trouserlength);
            cv.put(GARMENTPHOTO,garmentphoto);
            cv.put(STYLE,style);
            cv.put(COMMENT,comment);
            cv.put(SEWINGTYPE,sewingtype);
            cv.put(TotalPayment,totalpayment);
            cv.put(Deposit,deposit);
            cv.put(Balance,balance);

            long result = db.insert(CUSTOMERSTABLE, null,cv);
            if (result > 0){
                return true;
            }
        }catch (SQLiteException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    //SELECTING CUSTOMER NAME
    public Cursor retrieveCustomerName() {
        String [] columns= {Constants. CustomerID ,Constants. CUSTOMERNAME,Constants.PHONENUMBER,Constants.ADDRESS,Constants.CUSTOMERGENDER,Constants.ARRIVALDATE,Constants.FINALDATE,
                Constants.BUST,Constants.WAIST,Constants.HIPS,Constants.BLOUSELENGTH,Constants.HALFLENGTH,Constants.FULLLENGTH,Constants.HANDLENGTH,
                Constants.ROUNDHANDLENGTH,Constants.SKIRTLENGTH,Constants.SHOULDER,Constants.LENGTH,Constants.NECK,Constants.TROUSERLENGTH,Constants.SEWINGTYPE,
                Constants.GARMENTPHOTO,Constants.STYLE,Constants.COMMENT,Constants.TotalPayment,Constants.Deposit,Constants.Balance} ;
        Cursor c = db. query( Constants. CUSTOMERSTABLE ,columns,null,null,null,null,null );
        return c;
    }


    //DELETING CUSTOMER
    public boolean deleteCustomer(int id)
    {
        try
        {
            int result = db.delete(CUSTOMERSTABLE, CustomerID+" =?",new String[]{String.valueOf(id)});
            if (result > 0)
            {
                return true;
            }
        }catch (SQLiteException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    //UPDATING OR EDIT
    public boolean updateCustomerData(String newName,int newId,String newPhoneNumber,String newAddress,String newGender,String newArivalDate,String newFinalDate,
    String newBust,String newWaist,String newHips,String newBlouseLength,String newHalfLength,String newFullLength,String newHandLength,
                                      String newRoundHandLength,String newSkirtLength,String newShoulder,String newLength,String newNeck,
                                      String newTrouserLength,byte[] newGarment,byte[] newStyle,String  newComment,
                                      String newSewingType,String newTotalPayment,String newDeposit,String newBalance)
    {
        try
        {
            ContentValues cv= new ContentValues () ;
            cv.put(CUSTOMERNAME,newName);
            cv.put(PHONENUMBER,newPhoneNumber);
            cv.put(ADDRESS,newAddress);
            cv.put(CUSTOMERGENDER,newGender);
            cv.put(ARRIVALDATE,newArivalDate);
            cv.put(FINALDATE,newFinalDate);
            cv.put(BUST,newBust);
            cv.put(WAIST,newWaist);
            cv.put(HIPS,newHips);
            cv.put(BLOUSELENGTH,newBlouseLength);
            cv.put(HALFLENGTH,newHalfLength);
            cv.put(FULLLENGTH,newFullLength);
            cv.put(HANDLENGTH,newHandLength);
            cv.put(ROUNDHANDLENGTH,newRoundHandLength);
            cv.put(SKIRTLENGTH,newSkirtLength);
            cv.put(SHOULDER,newShoulder);
            cv.put(LENGTH,newLength);
            cv.put(NECK,newNeck);
            cv.put(TROUSERLENGTH,newTrouserLength);
            cv.put(GARMENTPHOTO,newGarment);
            cv.put(STYLE,newStyle);
            cv.put(COMMENT,newComment);
            cv.put(SEWINGTYPE,newSewingType);
            cv.put(TotalPayment,newTotalPayment);
            cv.put(Deposit,newDeposit);
            cv.put(Balance,newBalance);

            int result=db. update( Constants.CUSTOMERSTABLE ,cv, Constants.CustomerID + " =?" , new String []{ String .valueOf( newId )}) ;
            if ( result> 0)
            {
                return true;
            }
        } catch ( SQLException e ) {
            e.printStackTrace ();
        }

        return false;
    }

}
