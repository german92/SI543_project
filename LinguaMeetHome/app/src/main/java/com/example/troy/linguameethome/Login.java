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
import android.widget.Toast;

import java.util.Map;


public class Login extends Settings {
    EditText txtUsername, txtPassword;
    Button btnLogin;
    final AlertDialogManager alert = new AlertDialogManager();
    SessionManagement session;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

            session = new SessionManagement(getApplicationContext());
            session.clearData();
            txtUsername = (EditText) findViewById(R.id.txtUsername);
            txtPassword = (EditText) findViewById(R.id.txtPassword);

            btnLogin = (Button) findViewById(R.id.btnLogin);

            btnLogin.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    // Get username, password from EditText
                    String username = txtUsername.getText().toString();
                    String password = txtPassword.getText().toString();

                    // Check if username, password is filled

                    if(username.trim().length() > 0 && password.trim().length() > 0){
                        if(username.equals("Troy") && password.equals("stuff"))  {

                                Intent i = new Intent(getApplicationContext(), HomeScreen.class);
                                startActivity(i);
                                finish();

                        }else{
                            // username / password doesn't match
                            alert.showAlertDialog(Login.this, "Login failed..", "Username/Password is incorrect", false);
                        }
                    }else{
                        // user didn't enter username or password
                        alert.showAlertDialog(Login.this, "Login failed..", "Please enter username and password", false);
                    }

                }
            });
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
        finish();
    }

    public void signUp(View view) {

        Intent signUp_intent = new Intent(this, SignUp.class);
        startActivity(signUp_intent);
        finish();
    }
}
