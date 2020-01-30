package com.example.abdul.tailormanagement;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ABDUL on 10/24/2017.
 */

public class EmployeeAdapter extends BaseAdapter {
    Context c;
    ArrayList<Emp> employees;
    ArrayList<Emp> filterList;
    CustomFilter filter;
    LayoutInflater inflater;
    Emp employee;



    public EmployeeAdapter(Context c, ArrayList<Emp> employees) {
        this.c = c;
        this.employees = employees;
        this.filterList = employees;
    }

    @Override
    public int getCount() {
        return employees.size();
    }

    @Override
    public Object getItem(int position) {
        return employees.get(position);
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
            convertView = inflater.inflate(R.layout.list_items2,parent,false);
        }

        //BIND DATA
        MyViewHolder holder = new MyViewHolder(convertView);
        holder.empnameTxt.setText(employees.get(position).getEmployeename());

        final String empName = employees.get(position).getEmployeename();
        final String empPhone = employees.get(position).getEmployeephonenumber();
        final String empAddress = employees.get(position).getEmployeeaddress();
        final String empGender = employees.get(position).getEmployeeGender();
        final String empRank = employees.get(position).getEmployeeRank();
        final String empSalary = employees.get(position).getSalary();

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    openEmployeeDataActivity(empName,empPhone,empAddress,empGender,empRank,empSalary);

            }
        });

        holder.setLongClickListener(new myLongClickListener() {
            @Override
            public void onItemLongClick() {
                employee = (Emp) getItem(position);
            }
        });

        return convertView;
    }

    //EXPOSE NAME AND ID
    public int getSelectedItemID() {

         return employee.getId() ;

    }

     public String getSelectedItemName(){

        return employee.getEmployeename();

     }

     public String getSelectedItemPhoneNo(){
         return employee.getEmployeephonenumber();
     }

    public String getSelectedItemAddress(){

        return employee.getEmployeeaddress();

    }
    public String getSelectedItemGender(){

        return employee.getEmployeeGender();

    }
    public String getSelectedItemRank(){

        return employee.getEmployeeRank();

    }

    public String getSelectedItemSalary(){

        return employee.getSalary();

    }





    public void openEmployeeDataActivity(String empName,String empPhone,String empAddress,String empGender,String empRank,String empSalary) {

        Intent intent = new Intent(c, EmployeeData.class);

        intent.putExtra("Name",empName);
        intent.putExtra("Phone",empPhone);
        intent.putExtra("Address",empAddress);
        intent.putExtra("Gender",empGender);
        intent.putExtra("Rank",empRank);
        intent.putExtra("Salary",empSalary);

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
                ArrayList<Emp> filters=new ArrayList<Emp>();
                //get specific items
                for(int i=0;i<filterList.size();i++)
                {
                    if(filterList.get(i).getEmployeename().toUpperCase().contains(constraint))
                    {
                        Emp emp=new Emp(filterList.get(i).getEmployeename(),filterList.get(i).getEmployeephonenumber(),filterList.get(i).getEmployeeaddress(),
                                filterList.get(i).getEmployeeRank(),filterList.get(i).getEmployeeRank(),filterList.get(i).getSalary());
                        filters.add(emp);
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
            employees=(ArrayList<Emp>) results.values;
            notifyDataSetChanged();
        }
    }

}
