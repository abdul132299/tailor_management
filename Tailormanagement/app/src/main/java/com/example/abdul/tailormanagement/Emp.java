package com.example.abdul.tailormanagement;

/**
 * Created by ABDUL on 10/24/2017.
 */

public class Emp {
    int id;
    String employeename, employeephonenumber,employeeaddress,employeeGender,employeeRank,salary;

    public Emp() {
    }

    public Emp(String employeename, String employeephonenumber, String employeeaddress, String employeeGender, String employeeRank, String salary) {
        this.employeename = employeename;
        this.employeephonenumber = employeephonenumber;
        this.employeeaddress = employeeaddress;
        this.employeeGender = employeeGender;
        this.employeeRank = employeeRank;
        this.salary = salary;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getEmployeephonenumber() {
        return employeephonenumber;
    }

    public void setEmployeephonenumber(String employeephonenumber) {
        this.employeephonenumber = employeephonenumber;
    }

    public String getEmployeeaddress() {
        return employeeaddress;
    }

    public void setEmployeeaddress(String employeeaddress) {
        this.employeeaddress = employeeaddress;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeRank() {
        return employeeRank;
    }

    public void setEmployeeRank(String employeeRank) {
        this.employeeRank = employeeRank;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
