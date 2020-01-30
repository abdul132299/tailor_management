package com.example.abdul.tailormanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class About extends AppCompatActivity {

    TextView txtAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        txtAbout = (TextView)findViewById(R.id.txt_about);
        String  AboutText = "This \"Tailor Manager\" has been created with the aim of helping in taking measurements for tailoring in those moments you don't have a paper o pencil, or just don't remember all the measurements you needed to take." +
                "You'll always know where you have your measurements stored and will be able to take them at any time." +
                "In addition, now you can easily measure anybody," +
                "You can store all the measurements you want of your friends, family, clients, etc. An add a photo of thier garments and styles.\n" +
                " The Tailor Manager app offers one-click access to professional tailoring record keeping by allowing tailors to keep data of their clients, Employees digitally and also do some little calculations. Saving record digitally can help tailors in viewing the client and Employee record on the go. Changes can also be made to clients recorded measurements in very convenient way - anytime, anywhere." +
                "The app interface is user friendly and very easy to use. Level of digital media understanding for tailors was kept in mind while buildings this application. Person with almost understanding of using digital medias can still use this app.\n" +
                "\n" +
                "This Tailor Manager App was Created By an Umyuk Student Muhammad Abdullahi From Department of Mathematics and Computer Science.";
        txtAbout.setText(AboutText,null);
    }
}
