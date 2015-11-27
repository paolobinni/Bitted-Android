package com.supercow.bitted.bitted.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.supercow.bitted.bitted.R;
import com.supercow.bitted.bitted.currentSessionHandler.CurrentSessionHandler;
import com.supercow.bitted.bitted.dao.AdHomeAsyncTask;

import java.util.Random;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    public ListAdapter adapter;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent = new Intent(Home.this, NewAd.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
/*
        try {
            new AdHomeAsyncTask().execute().get();
        }catch(Exception e){

        }
        adapter = new SimpleAdapter(this,
                CurrentSessionHandler.ads,
                R.layout.card,
                new String[] {"name", "owner", "description"},
                new int[]{R.id.nameTW, R.id.ownerTW, R.id.descriptionTW});
        ListView list = (ListView) findViewById(android.R.id.list);
        list.setAdapter(adapter);
*/


    }

    @Override
    protected void onResume() {
        super.onResume();

        try {
            new AdHomeAsyncTask().execute().get();
        }catch(Exception e){

        }
        adapter = new SimpleAdapter(this,
                CurrentSessionHandler.ads,
                R.layout.card,
                new String[] {"name", "owner", "description"},
                new int[]{R.id.nameTW, R.id.ownerTW, R.id.descriptionTW});
        list = (ListView) findViewById(android.R.id.list);
        list.setAdapter(adapter);
        for (int i = 0; i < list.getCount(); i++) {
            updateBackgroundView(i);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_ipSettings) {
            Intent in = new Intent(Home.this, ManageIp.class);
            startActivity(in);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void updateBackgroundView(int index){
        View v = list.getChildAt(index -
                list.getFirstVisiblePosition());

        if(v == null)
            return;

        TextView nameTW = (TextView) v.findViewById(R.id.nameTW);
        nameTW.setBackground(getResources().getDrawable(randomBackground()));
    }


    public int randomBackground(){
        int[] bgs = {R.drawable.imbarivecchia, R.drawable.impane, R.drawable.imuni, R.drawable.wallp};
        return new Random().nextInt(bgs.length);
    }

}
