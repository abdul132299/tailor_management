package com.example.abdul.tailormanagement;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.filter;

/**
 * Created by ABDUL on 10/25/2017.
 */

public class CustomerAdapter extends BaseAdapter {

    Context c;
    ArrayList<Customer> customers;
    ArrayList<Customer> filterList;
    LayoutInflater inflater;
    Customer customer;
    CustomFilter filter;

    public CustomerAdapter(Context c, ArrayList<Customer> customers) {
        this.c = c;
        this.customers = customers;
        this.filterList=customers;

    }

    @Override
    public int getCount() {
        return customers.size();
    }

    @Override
    public Object getItem(int position) {
        return customers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        if (inflater == null)
        {
            inflater =(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.list_items,parent,false);
        }
        //BIND DATA
        MyViewHolder holder = new MyViewHolder(convertView);
        holder.empnameTxt.setText(customers.get(position).getCustomername());

        final String cstmName = customers.get(position).getCustomername();
        final String cstmPhone = customers.get(position).getPhonenumber();
        final String cstmAddress = customers.get(position).getAddress();
        final String cstmGender = customers.get(position).getCustomergender();
        final String arrivalDate = customers.get(position).getArrivaldate();
        final String finalDate = customers.get(position).getFinaldate();
        final String bust = customers.get(position).getBust();
        final String waist = customers.get(position).getWaist();
        final String hips = customers.get(position).getHips();
        final String blouselength = customers.get(position).getBlouselength();
        final String halflength = customers.get(position).getHalflength();
        final String fulllength = customers.get(position).getFulllength();
        final String handlength = customers.get(position).getHandlength();
        final String roundhandlength = customers.get(position).getRoundhandlength();
        final String skirtlengtth = customers.get(position).getSkirtlength();
        final String shoulder = customers.get(position).getShoulder();
        final String length = customers.get(position).getLength();
        final String neck = customers.get(position).getNeck();
        final String trouserlength = customers.get(position).getTrouserlength();
        final String sewingtype = customers.get(position).getSewingtype();
        final byte[] garmentphoto = customers.get(position).getGarmentphoto();
        final byte[] style = customers.get(position).getStyle();
        final String comment = customers.get(position).getComment();
        final String totalpayment = customers.get(position).getTotalpayment();
        final String deposit = customers.get(position).getDeposit();
        final String balance = customers.get(position).getBalance();


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCustomerDataActivity(cstmName,cstmPhone,cstmAddress,cstmGender,arrivalDate,finalDate,bust,waist,hips,blouselength,halflength,fulllength,handlength,roundhandlength,
                        skirtlengtth,shoulder,length,neck,trouserlength,sewingtype,garmentphoto,style,comment,totalpayment,deposit,balance);
               // Toast.makeText(c, customers.get(position).getCustomername(), Toast.LENGTH_SHORT).show();
                }

      });

        holder.setLongClickListener(new myLongClickListener() {
            @Override
            public void onItemLongClick() {
                customer = (Customer) getItem(position);
            }
        });
        return convertView;
    }

    //EXPOSE NAME AND ID
    public int getSelectedItemID() {

        return customer.getID() ;

    }

    public String getSelectedItemName(){

        return customer.getCustomername();

    }

    public String getSelectedItemPhoneNo(){

        return customer.getPhonenumber();

    }

    public String getSelectedItemAddress(){

        return customer.getAddress();

    }

    public String getSelectedItemGender(){

        return customer.getCustomergender();

    }

    public String getSelectedItemArrivalDate(){

        return customer.getArrivaldate();

    }

    public String getSelectedItemFinalDate(){

        return customer.getFinaldate();

    }

    public String getSelectedItemBust(){

        return customer.getBust();

    }

    public String getSelectedItemWaist(){

        return customer.getWaist();

    }

    public String getSelectedItemHips(){

        return customer.getHips();

    }

    public String getSelectedItemBlouseLength(){

        return customer.getBlouselength();

    }

    public String getSelectedItemHalfLength(){

        return customer.getHalflength();

    }

    public String getSelectedItemFullLength(){

        return customer.getFulllength();

    }
    public String getSelectedItemHandLength(){

        return customer.getHandlength();

    }

    public String getSelectedItemRoundHandLength(){

        return customer.getRoundhandlength();

    }

    public String getSelectedItemSkirtLength(){

        return customer.getSkirtlength();

    }

    public String getSelectedItemShoulder(){

        return customer.getShoulder();

    }

    public String getSelectedItemLength(){

        return customer.getLength();

    }

    public String getSelectedItemNeck(){

        return customer.getNeck();

    }

    public String getSelectedItemTrouserLength(){

        return customer.getTrouserlength();

    }

    public String getSelectedItemSewingType(){

        return customer.getSewingtype();

    }

    public byte[] getSelectedItemGarmentPhoto(){

        return customer.getGarmentphoto();

    }

    public byte[] getSelectedItemStyle(){

        return customer.getStyle();

    }

    public String getSelectedItemComment(){

        return customer.getComment();

    }

    public String getSelectedItemTotalPayment(){

        return customer.getTotalpayment();

    }

    public String getSelectedItemDeposit(){

        return customer.getDeposit();

    }

    public String getSelectedItemBalance(){

        return customer.getBalance();

    }



    public void openCustomerDataActivity(String Customername, String phonenumber, String address, String Customergender, String arrivaldate, String finaldate,
                                         String bust, String waist, String hips, String blouselength, String halflength, String fulllength, String handlength,
                                         String roundhandlength, String skirtlengtth, String shoulder, String length, String neck, String trouserlength, String sewingtype,
                                         byte[] garmentphoto,byte[] style,String comment,String totalpayment,String deposit,String balance) {

        Intent intent = new Intent(c, CustomerRecord.class);

        intent.putExtra("Name",Customername);
        intent.putExtra("Phone",phonenumber);
        intent.putExtra("Address",address);
        intent.putExtra("Customergender",Customergender);
        intent.putExtra("Arrivaldate",arrivaldate);
        intent.putExtra("Finaldate",finaldate);
        intent.putExtra("Bust",bust);
        intent.putExtra("Waist",waist);
        intent.putExtra("Hips",hips);
        intent.putExtra("Blouselength",blouselength);
        intent.putExtra("Halflength",halflength);
        intent.putExtra("Fulllength",fulllength);
        intent.putExtra("Handlength",handlength);
        intent.putExtra("Roundhandlength",roundhandlength);
        intent.putExtra("Skirtlength",skirtlengtth);
        intent.putExtra("Shoulder",shoulder);
        intent.putExtra("Length",length);
        intent.putExtra("Neck",neck);
        intent.putExtra("Trouserlength",trouserlength);
        intent.putExtra("Sewingtype",sewingtype);
        intent.putExtra("Garmentphoto",garmentphoto);
        intent.putExtra("Style",style);
        intent.putExtra("Comment",comment);
        intent.putExtra("Totalpayment",totalpayment);
        intent.putExtra("Deposit",deposit);
        intent.putExtra("Balance",balance);

        c.startActivity(intent);

    }

    public Filter getFilter() {
        // TODO Auto-generated method stub
        if(filter == null)
        {
            filter=new CustomFilter();
        }
        return filter;
    }

    //INNER CLASS
    class CustomFilter extends Filter
    {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            // TODO Auto-generated method stub
            FilterResults results=new FilterResults();
            if(constraint != null && constraint.length()>0)
            {
                //CONSTARINT TO UPPER
                constraint=constraint.toString().toUpperCase();
                ArrayList<Customer> filters=new ArrayList<Customer>();
                //get specific items
                for(int i=0;i<filterList.size();i++)
                {
                    if(filterList.get(i).getCustomername().toUpperCase().contains(constraint))
                    {
                        customer=new Customer(filterList.get(i).getCustomername(),filterList.get(i).getPhonenumber(),filterList.get(i).getAddress(),
                                filterList.get(i).getCustomergender(),filterList.get(i).getArrivaldate(),filterList.get(i).getFinaldate(),filterList.get(i).getBust(),
                                filterList.get(i).getWaist(),filterList.get(i).getHips(),filterList.get(i).getBlouselength(),filterList.get(i).getHalflength(),
                                filterList.get(i).getFulllength(),filterList.get(i).getHandlength(),filterList.get(i).getRoundhandlength(),filterList.get(i).getSkirtlength(),
                                filterList.get(i).getShoulder(),filterList.get(i).getLength(),filterList.get(i).getNeck(),filterList.get(i).getTrouserlength(),
                                filterList.get(i).getSewingtype(),filterList.get(i).getComment(),
                                filterList.get(i).getTotalpayment(),filterList.get(i).getDeposit(),filterList.get(i).getBalance(),filterList.get(i).getGarmentphoto(),filterList.get(i).getStyle());
                        filters.add(customer);
                    }
                }
                results.count=filters.size();
                results.values=filters;
            }else
            {
                results.count=filterList.size();
                results.values=filterList;
            }
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            // TODO Auto-generated method stub
            customers=(ArrayList<Customer>) results.values;
            notifyDataSetChanged();
        }
    }
}

