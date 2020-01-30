package com.example.abdul.tailormanagement;

/**
 * Created by ABDUL on 10/16/2017.
 */

public class Constants {

    //MANAGER CONSTANTS
    static final String ROW_ID = "id";
    static final String MANAGER_NAME = "managerName";
    static final String EMAIL = "email";
    static final String EMAIL_PASSWORD = "emailPassword";
    static final String USERNAME = "username";
    static final String PASSWORD = "password";
    static final String REENTER_PASSWORD = "reenterPassword";
    //EMPLOYEE CONSTANTS
    static final String EMPLOYEEID = "employeeId";
    static final String EMPLOYEENAME = "employeename";
    static final String EMPLOYEEPHONENUMBER = "employeephonenumber";
    static final String EMPLOYEEADDRESS = "employeeaddress";
    static final String EMPLOYEEGENDER= "employeeGender";
    static final String EMPLOYEERANK= "employeeRank";
    static final String EMPLOYEESALARY = "salary";

    //CUSTOMER CONSTANT
    static final String CustomerID = "CustomerId";
    static final String CUSTOMERNAME = "Customername";
    static final String PHONENUMBER = "phonenumber";
    static final String ADDRESS = "address";
    static final String ARRIVALDATE = "arrivaldate";
    static final String FINALDATE = "finaldate";
    static final String CUSTOMERGENDER = "Customergender";
    static final String BUST = "bust";
    static final String WAIST = "waist";
    static final String HIPS = "hips";
    static final String BLOUSELENGTH = "blouselength";
    static final String HALFLENGTH = "halflength";
    static final String FULLLENGTH = "fulllength";
    static final String HANDLENGTH = "handlength";
    static final String ROUNDHANDLENGTH = "roundhandlength";
    static final String SKIRTLENGTH = "skirtlength";
    static final String SHOULDER = "shoulder";
    static final String LENGTH = "length";
    static final String NECK = "neck";
    static final String TROUSERLENGTH = "trouserlength";
    static final String TotalPayment = "totalpayment";
    static final String Deposit = "deposit";
    static final String Balance = "balance";
    static final String SEWINGTYPE = "sewingtype";
    static final String GARMENTPHOTO = "garmentphoto";
    static final String STYLE = "style";
    static final String COMMENT = "comment";

    //DB PROPERTY
    static final String DatabaseName = "TailorDataBank";
    static final String LoginTable = "LoginTable";
    static final String EMPLOYEESTABLE = "EMPLOYEESTABLE";
    static final String CUSTOMERSTABLE = "CUSTOMERSTABLE";
    static final int DBVERSION = 1;

    //CREATE TABLE QUERY
    static final String CREATE_MANAGER_TABLE = "CREATE TABLE LoginTable(id INTEGER PRIMARY KEY AUTOINCREMENT,managerName TEXT,email TEXT,emailPassword TEXT,username TEXT,password TEXT,reenterPassword TEXT)";
    static final String CREATE_EMPLOYEE_TABLE = "CREATE TABLE EMPLOYEESTABLE(employeeId INTEGER PRIMARY KEY AUTOINCREMENT,employeename TEXT,employeephonenumber TEXT,employeeaddress TEXT,employeeGender TEXT,employeeRank TEXT,salary TEXT)";
    static final String CREATE_CUSTOMER_TABLE = "CREATE TABLE CUSTOMERSTABLE(CustomerId INTEGER PRIMARY KEY AUTOINCREMENT,Customername TEXT,phonenumber TEXT,address TEXT,Customergender TEXT,arrivaldate TEXT,finaldate TEXT,bust TEXT,waist TEXT,hips TEXT,blouselength TEXT,halflength TEXT,fulllength TEXT,handlength TEXT,roundhandlength TEXT,skirtlength TEXT,shoulder TEXT,length TEXT,neck TEXT,trouserlength TEXT,sewingtype TEXT,garmentphoto BLOB,style BLOB,comment TEXT,totalpayment TEXT,deposit TEXT,balance TEXT)";


    //DROP TABLE STATEMENT
    static final String DROP_MANAGER_TABLE = "DROP TABLE IF EXISTS "+LoginTable;
    static final String DROP_EMPLOYEE_TABLE = "DROP TABLE IF EXISTS "+EMPLOYEESTABLE;
    static final String DROP_CUSTOMER_TABLE = "DROP TABLE IF EXISTS "+CUSTOMERSTABLE;

    public static String getDatabaseName() {
        return DatabaseName;
    }

    public static String getEMPLOYEESTABLE() {
        return EMPLOYEESTABLE;
    }

    public static String getCUSTOMERSTABLE() {
        return CUSTOMERSTABLE;
    }

    public static String getLoginTable() {
        return LoginTable;
    }
}
