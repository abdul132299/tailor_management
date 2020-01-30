package com.example.abdul.tailormanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class EmployeeData extends AppCompatActivity {

    TextView txtEmployeeName,txtEmployeePhone,txtEmployeeAddress,txtEmployeeGender,txtEmployeeRank,txtEmployeeSalary,
            txtEmployeeNameValue,txtEmployeePhoneValue,txtEmployeeAddressValue,txtEmployeeGenderValue,txtEmployeeRankValue,txtEmployeeSalaryValue;

    ImageButton btnEmpMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.emp_toolbar);
        setSupportActionBar(toolbar);

        btnEmpMessage = (ImageButton) findViewById(R.id.emp_btn_message);
        txtEmployeeName = (TextView)findViewById(R.id.txt_emp_Name);
        txtEmployeeNameValue = (TextView)findViewById(R.id.txt_emp_name_value);
        txtEmployeePhone  = (TextView)findViewById(R.id.txt_emp_phoneNumber);
        txtEmployeePhoneValue = (TextView)findViewById(R.id.txt_emp_phoneNumber_value);
        txtEmployeeAddress = (TextView)findViewById(R.id.txt_emp_address);
        txtEmployeeAddressValue = (TextView)findViewById(R.id.txt_emp_address_value);
        txtEmployeeGender = (TextView)findViewById(R.id.txt_emp_gender);
        txtEmployeeGenderValue= (TextView)findViewById(R.id.txt_emp_gender_value);
        txtEmployeeRank = (TextView)findViewById(R.id.txt_emp_rank);
        txtEmployeeRankValue = (TextView)findViewById(R.id.txt_emp_rank_value);
        txtEmployeeSalary= (TextView)findViewById(R.id.txt_emp_salary);
        txtEmployeeSalaryValue = (TextView)findViewById(R.id.txt_emp_salary_value);





        Intent intent = this.getIntent();

        final String name = intent.getExtras().getString("Name");
        final String phone = intent.getExtras().getString("Phone");
        final String address = intent.getExtras().getString("Address");
        final String gender = intent.getExtras().getString("Gender");
        final String rank = intent.getExtras().getString("Rank");
        final String salary = intent.getExtras().getString("Salary");

        txtEmployeeNameValue.setText(name);
        txtEmployeePhoneValue.setText(phone);
        txtEmployeeAddressValue.setText(address);
        txtEmployeeGenderValue.setText(gender);
        txtEmployeeRankValue.setText(rank);
        txtEmployeeSalaryValue.setText(salary);


        btnEmpMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeData.this,EmpSendMessage.class);
                intent.putExtra("Phone",phone);

                startActivity(intent);
            }
        });
    }
}
