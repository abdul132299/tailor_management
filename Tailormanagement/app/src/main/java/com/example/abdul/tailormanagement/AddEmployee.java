package com.example.abdul.tailormanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddEmployee extends AppCompatActivity {
    EditText edtName,edtPhoneNumber,edtAddress,edtRank,edtSalary;
    Button btnSave;
    RadioGroup genderRadioGroup;
    RadioButton employeeGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        genderRadioGroup = (RadioGroup)findViewById(R.id.gender);
        edtName = (EditText)findViewById(R.id.edit_employee_name);
        edtPhoneNumber = (EditText)findViewById(R.id.edit_employee_phone_number);
        edtAddress = (EditText)findViewById(R.id.edit_employee_address);
        edtSalary = (EditText)findViewById(R.id.edit_employee_salary);
        edtRank = (EditText)findViewById(R.id.edit_employee_rank);
        btnSave = (Button)findViewById(R.id.btn_employee_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String employeeName = edtName.getText().toString();
                String employeePhoneNumber = edtPhoneNumber.getText().toString();
                String employeeAddress = edtAddress.getText().toString();
               // String Gender = employeeGender.getText().toString();
                String employeeRank = edtRank.getText().toString();
                String employeeSalary = edtSalary.getText().toString();

                if (employeeName.isEmpty() && employeePhoneNumber.isEmpty() && employeeAddress.isEmpty()  && employeeRank.isEmpty() && employeeSalary.isEmpty()){
                    Toast.makeText(AddEmployee.this, "All Field Are Required", Toast.LENGTH_SHORT).show();
                }
                else {
                   SaveEmployeeRecord();
                    edtName.setText("");
                    edtPhoneNumber.setText("");
                    edtAddress.setText("");
                    edtRank.setText("");
                    edtSalary.setText("");

                }

            }
        });
    }

    public void SaveEmployeeRecord(){
       DBAdapter db = new DBAdapter(this);
        db.openDB();
        int id = genderRadioGroup.getCheckedRadioButtonId();
        employeeGender = (RadioButton)findViewById(id);


        boolean saved = db.addEmployee( edtName.getText().toString(),
                edtPhoneNumber.getText().toString(),
                edtAddress.getText().toString(),
                employeeGender.getText().toString(),
                edtRank.getText().toString(),
                edtSalary.getText().toString());

            if (saved == true) {

                Toast.makeText(AddEmployee.this, "Employee IS Added", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddEmployee.this,Employees.class);
                startActivity(intent);
            } else {
                Toast.makeText(AddEmployee.this, "DATA NOT INSERTED", Toast.LENGTH_SHORT).show();
            }

    }


}
