package com.supercow.bitted.bitted.dao;

import android.util.Log;

import com.google.gson.Gson;
import com.supercow.bitted.bitted.currentSessionHandler.CurrentSessionHandler;
import com.supercow.bitted.bitted.transferObject.Account;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by paolobi on 27/11/15.
 */
public class AccountDao {

    public AccountDao(){

    }

    public Account getAccount(String user){
        Account responseAccount = null;
        HttpURLConnection conn = null;

        try {
            URL url = new URL("http://192.168.88.242:4567/api/account/"+ CurrentSessionHandler.getUsername());
            System.out.println(url.toString());
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            //conn.setDoOutput(true);
            conn.setDoInput(true);
            //DataOutputStream body = new DataOutputStream(conn.getOutputStream());


            //int responseCode = conn.getResponseCode();
            //Log.i("SERVER_CODICE RISPI = ", Integer.toString(responseCode));

            BufferedReader in =  new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine = "";

            while( (inputLine = in.readLine()) != null){
                response.append(inputLine);
                //System.out.println(inputLine + "----------------------------");
            }
            in.close();
            conn.disconnect();
            Gson gson = new Gson();
            responseAccount = gson.fromJson(response.toString(), Account.class);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.i("SERVER_ERRORACCIO = ", e.toString());
        } catch (IOException e){
            e.printStackTrace();
        }
        if (responseAccount!=null){
            CurrentSessionHandler.setAccesso(true);
        }

        return responseAccount;
    }

    public static void main (String[] args){
        AccountDao dao = new AccountDao();
        Account account = dao.getAccount("giovanni");
        System.out.println(account);
    }
}
