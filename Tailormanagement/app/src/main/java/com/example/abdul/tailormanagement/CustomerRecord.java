package com.example.abdul.tailormanagement;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomerRecord extends AppCompatActivity {
    TextView txtCustomerName,txtCustomerPhone,txtCustomerAddress,txtCustomerGender,txtArrivalDate,txtFinalDate,
            txtBust,txtWaist,txtHips,txtBlouseLength,txtHalfLength,txtFullLength,txtHandLength,txtRoundHandLength,txtSkirtLength,txtShoulder,
            txtLength,txtNeck,txtTrouserLength,txtSewingType,txtComment,txtTotalPayment,txtDeposit,txtBalance,txtProfileDetails,txtMeasurement,txtSewingDetails,txtPaymentDetails;

    TextView txtCustomerNameValue,txtCustomerPhoneValue,txtCustomerAddressValue,txtCustomerGenderValue,txtArrivalDateValue,txtFinalDateValue, txtBustValue,
            txtWaistValue,txtHipsValue,txtBlouseLengthValue,txtHalfLengthValue,txtFullLengthValue,txtHandLengthValue,txtRoundHandLengthValue,txtSkirtLengthValue,
            txtShoulderValue,txtLengthValue,txtNeckValue,txtTrouserLengthValue,txtSewingTypeValue,txtCommentValue,txtTotalPaymentValue,txtDepositValue,
            txtBalanceValue;

    ImageView imgGarmentPhoto,imgStyle;
    ImageButton btnMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_record);

        Toolbar toolbar = (Toolbar) findViewById(R.id.customer_toolbar);
        setSupportActionBar(toolbar);

        txtProfileDetails = (TextView)findViewById(R.id.txt_profile_details);
        txtMeasurement = (TextView)findViewById(R.id.txt_Measurements);
        txtSewingDetails = (TextView)findViewById(R.id.txt_Sewing_Details);
        txtPaymentDetails = (TextView)findViewById(R.id.txt_Payment_Details);
        btnMessage = (ImageButton)findViewById(R.id.customer_btn_message);

        final boolean[] visibility_Flag = {false};
        txtProfileDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(visibility_Flag[0]){
                    LinearLayout profileLayout = (LinearLayout) findViewById(R.id.tbl_profile);
                    profileLayout.setVisibility(View.GONE);
                    visibility_Flag[0] = false;
                } else {
                    LinearLayout profileLayout = (LinearLayout) findViewById(R.id.tbl_profile);
                    profileLayout.setVisibility(View.VISIBLE);
                    visibility_Flag[0] =true;
                }

            }
        });

        txtMeasurement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(visibility_Flag[0]){
                    LinearLayout measurmentLayout = (LinearLayout) findViewById(R.id.tbl_measurement);
                    measurmentLayout.setVisibility(View.GONE);
                    visibility_Flag[0] = false;
                } else {
                    LinearLayout measurmentLayout = (LinearLayout) findViewById(R.id.tbl_measurement);
                    measurmentLayout.setVisibility(View.VISIBLE);
                    visibility_Flag[0] =true;
                }


            }
        });

        txtSewingDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(visibility_Flag[0]){
                    LinearLayout sewingDetailsLayout = (LinearLayout) findViewById(R.id.tbl_sewing_details);
                    sewingDetailsLayout.setVisibility(View.GONE);
                    visibility_Flag[0] = false;
                } else {
                    LinearLayout sewingDetailsLayout = (LinearLayout) findViewById(R.id.tbl_sewing_details);
                    sewingDetailsLayout.setVisibility(View.VISIBLE);
                    visibility_Flag[0] =true;
                }

            }
        });

        txtPaymentDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(visibility_Flag[0]){
                    LinearLayout paymentDetailsLayout = (LinearLayout) findViewById(R.id.tbl_payment);
                    paymentDetailsLayout.setVisibility(View.GONE);
                    visibility_Flag[0] = false;
                } else {
                    LinearLayout paymentDetailsLayout = (LinearLayout) findViewById(R.id.tbl_payment);
                    paymentDetailsLayout.setVisibility(View.VISIBLE);
                    visibility_Flag[0] =true;
                }

            }
        });





        txtCustomerName = (TextView)findViewById(R.id.txt_cstm_Name);
        txtCustomerPhone = (TextView)findViewById(R.id.txt_cstm_Phone);
        txtCustomerAddress = (TextView)findViewById(R.id.txt_cstm_Address);
        txtCustomerGender = (TextView)findViewById(R.id.txt_cstm_Gender);
        txtArrivalDate = (TextView)findViewById(R.id.txt_arrival_Date);
        txtFinalDate = (TextView)findViewById(R.id.txt_final_Date);
        txtBust = (TextView)findViewById(R.id.txt_bust);
        txtWaist = (TextView)findViewById(R.id.txt_waist);
        txtHips = (TextView)findViewById(R.id.txt_hips);
        txtBlouseLength = (TextView)findViewById(R.id.txt_blouse_length);
        txtHalfLength = (TextView)findViewById(R.id.txt_half_length);
        txtFullLength = (TextView)findViewById(R.id.txt_full_length);
        txtHandLength = (TextView)findViewById(R.id.txt_hand_length);
        txtRoundHandLength = (TextView)findViewById(R.id.txt_roundhand_length);
        txtSkirtLength = (TextView)findViewById(R.id.txt_skirt_length);
        txtShoulder = (TextView)findViewById(R.id.txt_shoulder);
        txtLength = (TextView)findViewById(R.id.txt_length);
        txtNeck = (TextView)findViewById(R.id.txt_neck);
        txtTrouserLength = (TextView)findViewById(R.id.txt_trouser_length);
        txtSewingType = (TextView)findViewById(R.id.txt_sewing_type);
        txtComment = (TextView)findViewById(R.id.txt_comment);
        txtTotalPayment = (TextView)findViewById(R.id.txt_total_payment);
        txtDeposit = (TextView)findViewById(R.id.txt_deposit);
        txtBalance = (TextView)findViewById(R.id.txt_balance);

        txtCustomerNameValue = (TextView)findViewById(R.id.txt_cstm_name_value);
        txtCustomerPhoneValue = (TextView)findViewById(R.id.txt_cstm_Phone_value);
        txtCustomerAddressValue = (TextView)findViewById(R.id.txt_cstm_Address_value);
        txtCustomerGenderValue = (TextView)findViewById(R.id.txt_cstm_Gender_value);
        txtArrivalDateValue = (TextView)findViewById(R.id.txt_arrival_Date_value);
        txtFinalDateValue = (TextView)findViewById(R.id.txt_final_Date_value);
        txtBustValue = (TextView)findViewById(R.id.txt_bust_value);
        txtWaistValue = (TextView)findViewById(R.id.txt_waist_value);
        txtHipsValue = (TextView)findViewById(R.id.txt_hips_value);
        txtBlouseLengthValue = (TextView)findViewById(R.id.txt_blouse_length_value);
        txtHalfLengthValue = (TextView)findViewById(R.id.txt_half_length_value);
        txtFullLengthValue = (TextView)findViewById(R.id.txt_full_length_value);
        txtHandLengthValue = (TextView)findViewById(R.id.txt_hand_length_value);
        txtRoundHandLengthValue = (TextView)findViewById(R.id.txt_roundhand_length_value);
        txtSkirtLengthValue = (TextView)findViewById(R.id.txt_skirt_length_value);
        txtShoulderValue = (TextView)findViewById(R.id.txt_shoulder_value);
        txtLengthValue = (TextView)findViewById(R.id.txt_length_value);
        txtNeckValue = (TextView)findViewById(R.id.txt_neck_value);
        txtTrouserLengthValue = (TextView)findViewById(R.id.txt_trouser_length_value);
        txtSewingTypeValue = (TextView)findViewById(R.id.txt_sewing_type_value);
        txtCommentValue = (TextView)findViewById(R.id.txt_comment_value);
        txtTotalPaymentValue = (TextView)findViewById(R.id.txt_total_payment_value);
        txtDepositValue = (TextView)findViewById(R.id.txt_deposit_value);
        txtBalanceValue = (TextView)findViewById(R.id.txt_balance_value);

        imgGarmentPhoto = (ImageView) findViewById(R.id.img_garment_photo);
        imgStyle = (ImageView) findViewById(R.id.img_style);

        Intent intent = this.getIntent();
        String name = intent.getExtras().getString("Name");
        final String phone = intent.getExtras().getString("Phone");
        String address = intent.getExtras().getString("Address");
        String gender = intent.getExtras().getString("Customergender");
        String arrivalDate = intent.getExtras().getString("Arrivaldate");
        String finalDate = intent.getExtras().getString("Finaldate");
        String bust = intent.getExtras().getString("Bust");
        String waist = intent.getExtras().getString("Waist");
        String hips = intent.getExtras().getString("Hips");
        String blouseLength = intent.getExtras().getString("Blouselength");
        String halfLength = intent.getExtras().getString("Halflength");
        String fullLength = intent.getExtras().getString("Fulllength");
        String handLength = intent.getExtras().getString("Handlength");
        String roundHandLength = intent.getExtras().getString("Roundhandlength");
        String skirtLength = intent.getExtras().getString("Skirtlength");
        String shoulder = intent.getExtras().getString("Shoulder");
        String length = intent.getExtras().getString("Length");
        String neck = intent.getExtras().getString("Neck");
        String trouserLength = intent.getExtras().getString("Trouserlength");
        String sewingType = intent.getExtras().getString("Sewingtype");
        String comment = intent.getExtras().getString("Comment");
        String totalPayment = intent.getExtras().getString("Totalpayment");
        String deposit = intent.getExtras().getString("Deposit");
        String balance = intent.getExtras().getString("Balance");
        byte[] garmentPhoto = intent.getExtras().getByteArray("Garmentphoto");
        byte[] style = intent.getExtras().getByteArray("Style");

        txtCustomerNameValue.setText(name);
        txtCustomerPhoneValue.setText(phone);
        txtCustomerAddressValue.setText(address);
        txtCustomerGenderValue.setText(gender);
        txtArrivalDateValue.setText(arrivalDate);
        txtFinalDateValue.setText(finalDate);
        txtBustValue.setText(bust);
        txtWaistValue.setText(waist);
        txtHipsValue.setText(hips);
        txtBlouseLengthValue.setText(blouseLength);
        txtHalfLengthValue.setText(halfLength);
        txtFullLengthValue.setText(fullLength);
        txtHandLengthValue.setText(handLength);
        txtRoundHandLengthValue.setText(roundHandLength);
        txtSkirtLengthValue.setText(skirtLength);
        txtShoulderValue.setText(shoulder);
        txtLengthValue.setText(length);
        txtNeckValue.setText(neck);
        txtTrouserLengthValue.setText(trouserLength);
        txtSewingTypeValue.setText(sewingType);
        txtCommentValue.setText(comment);
        txtTotalPaymentValue.setText(totalPayment);
        txtDepositValue.setText(deposit);
        txtBalanceValue.setText(balance);
        Bitmap garment = BitmapFactory.decodeByteArray(garmentPhoto,0,garmentPhoto.length);
        imgGarmentPhoto.setImageBitmap(Bitmap.createScaledBitmap(garment,200,200,false));
        Bitmap styles = BitmapFactory.decodeByteArray(style,0,style.length);
        imgStyle.setImageBitmap(Bitmap.createScaledBitmap(styles,200,200,false));

        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomerRecord.this,CustomerSendMessage.class);
                intent.putExtra("Phone",phone);

                startActivity(intent);
            }
        });
    }
}
