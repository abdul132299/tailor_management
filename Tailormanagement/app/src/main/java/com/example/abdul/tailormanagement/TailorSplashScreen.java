package com.example.abdul.tailormanagement;

import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TailorSplashScreen extends AppCompatActivity {
    DBAdapter mydb;
    String username,password;
    private static int Splash_Time_Out = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tailor_splash_screen);

        mydb = new DBAdapter(this);
        username = mydb.getUsername();
        password = mydb.getPassword();
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){

                if(username != null && password != null){
                Intent intent = new Intent(TailorSplashScreen.this,Login.class);
                startActivity(intent);
                }
                else{
                    Intent intent = new Intent(TailorSplashScreen.this,MainActivity.class);
                    startActivity(intent);
                }

                finish();
            }
        },Splash_Time_Out);
    }
}
