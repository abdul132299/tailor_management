package com.example.abdul.tailormanagement;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.android.photoutil.CameraPhoto;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class NewCustomer extends AppCompatActivity {
    TextView txtProfile,txtMeasurement,txtSewingDetails,txtPaymentDetails;
    EditText editName,editPhoneNumber,editAddress,editArrivalDate,editFinalDate;
    RadioGroup genderRadioGroup;
    RadioButton customerGender;
    EditText editBust,editWaist,editHips,editBlouseLength,editHalfLength,editFullLength,editHandLength,editRoundHandLength,
            editSkirtLength,editShoulder,editLength,editNeck,editTrouserLength;

    private final String TAG = this.getClass().getName();
    private final int SELECT_STYLE = 1;
    private final int REQUEST_CAMERA1 = 2;
    private final int REQUEST_STYLE_CAMERA = 3;
    ImageView garmentimg1;
    ImageView styleimg1;
    CameraPhoto cameraPhoto;
    private  final String IMAGE_DIRECTORY = "/Image";

    EditText editComment,editTotal,editDeposit,editBalance;
    Spinner sewingType;
    Button btnSave;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_customer);
        txtProfile = (TextView)findViewById(R.id.txt_Profile);
        txtMeasurement = (TextView)findViewById(R.id.txt_Measurement);
        txtSewingDetails = (TextView)findViewById(R.id.txt_Sewing_Details);
        txtPaymentDetails = (TextView)findViewById(R.id.txt_Payment_Details);
        editName = (EditText)findViewById(R.id.edit_name);
        editPhoneNumber = (EditText)findViewById(R.id.edit_phone_number);
        editAddress = (EditText)findViewById(R.id.edit_address);
        editArrivalDate = (EditText)findViewById(R.id.edit_arrival_date);
        editFinalDate = (EditText)findViewById(R.id.edit_final_date);
        genderRadioGroup = (RadioGroup)findViewById(R.id.gender);
        editTotal = (EditText)findViewById(R.id.edit_total_payment);
        editBalance = (EditText)findViewById(R.id.edit_balance);
        editDeposit = (EditText)findViewById(R.id.edit_deposit);
        btnSave = (Button)findViewById(R.id.btn_paymentdetails_save);
        editBust = (EditText)findViewById(R.id.edit_bust);
        editWaist = (EditText)findViewById(R.id.edit_waist);
        editHips = (EditText)findViewById(R.id.edit_hips);
        editBlouseLength = (EditText)findViewById(R.id.edit_blouse_length);
        editHalfLength = (EditText)findViewById(R.id.edit_half_length);
        editFullLength = (EditText)findViewById(R.id.edit_full_length);
        editHandLength = (EditText)findViewById(R.id.edit_hand_length);
        editRoundHandLength = (EditText)findViewById(R.id.edit_roundhand_length);
        editSkirtLength = (EditText)findViewById(R.id.edit_skirt_length);
        editShoulder = (EditText)findViewById(R.id.edit_shoulder);
        editLength = (EditText)findViewById(R.id.edit_length);
        editNeck = (EditText)findViewById(R.id.edit_neck);
        editTrouserLength = (EditText)findViewById(R.id.edit_trouser_length);
        editComment = (EditText)findViewById(R.id.edit_sewingdetails_comment);
        sewingType = (Spinner) findViewById(R.id.btn_sewing_details_spinner);

        styleimg1 = (ImageView) findViewById(R.id.img2);
        garmentimg1 = (ImageView) findViewById(R.id.img1);

        cameraPhoto = new CameraPhoto(getApplicationContext());

        if (!hasCamera()) {
            garmentimg1.setEnabled(false);

        }

        // sewingType.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(NewCustomer.this, R.array.sewing_details, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sewingType.setAdapter(arrayAdapter);


        final boolean[] visibility_Flag = {false};


        txtProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(visibility_Flag[0]){
                    LinearLayout profileLayout = (LinearLayout) findViewById(R.id.profile_layout);
                    profileLayout.setVisibility(View.GONE);
                    visibility_Flag[0] = false;
                } else {
                    LinearLayout profileLayout = (LinearLayout) findViewById(R.id.profile_layout);
                    profileLayout.setVisibility(View.VISIBLE);
                    visibility_Flag[0] =true;
                }


            }
            });

        txtMeasurement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(visibility_Flag[0]){
                    LinearLayout measurmentLayout = (LinearLayout) findViewById(R.id.measurement_layout);
                    measurmentLayout.setVisibility(View.GONE);
                    visibility_Flag[0] = false;
                } else {
                    LinearLayout measurmentLayout = (LinearLayout) findViewById(R.id.measurement_layout);
                    measurmentLayout.setVisibility(View.VISIBLE);
                    visibility_Flag[0] =true;
                }

            }
        });

        txtSewingDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(visibility_Flag[0]){
                    LinearLayout sewingDetailsLayout = (LinearLayout) findViewById(R.id.sewing_layout);
                    sewingDetailsLayout.setVisibility(View.GONE);
                    visibility_Flag[0] = false;
                } else {
                    LinearLayout sewingDetailsLayout = (LinearLayout) findViewById(R.id.sewing_layout);
                    sewingDetailsLayout.setVisibility(View.VISIBLE);
                    visibility_Flag[0] =true;
                }
               

            }
        });

        txtPaymentDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(visibility_Flag[0]){
                    LinearLayout paymentDetailsLayout = (LinearLayout) findViewById(R.id.paymentdetails_layout);
                    paymentDetailsLayout.setVisibility(View.GONE);
                    visibility_Flag[0] = false;
                } else {
                    LinearLayout paymentDetailsLayout = (LinearLayout) findViewById(R.id.paymentdetails_layout);
                    paymentDetailsLayout.setVisibility(View.VISIBLE);
                    visibility_Flag[0] =true;
                }

            }
        });

        garmentimg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  startActivityForResult(cameraPhoto.takePhotoIntent(), REQUEST_CAMERA1);
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CAMERA1);
            }
        });

        styleimg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showPictureDialog();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SaveCustomerRecord();

                /**
                String CustomerName = editName.getText().toString();
                String PhoneNumber = editPhoneNumber.getText().toString();
                String Address = editAddress.getText().toString();
                String CustomerGender = customerGender.getText().toString();
                String Arrivaldate = editArrivalDate.getText().toString();
                String Finaldate = editFinalDate.getText().toString();
                String Bust = editBust.getText().toString();
                String Waist = editWaist.getText().toString();
                String Hips = editHips.getText().toString();
                String Blouselength = editBlouseLength.getText().toString();
                String Halflength = editHalfLength.getText().toString();
                String Fulllength = editFullLength.getText().toString();
                String Handlength = editHandLength.getText().toString();
                String Roundhandlength = editRoundHandLength.getText().toString();
                String Skirtlength = editSkirtLength.getText().toString();
                String Shoulder = editShoulder.getText().toString();
                String Length = editLength.getText().toString();
                String Neck = editNeck.getText().toString();
                String Trouserlength = editTrouserLength.getText().toString();
                String Sewingtype = sewingType.getAdapter().toString();
                String Comment = editComment.getText().toString();
                String Total = editTotal.getText().toString();
                String Deposit = editDeposit.getText().toString();
                String Balance = editBalance.getText().toString();

                if (CustomerName.isEmpty() && PhoneNumber.isEmpty() && Address.isEmpty() && CustomerGender.isEmpty() && Arrivaldate.isEmpty()
                        && Finaldate.isEmpty() && Bust.isEmpty() && Waist.isEmpty() && Hips.isEmpty() && Blouselength.isEmpty() && Halflength.isEmpty()
                        && Fulllength.isEmpty() && Handlength.isEmpty() && Roundhandlength.isEmpty() && Skirtlength.isEmpty() && Shoulder.isEmpty()
                        && Length.isEmpty() && Neck.isEmpty() && Trouserlength.isEmpty() && Sewingtype.isEmpty() && Comment.isEmpty() && Total.isEmpty()
                        && Deposit.isEmpty() && Balance.isEmpty()){
                    Toast.makeText(NewCustomer.this, "All Field Are Required", Toast.LENGTH_SHORT).show();
                }
                else {
                    editName.setText("");
                    editPhoneNumber.setText("");
                    editAddress.setText("");
                    customerGender.setText("");
                    editArrivalDate.setText("");
                    editFinalDate.setText("");
                    editBust.setText("");
                    editWaist.setText("");
                    editHips.setText("");
                    editBlouseLength.setText("");
                    editHalfLength.setText("");
                    editFullLength.setText("");
                    editHandLength.setText("");
                    editRoundHandLength.setText("");
                    editSkirtLength.setText("");
                    editShoulder.setText("");
                    editLength.setText("");
                    editNeck.setText("");
                    editTrouserLength.setText("");
                    sewingType.setAdapter(null);
                    editComment.setText("");
                    editTotal.setText("");
                    editDeposit.setText("");
                    editBalance.setText("");

                }**/


            }
        });

    }

    private boolean hasCamera() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }
        if (requestCode == REQUEST_CAMERA1) {

            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            garmentimg1.setImageBitmap(thumbnail);
            saveImage(thumbnail);
            Toast.makeText(NewCustomer.this, "Image Saved!", Toast.LENGTH_SHORT).show();
        }

        // for choosing image from galary

        if (requestCode == SELECT_STYLE) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    String path = saveImage(bitmap);
                    Toast.makeText(NewCustomer.this, "Image Saved!", Toast.LENGTH_SHORT).show();
                    styleimg1.setImageBitmap(bitmap);

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(NewCustomer.this, "Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == REQUEST_STYLE_CAMERA) {
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            styleimg1.setImageBitmap(thumbnail);
            saveImage(thumbnail);
            Toast.makeText(NewCustomer.this, "Image Saved!", Toast.LENGTH_SHORT).show();
        }

    }

    private void showPictureDialog(){
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Select photo from gallery",
                "Capture photo from camera" };
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }

    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, SELECT_STYLE);
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_STYLE_CAMERA);
    }

    public String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY);
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs();
        }

        try {
            File f = new File(wallpaperDirectory, Calendar.getInstance()
                    .getTimeInMillis() + ".jpg");
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(this,
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);
            fo.close();
            Log.d("TAG", "File Saved::--->" + f.getAbsolutePath());

            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }

    public void SaveCustomerRecord(){
       DBAdapter db = new DBAdapter(getApplicationContext());
       db.openDB();
        int id = genderRadioGroup.getCheckedRadioButtonId();
        customerGender = (RadioButton)findViewById(id);

       boolean saved = db.addCustomer( editName.getText().toString(),
                editPhoneNumber.getText().toString(),
                editAddress.getText().toString(),
                customerGender.getText().toString(),
                editArrivalDate.getText().toString(),
                editFinalDate.getText().toString(),
                editBust.getText().toString(),
                editWaist.getText().toString(),
                editHips.getText().toString(),
                editBlouseLength.getText().toString(),
                editHalfLength.getText().toString(),
                editFullLength.getText().toString(),
                editHandLength.getText().toString(),
                editRoundHandLength.getText().toString(),
                editSkirtLength.getText().toString(),
                editShoulder.getText().toString(),
                editLength.getText().toString(),
                editNeck.getText().toString(),
                editTrouserLength.getText().toString(),
                sewingType.getSelectedItem().toString(),
                imageViewToByte(garmentimg1),
                imageViewToByte(styleimg1),
                editComment.getText().toString(),
                editTotal.getText().toString(),
                editDeposit.getText().toString(),
                editBalance.getText().toString());

      if (saved == true) {

            Toast.makeText(NewCustomer.this, "New Customer IS Added", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(NewCustomer.this, Customers.class);
            startActivity(intent);
       } else {
            Toast.makeText(NewCustomer.this, "DATA NOT Added", Toast.LENGTH_SHORT).show();
       }

    }


    private byte[] imageViewToByte(ImageView image){
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }



}
