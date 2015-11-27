package com.supercow.bitted.bitted.currentSessionHandler;

/**
 * Created by paolobi on 27/11/15.
 */
public class CurrentSessionHandler {

    public static String username;



    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        CurrentSessionHandler.username = username;
    }

    public static void refresh(){
        CurrentSessionHandler.username = null;
    }
}
