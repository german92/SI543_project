package com.example.troy.linguameethome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;

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

    public static List<Person> getPersonList(Activity activity, String key) {

        List<Person> list = new ArrayList<Person>();

        // grab the preferences associated with the activity passed into this method
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        String listString = preferences.getString(key, "");

        if(listString.length() != 0) {

            String[] people = listString.split(";;");

            // loop through people
            for (String p : people) {

                String[] personAttributes = p.split(";");

                String name = personAttributes[0];
                String description = personAttributes[1];
                Person newPerson = new Person(name, description);

                list.add(newPerson);

            }

        }

        return list;

    }

    public static void putPersonList(Activity activity, String key, List<Person> list) {

        List<String> tempList = new ArrayList<String>();

        for(Person p: list) {

            String tempPersonString = p.getName() + ";" +
                    p.getDescription();

            tempList.add(tempPersonString);

        }

        String listString = TextUtils.join(";;", tempList);

        myPutString(activity, key, listString);

    }

    public void clearData() {
        // Clearing all data from Shared Preferences
        editor.remove(IS_LOGIN);
        editor.apply();
    }
    public static List<String> getStringList(Activity activity, String key) {

        List<String> list = new ArrayList<String>();

        // grab the preferences associated with the activity passed into this method
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        String listString = preferences.getString(key, "");

        if(listString.length() != 0) {

            // string.split will create an array returning everything in between the provided "delimiter"
            // parameter

            // example: if the string is hello;world;!, calling split(";") on it would return an array
            // with 3 items: "hello", "world", and "!"

            String[] items = listString.split(";");

            // loop through the array and add it to a list so we can give it back to the method caller
            for (String i : items) {
                list.add(i);
            }

        }

        return list;


    }

    public static void putStringList(Activity activity, String key, List<String> list) {

        // for each string in the list, we want to add it to a new variable and separate the strings
        // by putting semicolons in between them

        // TextUtils.join takes a list or array of objects and places them into one string separated
        // by the string in the first parameter (semicolon in this case)

        String listString = TextUtils.join(";", list);

        // save the new combined string into preferences
        myPutString(activity, key, listString);

    }

    // utility that wraps together the sharedpreferences call into one method
    private static void myPutString(Activity activity, String key, String value) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();

    }
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

}