package com.supercow.bitted.bitted.dao;

import android.os.AsyncTask;

import com.supercow.bitted.bitted.currentSessionHandler.CurrentSessionHandler;
import com.supercow.bitted.bitted.transferObject.Account;

/**
 * Created by paolobi on 27/11/15.
 */
public class MyAsyncTask extends AsyncTask<String,Void,String> {

    @Override
    protected String doInBackground(String... params) {
        try {
            AccountDao accountDao = new AccountDao();
            Account account = accountDao.getAccount(CurrentSessionHandler.getUsername());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
