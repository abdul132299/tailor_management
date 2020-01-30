package com.example.abdul.tailormanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
   DBAdapter mydb;
    EditText editname,editusername,editpassword,editreenter_password,editemail,editemailpassword;
    Button btnsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DBAdapter(this);

        editname =(EditText)findViewById(R.id.Edit_text_name);
        editusername =(EditText)findViewById(R.id.Edit_text_username);
        editpassword =(EditText)findViewById(R.id.Edit_text_password);
        editreenter_password =(EditText)findViewById(R.id.Edit_text_reenter_password);
        editemail =(EditText)findViewById(R.id.Edit_text_email);
        editemailpassword =(EditText)findViewById(R.id.Edit_text_email_password);
        btnsubmit =(Button) findViewById(R.id.submit_button);

        signUp();
    }

    public void signUp(){
        onSignUpSuccessfull();

         }

    public void onSignUpSuccessfull() {
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ManagerName = editname.getText().toString();
                String ManagerEmail = editemail.getText().toString();
                String ManagerEmailPassword = editemailpassword.getText().toString();
                String ManagerUsername = editusername.getText().toString();
                String ManagerPassword = editpassword.getText().toString();
                String ManagerRePassword = editreenter_password.getText().toString();

               boolean isInserted = mydb.insertData(ManagerName,ManagerEmail,ManagerEmailPassword,ManagerUsername,ManagerPassword, ManagerRePassword);

                if (isInserted == true) {
                    Toast.makeText(MainActivity.this, "DATA IS INSERTED", Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(MainActivity.this,Login.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "DATA NOT INSERTED", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

