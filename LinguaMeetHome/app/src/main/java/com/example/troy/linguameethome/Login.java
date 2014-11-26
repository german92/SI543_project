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
import java.util.List;
import java.util.ArrayList;


public class Login extends Settings {

    final AlertDialogManager alert = new AlertDialogManager();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initData();
    }


    private void initData() {

        List<Person> peopleList = new ArrayList<Person>();

        String defaultDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do" +
                " eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam," +
                " quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." +
                " Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu " +
                "fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in " +
                "culpa qui officia deserunt mollit anim id est laborum.";

        peopleList.add(new Person("John Smith", "Just your average Joe looking for some language practice."));
        peopleList.add(new Person("Sam McGee", "I'm from TN, my favorite travel destination is the Yukon, and Robert Service is my favorite poet. "));
        peopleList.add(new Person("Troy Leonard", "MSI Grad Student. Generally awesome."));
        peopleList.add(new Person("Sarah Anderson", "MSI/MPP. Dua te praktikuar shqipen time!"));
        peopleList.add(new Person("German Lipiec", "BSI that likes to jetset and make logos."));
        peopleList.add(new Person("Alex White", "I like hunting and fishing and high tea."));
        peopleList.add(new Person("Becca Rikowski", "Trying to learn Spanish before my backpacking trip to South America"));
        peopleList.add(new Person("Rich Savage", "Polyglot currently trying to master Kazahk."));
        peopleList.add(new Person("Tara Strohmeyer", "Linguist and language lover at heart, CSR by day."));
        peopleList.add(new Person("Lucy Krauss", "Studied abroad in Milan a year ago.  Miss having one-on-one conversations in Italian and Spanish!"));

        SessionManagement.putPersonList(this, "people", peopleList);

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
