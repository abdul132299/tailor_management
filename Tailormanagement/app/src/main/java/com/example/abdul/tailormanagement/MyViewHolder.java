package com.example.abdul.tailormanagement;

import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by ABDUL on 10/24/2017.
 */

public class MyViewHolder implements View.OnLongClickListener,View. OnCreateContextMenuListener {

    TextView empnameTxt;

    myLongClickListener longClickListener;

    public MyViewHolder(View v) {

        empnameTxt = (TextView) v.findViewById(R.id.txt_emp_name);

        v.setOnLongClickListener(this);
        v.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
       // menu.setHeaderTitle("Action : ");
      // menu.add(0, 0, 0, "EDIT");
        menu.add(0, 0, 0, "DELETE");
        menu.add(0, 0, 1, "EDIT");


    }

    @Override
    public boolean onLongClick(View v) {
        this.longClickListener.onItemLongClick();
        return false;
    }

    public void setLongClickListener(myLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }

}