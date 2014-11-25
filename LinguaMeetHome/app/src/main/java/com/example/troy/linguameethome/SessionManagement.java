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

}