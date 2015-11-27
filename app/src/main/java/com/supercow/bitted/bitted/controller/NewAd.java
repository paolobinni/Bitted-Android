package com.supercow.bitted.bitted.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.supercow.bitted.bitted.R;
import com.supercow.bitted.bitted.currentSessionHandler.CurrentSessionHandler;
import com.supercow.bitted.bitted.dao.AddAdAsyncTask;
import com.supercow.bitted.bitted.transferObject.Ad;

public class NewAd extends AppCompatActivity {

    Button addBTN;
    EditText nomeET;
    EditText descriptionET;
    EditText cityET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_ad);

        addBTN = (Button) findViewById(R.id.addBTN);
        nomeET = (EditText) findViewById(R.id.nomeET);
        descriptionET = (EditText) findViewById(R.id.descriptionET);
        cityET = (EditText) findViewById(R.id.cityET);

    }

    public void add(View view){
        Ad ad = new Ad(nomeET.getText().toString(), CurrentSessionHandler.getUsername(),
                descriptionET.getText().toString(), "", cityET.getText().toString());
        AddAdAsyncTask.add(ad);
        finish();
    }
}
