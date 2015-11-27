package com.supercow.bitted.bitted.dao;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.supercow.bitted.bitted.currentSessionHandler.CurrentSessionHandler;
import com.supercow.bitted.bitted.transferObject.Ad;
import com.supercow.bitted.bitted.transferObject.Position;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paolobi on 27/11/15.
 */
public class AdDao {

    public boolean insertAd(Ad ad){
        //Ad responseAd = null;
        HttpURLConnection conn = null;
        Gson gson = new Gson();

        try {
            URL url = new URL("http://"+CurrentSessionHandler.ip + ":4567"+"/api/ad");
            System.out.println(url.toString());
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            //conn.setDoInput(true);
            //conn.setUseCaches(false);
            DataOutputStream body = new DataOutputStream(conn.getOutputStream());
            body.writeBytes(gson.toJson(ad));
            System.out.println(body.toString());
            body.flush();
            body.close();


            int responseCode = conn.getResponseCode();
            //Log.i("SERVER_CODICE RISPI = ", Integer.toString(responseCode));

            BufferedReader in =  new BufferedReader(new InputStreamReader(conn.getInputStream()));
            //StringBuilder response = new StringBuilder();
            //String inputLine = "";

            /*while( (inputLine = in.readLine()) != null){
                response.append(inputLine);
                //System.out.println(inputLine + "----------------------------");
            }*/
            in.close();
            conn.disconnect();

            //response = gson.fromJson(response.toString(), Ad.class);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.i("SERVER_ERRORACCIO = ", e.toString());
        } catch (IOException e){
            e.printStackTrace();
        }

        return true;

    }

    public List<Ad> getAll(){
        //Ad responseAd = null;
        HttpURLConnection conn = null;
        Gson gson = new Gson();
        JsonArray jsonArray;
        List<Ad> listAd = new ArrayList<Ad>();

        try {
            URL url = new URL("http://"+CurrentSessionHandler.ip + ":4567"+"/api/ads");
            System.out.println(url.toString());
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
           // conn.setDoOutput(true);
            //conn.setDoInput(true);
            //conn.setUseCaches(false);
            /*DataOutputStream body = new DataOutputStream(conn.getOutputStream());
            System.out.println(body.toString());
            body.flush();
            body.close();
*/

           int responseCode = conn.getResponseCode();
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
            jsonArray = gson.fromJson(response.toString(), JsonArray.class);
            for (int i = 0;i < jsonArray.size();i++){
                try {
                    System.out.println(jsonArray.get(i));
                    Ad ad = gson.fromJson(jsonArray.get(i),Ad.class);
                    listAd.add(ad);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.i("SERVER_ERRORACCIO = ", e.toString());
        } catch (IOException e){
            e.printStackTrace();
        }

        return listAd ;


    }

    public static void main (String[] args){
        /*Ad ad = new Ad("ripetizioni di Angular","chris","Faccio cose","img3456","Bari");
        //ad.setId("13");

        AdDao dao = new AdDao();
        Boolean check = dao.insertAd(ad);
        //System.out.println(ad);*/
        AdDao dao = new AdDao();
        List<Ad> list = new ArrayList<Ad>();
        list = dao.getAll();
        for (Ad a:list
             ) {
            System.out.println(a);

        }
    }


}
