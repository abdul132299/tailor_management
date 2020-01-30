package com.example.abdul.tailormanagement;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Customers extends AppCompatActivity {

    TextView txtProfile,txtMeasurement,txtSewingDetails,txtPaymentDetails;
    EditText editName,editPhoneNumber,editAddress,editArrivalDate,editFinalDate,customerGender;
    EditText editBust,editWaist,editHips,editBlouseLength,editHalfLength,editFullLength,editHandLength,editRoundHandLength,
            editSkirtLength,editShoulder,editLength,editNeck,editTrouserLength;

    ImageView garmentimg1;
    ImageView styleimg1;
    EditText editComment,editTotal,editDeposit,editBalance;
    Spinner sewingType;
    Button btnSave;
    private final int SELECT_STYLE = 1;
    private final int REQUEST_CAMERA1 = 2;
    private final int REQUEST_STYLE_CAMERA = 3;

    CameraPhoto cameraPhoto;
    private  final String IMAGE_DIRECTORY = "/Image";



    ListView customersList = null;
    DBAdapter myDB;
    EditText edtSearch;
    CustomerAdapter adapter;
    ArrayList<Customer> customers = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myDB = new DBAdapter(this);
        cameraPhoto = new CameraPhoto(getApplicationContext());

        if (!hasCamera()) {
            garmentimg1.setEnabled(false);

        }

        customersList = (ListView) findViewById(R.id.customers_list);

        adapter = new CustomerAdapter( this,customers) ;
        this.getCustomers();

        edtSearch = (EditText)findViewById(R.id.customer_edit_search);
        // Enabling Search Filter
        edtSearch.addTextChangedListener(new TextWatcher() {
                                             @Override
                                             public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                                 // TODO Auto-generated method stub

                                             }

                                             @Override
                                             public void onTextChanged(CharSequence s, int start, int before, int count) {
                                                 // When user changed the Text
                                                Customers.this.adapter.getFilter().filter(s);
                                             }

                                             @Override
                                             public void afterTextChanged(Editable s) {
                                                 // TODO Auto-generated method stub

                                             }
                                         });


                FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Customers.this,NewCustomer.class);
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
                        Toast.makeText(Customers.this, "You Click No", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(Customers.this);
        builder.setMessage("Are you sure you want to Delete this Data").setPositiveButton("Yes",dialogClickListener).setNegativeButton("No",dialogClickListener).show();
    }

    //RETRIEVE OR getCustomers
    private void getCustomers () {
        customers. clear() ;

        DBAdapter db = new DBAdapter( this);

        db. openDB() ;

        Cursor c = db.retrieveCustomerName();
        Customer customer = null;
        while ( c. moveToNext())
        {
            int id = c. getInt(0);
            String name = c.getString(1) ;
            String phone = c.getString(2) ;
            String address = c.getString(3) ;
            String gender = c.getString(4) ;
            String arrivaldate = c.getString(5) ;
            String finaldate = c.getString(6) ;
            String bust = c.getString(7) ;
            String waist = c.getString(8) ;
            String hips = c.getString(9) ;
            String blouselength = c.getString(10) ;
            String halflength = c.getString(11) ;
            String fulllength = c.getString(12) ;
            String handlength = c.getString(13) ;
            String roundhandlength = c.getString(14) ;
            String skirtlength = c.getString(15) ;
            String shoulder = c.getString(16) ;
            String length = c.getString(17) ;
            String neck = c.getString(18) ;
            String trouserlength = c.getString(19) ;
            String sewingtype = c.getString(20) ;
            byte[] garmentphoto = c.getBlob(21) ;
            byte[] style = c.getBlob(22) ;
            String comment = c.getString(23) ;
            String totalpayment = c.getString(24) ;
            String deposit = c.getString(25) ;
            String balance = c.getString(26) ;

            customer= new Customer() ;
            customer. setID( id );
            customer.setCustomername(name);
            customer.setPhonenumber(phone);
            customer.setAddress(address);
            customer.setCustomergender(gender);
            customer.setArrivaldate(arrivaldate);
            customer.setFinaldate(finaldate);
            customer.setBust(bust);
            customer.setWaist(waist);
            customer.setHips(hips);
            customer.setBlouselength(blouselength);
            customer.setHalflength(halflength);
            customer.setFulllength(fulllength);
            customer.setHandlength(handlength);
            customer.setRoundhandlength(roundhandlength);
            customer.setSkirtlength(skirtlength);
            customer.setShoulder(shoulder);
            customer.setLength(length);
            customer.setNeck(neck);
            customer.setTrouserlength(trouserlength);
            customer.setSewingtype(sewingtype);
            customer.setGarmentphoto(garmentphoto);
            customer.setStyle(style);
            customer.setComment(comment);
            customer.setTotalpayment(totalpayment);
            customer.setDeposit(deposit);
            customer.setBalance(balance);

            customers.add( customer );
        }
        db. closeDB() ;
        customersList.setAdapter( adapter );
    }

    //UPDATE OR EDIT
    private void updateCustomer (String newName,String newPhoneNumber,String newAddress,String newGender,String newArivalDate,String newFinalDate,
                                 String newBust,String newWaist,String newHips,String newBlouseLength,String newHalfLength,String newFullLength,String newHandLength,
                                 String newRoundHandLength,String newSkirtLength,String newShoulder,String newLength,String newNeck,
                                 String newTrouserLength,byte[] newGarment,byte[] newStyle,String  newComment,
                                 String newSewingType,String newTotalPayment,String newDeposit,String newBalance){

        //GET ID OF Emp
        int id=adapter.getSelectedItemID();

        //UPDATE IN DB
        DBAdapter db= new DBAdapter(this);
        db. openDB() ;
        boolean updated = db.updateCustomerData(newName,id,newPhoneNumber,newAddress,newGender,newArivalDate,newFinalDate,newBust,newWaist,newHips,newBlouseLength,
                newHalfLength,newFullLength,newHandLength,newRoundHandLength,newSkirtLength,newShoulder,newLength,newNeck,newTrouserLength,newGarment,newStyle,
                newComment,newSewingType,newTotalPayment,newDeposit,newBalance);
        db. closeDB() ;
        if( updated )
        {

          /*  edtName.setText (newName );
            edtPhoneNumber.setText (newEmployeePhoneNumber );
            edtAddress.setText (newEmployeeAddress );
            employeeGender.setText (newEmployeeGender );
            edtRank.setText (newEmployeeRank );
            edtSalary.setText (newEmployeeSalary );*/

            getCustomers(); ;
        }else
        {
            Toast.makeText( this,"Unable To Update" ,Toast.LENGTH_SHORT ). show() ;
        }
    }


    private void delete(){

        //GET ID
        int id = adapter.getSelectedItemID() ;

        //DELETE FROM DB
        DBAdapter db = new DBAdapter(this);
        db.openDB();
        boolean deleted = db.deleteCustomer(id);
        db. closeDB() ;
        if(deleted)
        {
            getCustomers();

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
        }
        return super .onContextItemSelected (item) ;
    }

    public void displayDialogue(Boolean forUpdate){

        final Dialog d = new Dialog(this);
        d.setTitle("EDIT CUSTOMER DATA");
        d.setContentView(R.layout.update_customer);
        txtProfile = (TextView)d.findViewById(R.id.txt_Profile);
        txtMeasurement = (TextView)d.findViewById(R.id.txt_Measurement);
        txtSewingDetails = (TextView)d.findViewById(R.id.txt_Sewing_Details);
        txtPaymentDetails = (TextView)d.findViewById(R.id.txt_Payment_Details);
        editName = (EditText)d.findViewById(R.id.edit_name);
        editPhoneNumber = (EditText)d.findViewById(R.id.edit_phone_number);
        editAddress = (EditText)d.findViewById(R.id.edit_address);
        editArrivalDate = (EditText)d.findViewById(R.id.edit_arrival_date);
        editFinalDate = (EditText)d.findViewById(R.id.edit_final_date);
        customerGender = (EditText)d.findViewById(R.id.edit_customer_gender);
        editTotal = (EditText)d.findViewById(R.id.edit_total_payment);
        editBalance = (EditText)d.findViewById(R.id.edit_balance);
        editDeposit = (EditText)d.findViewById(R.id.edit_deposit);
        btnSave = (Button)d.findViewById(R.id.btn_paymentdetails_save);
        editBust = (EditText)d.findViewById(R.id.edit_bust);
        editWaist = (EditText)d.findViewById(R.id.edit_waist);
        editHips = (EditText)d.findViewById(R.id.edit_hips);
        editBlouseLength = (EditText)d.findViewById(R.id.edit_blouse_length);
        editHalfLength = (EditText)d.findViewById(R.id.edit_half_length);
        editFullLength = (EditText)d.findViewById(R.id.edit_full_length);
        editHandLength = (EditText)d.findViewById(R.id.edit_hand_length);
        editRoundHandLength = (EditText)d.findViewById(R.id.edit_roundhand_length);
        editSkirtLength = (EditText)d.findViewById(R.id.edit_skirt_length);
        editShoulder = (EditText)d.findViewById(R.id.edit_shoulder);
        editLength = (EditText)d.findViewById(R.id.edit_length);
        editNeck = (EditText)d.findViewById(R.id.edit_neck);
        editTrouserLength = (EditText)d.findViewById(R.id.edit_trouser_length);
        editComment = (EditText)d.findViewById(R.id.edit_sewingdetails_comment);
        sewingType = (Spinner)d.findViewById(R.id.btn_sewing_details_spinner);

        styleimg1 = (ImageView)d.findViewById(R.id.img2);
        garmentimg1 = (ImageView)d.findViewById(R.id.img1);

        final boolean[] visibility_Flag = {false};


        txtProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(visibility_Flag[0]){
                    LinearLayout customerProfileLayout = (LinearLayout)d.findViewById(R.id.customer_update_profile_layout);
                    customerProfileLayout.setVisibility(View.GONE);
                    visibility_Flag[0] = false;
                } else {
                    LinearLayout customerProfileLayout = (LinearLayout)d.findViewById(R.id.customer_update_profile_layout);
                    customerProfileLayout.setVisibility(View.VISIBLE);
                    visibility_Flag[0] =true;
                }


            }
        });

        txtMeasurement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(visibility_Flag[0]){
                    LinearLayout customerMeasurmentLayout = (LinearLayout)d.findViewById(R.id.customer_update_measurement_layout);
                    customerMeasurmentLayout.setVisibility(View.GONE);
                    visibility_Flag[0] = false;
                } else {
                    LinearLayout customerMeasurmentLayout = (LinearLayout)d.findViewById(R.id.customer_update_measurement_layout);
                    customerMeasurmentLayout.setVisibility(View.VISIBLE);
                    visibility_Flag[0] =true;
                }

            }
        });

        txtSewingDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(visibility_Flag[0]){
                    LinearLayout customerSewingDetailsLayout = (LinearLayout)d.findViewById(R.id.customer_update_sewing_layout);
                    customerSewingDetailsLayout.setVisibility(View.GONE);
                    visibility_Flag[0] = false;
                } else {
                    LinearLayout customerSewingDetailsLayout = (LinearLayout)d.findViewById(R.id.customer_update_sewing_layout);
                    customerSewingDetailsLayout.setVisibility(View.VISIBLE);
                    visibility_Flag[0] =true;
                }


            }
        });

        txtPaymentDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               if(visibility_Flag[0]){
                    LinearLayout customerPaymentDetailsLayout = (LinearLayout)d.findViewById(R.id.customer_update_paymentdetails_layout);
                    customerPaymentDetailsLayout.setVisibility(View.GONE);
                    visibility_Flag[0] = false;
                } else {
                    LinearLayout customerPaymentDetailsLayout = (LinearLayout)d.findViewById(R.id.customer_update_paymentdetails_layout);
                    customerPaymentDetailsLayout.setVisibility(View.VISIBLE);
                    visibility_Flag[0] =true;
                }

            }
        });

        editName.setText(adapter.getSelectedItemName());
        editPhoneNumber.setText(adapter.getSelectedItemPhoneNo());
        editAddress.setText(adapter.getSelectedItemAddress());
        editArrivalDate.setText(adapter.getSelectedItemArrivalDate());
        editFinalDate.setText(adapter.getSelectedItemFinalDate());
        customerGender.setText(adapter.getSelectedItemGender());
        editTotal.setText(adapter.getSelectedItemTotalPayment());
        editBalance.setText(adapter.getSelectedItemBalance());
        editDeposit.setText(adapter.getSelectedItemDeposit());
        editBust.setText(adapter.getSelectedItemBust());
        editWaist.setText(adapter.getSelectedItemWaist());
        editHips.setText(adapter.getSelectedItemHips());
        editBlouseLength.setText(adapter.getSelectedItemBlouseLength());
        editHalfLength.setText(adapter.getSelectedItemHalfLength());
        editFullLength.setText(adapter.getSelectedItemFullLength());
        editHandLength.setText(adapter.getSelectedItemHandLength());
        editRoundHandLength.setText(adapter.getSelectedItemRoundHandLength());
        editSkirtLength.setText(adapter.getSelectedItemSkirtLength());
        editShoulder.setText(adapter.getSelectedItemShoulder());
        editLength.setText(adapter.getSelectedItemLength());
        editNeck.setText(adapter.getSelectedItemNeck());
        editTrouserLength.setText(adapter.getSelectedItemTrouserLength());
        editComment.setText(adapter.getSelectedItemComment());

        // sewingType.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(Customers.this, R.array.sewing_details, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sewingType.setAdapter(arrayAdapter);

        //setting image in imageView
        byte[] garmentPhoto ;
        garmentPhoto = adapter.getSelectedItemGarmentPhoto();
        byte[] style ;
        style = adapter.getSelectedItemStyle();
        Bitmap garment = BitmapFactory.decodeByteArray(garmentPhoto,0,garmentPhoto.length);
        garmentimg1.setImageBitmap(Bitmap.createScaledBitmap(garment,200,200,false));
        Bitmap styles = BitmapFactory.decodeByteArray(style,0,style.length);
        styleimg1.setImageBitmap(Bitmap.createScaledBitmap(styles,200,200,false));

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
                updateCustomer(editName.getText().toString(),
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
                        imageViewToByte(garmentimg1),
                        imageViewToByte(styleimg1),
                        editComment.getText().toString(),
                        sewingType.getSelectedItem().toString(),
                        editTotal.getText().toString(),
                        editDeposit.getText().toString(),
                        editBalance.getText().toString()

                );
                finish();
            }
        });

        d.show();
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
            Toast.makeText(Customers.this, "Image Saved!", Toast.LENGTH_SHORT).show();
        }

        // for choosing image from galary

        if (requestCode == SELECT_STYLE) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    String path = saveImage(bitmap);
                    Toast.makeText(Customers.this, "Image Saved!", Toast.LENGTH_SHORT).show();
                    styleimg1.setImageBitmap(bitmap);

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(Customers.this, "Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == REQUEST_STYLE_CAMERA) {
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            styleimg1.setImageBitmap(thumbnail);
            saveImage(thumbnail);
            Toast.makeText(Customers.this, "Image Saved!", Toast.LENGTH_SHORT).show();
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


    private byte[] imageViewToByte(ImageView image){
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }


}
