//German Ostaszynski

package com.example.troy.linguameethome;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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


    public boolean forgotlogin() {
        //User entered valid email address
        //After user recieves email, he or she is redirected to change their password
        return true;
    }

    public boolean facebookLogin() {
        //user can login using facebook credentials
        return true;
    }
}
