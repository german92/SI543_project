package com.example.troy.linguameethome;

import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionManagement {
    SharedPreferences pref;
    Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "LMPrefs";
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_NAME = "username";
    public static final String KEY_PASSWORD = "password";

    // Constructor
    public SessionManagement(Context context){
        this._context = context;
        pref = _context.getSharedPreferences("LMPrefs", PRIVATE_MODE);
        editor = pref.edit();
        editor.putBoolean(IS_LOGIN, true);

        editor.putString(KEY_NAME, "Troy");
        editor.putString(KEY_NAME, "Sarah");
        editor.putString(KEY_NAME, "German");

        editor.putString(KEY_PASSWORD, "stuff");
        editor.putString(KEY_PASSWORD, "things");

        editor.apply();
    }


    public void checkLogin(){
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, Login.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
        }

    }


    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));

        // user email id
        user.put(KEY_PASSWORD, pref.getString(KEY_PASSWORD, null));

        // return user
        return user;
    }



    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}