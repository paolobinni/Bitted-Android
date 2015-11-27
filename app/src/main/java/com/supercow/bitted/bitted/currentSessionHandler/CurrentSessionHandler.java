package com.supercow.bitted.bitted.currentSessionHandler;

import java.util.List;
import java.util.Map;

/**
 * Created by paolobi on 27/11/15.
 */
public class CurrentSessionHandler {

    public static String ip = "192.168.88.242";
    public static String username;
    public static boolean accesso;

    public static List<Map<String, String>> ads;


    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        CurrentSessionHandler.username = username;
    }

    public static boolean isAccesso() {
        return accesso;
    }

    public static void setAccesso(boolean accesso) {
        CurrentSessionHandler.accesso = accesso;
    }

    public static void refresh(){
        CurrentSessionHandler.username = null;
    }
}
