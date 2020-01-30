package com.example.abdul.tailormanagement;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomerSendMessage extends AppCompatActivity {
    final int SEND_SMS_PERMISSION_REQUEST_CODE = 111;
    EditText edtMessage, edtNumber;
    Button btnSend;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_send_message);

        Toolbar toolbar = (Toolbar) findViewById(R.id.emp_toolbar);
        setSupportActionBar(toolbar);


        edtMessage = (EditText) findViewById(R.id.customer_edt_message);
        edtNumber = (EditText) findViewById(R.id.cst_edt_number);
        btnSend = (Button) findViewById(R.id.cst_btn_send);

        Intent intent = this.getIntent();
        String phoneNo = intent.getExtras().getString("Phone");

        edtNumber.setText(phoneNo);

        btnSend.setEnabled(false);
        if(checkPermission(Manifest.permission.SEND_SMS)) {
            btnSend.setEnabled(true);
        }else {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.SEND_SMS},
                    SEND_SMS_PERMISSION_REQUEST_CODE);
        }

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = edtMessage.getText().toString();
                String phoneNo = edtNumber.getText().toString();
                if(!TextUtils.isEmpty(message) && !TextUtils.isEmpty(phoneNo)) {
                    Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phoneNo));
                    smsIntent.putExtra("sms_body", message);
                    startActivity(smsIntent);

                }
            }
        });

    }

    private boolean checkPermission(String permission) {
        int checkPermission = ContextCompat.checkSelfPermission(this, permission);
        return (checkPermission == PackageManager.PERMISSION_GRANTED);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case SEND_SMS_PERMISSION_REQUEST_CODE: {
                if(grantResults.length > 0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    btnSend.setEnabled(true);
                }
                return;
            }
        }
    }
}