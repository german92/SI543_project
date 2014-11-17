//German Ostaszynski

package com.example.troy.linguameethome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.SharedPreferences;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.util.Map;


public class Login extends Settings {
    private EditText username;
    public static final String name ="userKey";
    public static final String password = "passwordKey";
    private Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.putString("user", "Troy");
        editor.putString("user", "Sarah");
        editor.putString("user", "German");
        editor.apply();
        username= (EditText) findViewById(R.id.editText);
        loginButton=(Button) findViewById(R.id.MyLM);
        loginButton.setOnClickListener(this);


        // String currentUserPreference = mySharedPreferences.getString("user", "");



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean login() {
        //Read username and password
        //Verify credentials with information on the database
        //If credentials matches, proceed to load user data and proceed to home screen
        //Else, prompt invalid credentials
        return true;
    }

    public boolean createUser() {
        //Creates new user with the entered credentials
        //Redirect to home screen
        return true;
    }

    public boolean forgotlogin() {
        //User entered valid email address
        //After user recieves email, he or she is redirected to change their password
        return true;
    }

    public boolean facebookLogin() {
        //user can login using facebook credentials
        return true;
    }

    public void logIn(View view){

        Intent logIn_intent = new Intent(this, HomeScreen.class);
        startActivity(logIn_intent);
    }

    public void signUp(View view) {

        Intent signUp_intent = new Intent(this, SignUp.class);
        startActivity(signUp_intent);
    }
}
