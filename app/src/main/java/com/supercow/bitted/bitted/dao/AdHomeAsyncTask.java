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
public class AdHomeAsyncTask extends AsyncTask<String,Void,String> {

    @Override
    protected String doInBackground(String... params) {
        try {
            AdDao adDao = new AdDao();
            List<Ad> ads = adDao.getAll();

            List<Map<String, String>> listAd = new LinkedList();

            for (Ad ad : ads){
                listAd.add(ad.toMap());
            }
            CurrentSessionHandler.ads = listAd;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
