package com.supercow.bitted.bitted.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.supercow.bitted.bitted.R;
import com.supercow.bitted.bitted.currentSessionHandler.CurrentSessionHandler;

public class ManageIp extends AppCompatActivity {

    public EditText ipString;
    public Button ipButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_ip);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ipString = (EditText) findViewById(R.id.ipEditText);
        ipButton = (Button) findViewById(R.id.ipButton);

    }

    public void sendIp(View view){
        CurrentSessionHandler.ip = ipString.getText().toString();
        System.out.println(CurrentSessionHandler.ip);
        finish();

    }

}
