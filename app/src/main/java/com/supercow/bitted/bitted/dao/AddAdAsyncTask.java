package com.supercow.bitted.bitted.dao;

import android.os.AsyncTask;

import com.supercow.bitted.bitted.currentSessionHandler.CurrentSessionHandler;
import com.supercow.bitted.bitted.transferObject.Ad;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by paolobi on 27/11/15.
 */
public class AddAdAsyncTask extends AsyncTask<String,Void,String> {

    static Ad ad = null;
    public static void add(Ad adv){
        ad = adv;
        try {
            new AddAdAsyncTask().execute().get();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            AdDao adDao = new AdDao();
            boolean b = adDao.insertAd(ad);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}