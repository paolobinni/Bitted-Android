package com.supercow.bitted.bitted.dao;

import android.util.Log;

import com.google.gson.Gson;
import com.supercow.bitted.bitted.transferObject.Account;
import com.supercow.bitted.bitted.transferObject.Ad;
import com.supercow.bitted.bitted.transferObject.Position;

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
public class UserPositionDao {

    public UserPositionDao(){

    }

    public Ad updatePosition(Position position){
        Ad responseAd = null;
        HttpURLConnection conn = null;
        Gson gson = new Gson();

        try {
            URL url = new URL("http://192.168.88.242:4567/api/position/");
            System.out.println(url.toString());
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("PUT");
            conn.setDoOutput(true);
           // conn.setDoInput(true);
            DataOutputStream body = new DataOutputStream(conn.getOutputStream());
            body.writeBytes(gson.toJson(position));
            body.flush();
            body.close();


            // int responseCode = conn.getResponseCode();
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

            responseAd = gson.fromJson(response.toString(), Ad.class);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.i("SERVER_ERRORACCIO = ", e.toString());
        } catch (IOException e){
            e.printStackTrace();
        }

        return responseAd;

    }

    public static void main (String[] args){
        Position position = new Position(40,20);
        position.setId("chris");
        UserPositionDao dao = new UserPositionDao();
        Ad ad = dao.updatePosition(position);
        System.out.println(ad);
    }
}
