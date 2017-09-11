package com.capitalsocial.soulqubit.capitalsocialdemo;

/**
 * Created by Admincetes on 11/09/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    DatabaseHelpher helpher;
    List<DatabaseModel> dbList;
    int position;
    TextView tvname,tvemail,tvroll,tvaddress,tvbranch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);




        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        // 5. get status value from bundle
        position = bundle.getInt("position");

        tvname =(TextView)findViewById(R.id.name);
        tvemail =(TextView)findViewById(R.id.email);
        tvroll =(TextView)findViewById(R.id.roll);
        tvaddress =(TextView)findViewById(R.id.address);
        tvbranch =(TextView)findViewById(R.id.branch);
        helpher = new DatabaseHelpher(this);
        dbList= new ArrayList<DatabaseModel>();
        dbList = helpher.getDataFromDB();

        if(dbList.size()>0){
            String name= dbList.get(position).getName();
            String email=dbList.get(position).getEmail();
            String roll=dbList.get(position).getRoll();
            String address=dbList.get(position).getAddress();
            String branch=dbList.get(position).getBranch();
            tvname.setText(name);
            tvemail.setText(email);
            tvroll.setText(roll);
            tvaddress.setText(address);
            tvbranch.setText(branch);
        }

        Toast.makeText(DetailsActivity.this, dbList.toString(), Toast.LENGTH_LONG);
    }




}