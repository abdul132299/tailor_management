package com.example.abdul.tailormanagement;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Employees extends AppCompatActivity {

    EditText edtName,edtPhoneNumber,edtAddress,edtRank,edtSalary,employeeUpdateGender;
    Button btnUpdate;
    ListView employeesList = null;
    SearchView sv;
    final Boolean forUpdate = true;
    ArrayList<Emp> employees = new ArrayList<>();
    EmployeeAdapter adapter= new EmployeeAdapter( this,employees) ;
    public int upId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        employeesList = (ListView) findViewById(R.id.employees_list);
        sv=(SearchView) findViewById(R.id.emp_searchView1);

        adapter = new EmployeeAdapter( this,employees) ;
        this.getEmployees ();
        //this.getAllEmployeesData();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }


        });
        /*edtSearch = (EditText)findViewById(R.id.employee_edit_search);
        // Enabling Search Filter
        edtSearch.addTextChangedListener(new TextWatcher() {
                                             @Override
                                             public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                                 // TODO Auto-generated method stub
                                             }

                                             @Override
                                             public void onTextChanged(CharSequence s, int start, int before, int count) {
                                                 // When user changed the Text
                                                 Employees.this.adapter.getFilter().filter(s);

                                             }
                                             @Override
                                             public void afterTextChanged(Editable s) {
                                                 // TODO Auto-generated method stub
                                             }
                                         });*/


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Employees.this,AddEmployee.class);
                startActivity(intent);
            }
        });
    }

    public void alertMessage()
    {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        delete();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        Toast.makeText(Employees.this, "You Click No", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Are you sure you want to Delete this Data").setPositiveButton("Yes",dialogClickListener).setNegativeButton("No",dialogClickListener).show();
    }

    //RETRIEVE OR getEmployees
    private void getEmployees () {
        employees. clear() ;

      DBAdapter db = new DBAdapter( this);

      db. openDB() ;

        Cursor c = db.retrieveEmployeeName();
       Emp employee = null;
       while ( c. moveToNext())
        {
          int id = c. getInt(0);
             String name = c.getString(1) ;
            String phone = c.getString(2) ;
            String address = c.getString(3) ;
            String gender = c.getString(4) ;
            String rank = c.getString(5) ;
            String salary = c.getString(6) ;


            employee= new Emp() ;

            employee. setId( id );
            employee.setEmployeename(name);
            employee.setEmployeephonenumber(phone);
            employee.setEmployeeaddress(address);
            employee.setEmployeeGender(gender);
            employee.setEmployeeRank(rank);
            employee.setSalary(salary);


            employees.add( employee );
        }
         db. closeDB() ;
         employeesList.setAdapter( adapter );
    }

     //UPDATE OR EDIT
     public void update (String newName,String newEmployeePhoneNumber,String newEmployeeAddress,String newEmployeeGender,String newEmployeeRank,String newEmployeeSalary){

            //GET ID OF Emp
           int upId=adapter.getSelectedItemID();

            //UPDATE IN DB
           DBAdapter db= new DBAdapter(this);
            db. openDB() ;
            boolean updated = db.updateEmployeeData(newName,upId,newEmployeePhoneNumber,newEmployeeAddress,newEmployeeGender,newEmployeeRank,newEmployeeSalary);
            db. closeDB() ;
            if( updated )
            {

                edtName.setText (newName );
                edtPhoneNumber.setText (newEmployeePhoneNumber );
                edtAddress.setText (newEmployeeAddress );
                employeeUpdateGender.setText (newEmployeeGender );
                edtRank.setText (newEmployeeRank );
                edtSalary.setText (newEmployeeSalary );

                getEmployees(); ;
             }else
                 {
                    Toast.makeText( this,"Unable To Update" ,Toast.LENGTH_SHORT ). show() ;
                 }
     }




    private void delete(){

        //GET ID
        int id = adapter.getSelectedItemID() ;

        //DELETE FROM DB
        DBAdapter db = new DBAdapter( this);
         db. openDB() ;
        boolean deleted = db.deleteEmployee(id);
        db. closeDB() ;
         if( deleted )
             {

                getEmployees();
             }else
            {
                Toast.makeText( this,"Unable To Delete" ,Toast.LENGTH_SHORT ).show() ;
            }
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        CharSequence title=item. getTitle();
        if
                ( title == "DELETE" )
           {

               alertMessage();
            }else
           {
                displayDialogue(false);
            //Intent intent = new Intent(Employees.this,UpdateEmployee.class);
            //   startActivity(intent);
           }
        return super .onContextItemSelected (item) ;
    }

    public void displayDialogue(Boolean forUpdate){
        Dialog d = new Dialog(this);
        d.setTitle("EDIT EMPLOYEE DATA");
        d.setContentView(R.layout.activity_update_employee);
        employeeUpdateGender = (EditText)d.findViewById(R.id.edit_employee_gender);
        edtName = (EditText)d.findViewById(R.id.edit_employee_name);
        edtPhoneNumber = (EditText)d.findViewById(R.id.edit_employee_phone_number);
        edtAddress = (EditText)d.findViewById(R.id.edit_employee_address);
        edtSalary = (EditText)d.findViewById(R.id.edit_employee_salary);
        edtRank = (EditText)d.findViewById(R.id.edit_employee_rank);
        btnUpdate = (Button)d.findViewById(R.id.btn_employee_save);

        edtName.setText(adapter.getSelectedItemName());
        edtPhoneNumber.setText(adapter.getSelectedItemPhoneNo());
        edtAddress.setText(adapter.getSelectedItemAddress());
        employeeUpdateGender.setText(adapter.getSelectedItemGender());
        edtRank.setText(adapter.getSelectedItemRank());
        edtSalary.setText(adapter.getSelectedItemSalary());
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update(edtName.getText().toString(),
                        edtPhoneNumber.getText().toString(),
                        edtAddress.getText().toString(),
                        employeeUpdateGender.getText().toString(),
                        edtRank.getText().toString(),
                        edtSalary.getText().toString());
                finish();
            }
        });

        d.show();
    }

}



