package com.example.abdul.tailormanagement;
 
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    DBAdapter mydb;

    Button btnlogin;
    EditText editloginusername, editloginpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // create a instance of SQLite Database
        mydb = new DBAdapter(this);

        //get the refrence of EditTexts and Button
        editloginusername = (EditText) findViewById(R.id.Edit_text_login_username);
        editloginpassword = (EditText) findViewById(R.id.Edit_text_login_password);
        btnlogin = (Button) findViewById(R.id.Button_login);
        //set onClicked Listener on btnlogin
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login();
            }
        });
    }

    public void login() {

        String loginusername = editloginusername.getText().toString();
        String loginpassword = editloginpassword.getText().toString();
        String UserName = mydb.getUsername().toString();
        String Password = mydb.getPassword().toString();

       if (loginusername.equalsIgnoreCase(UserName) && loginpassword.equalsIgnoreCase(Password)) {
           onloginSuccessfull();

       }else {
           Toast.makeText(getBaseContext(), "Incorrect UserName or Password", Toast.LENGTH_LONG).show();
           onloginFailed();
           return;
        }

    }

    public void onloginSuccessfull() {
        Intent intent = new Intent(Login.this,Home.class);
        startActivity(intent);
        finish();

    }

    public void onloginFailed() {
        Toast.makeText(getBaseContext(), "Login Failed", Toast.LENGTH_LONG).show();
    }

    public boolean validate() {
        boolean valid = true;
        String loginusername = editloginusername.getText().toString();
        String loginpassword = editloginpassword.getText().toString();

            if (loginusername.isEmpty()) {
                editloginusername.setError("Incorrect User Name");

                valid = false;
            } else {
                editloginusername.setError(null);
            }

            if (loginpassword.isEmpty() || loginpassword.length() < 4) {
                editloginpassword.setError("Invalid Password or to short");
                valid = false;
            } else {
                editloginpassword.setError(null);
            }

        return valid;

    }

}

