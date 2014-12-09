//Sarah Anderson

//Pseudocode for ProfilePage.java:
//Settings icon starts SettingsActivity
//MyLM button starts ProfilePageActivity
//Chat icon starts MessagesActivity
//Back arrow icon destroys ProfilePageActivity, returns to HomeScreenActivity
//Edit Profile Button starts EditProfileActivity



package com.example.troy.linguameethome;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Profile extends Settings {
    SessionManagement session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        session = new SessionManagement(getApplicationContext());
        session.checkLogin();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile, menu);
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

    public void homeScreen(View view) {

        Intent homeScreen_intent = new Intent(this, HomeScreen.class);
        startActivity(homeScreen_intent);
    }

    public void options(View view) {

        Intent options_intent = new Intent(this, Options.class);
        startActivity(options_intent);
    }

    public void profile(View view) {

        Intent profile_intent = new Intent(this, Profile.class);
        startActivity(profile_intent);
    }

    public void messages(View view) {

        Intent messages_intent = new Intent(this, Messages.class);
        startActivity(messages_intent);
    }

    public void editProfile(View view) {
        Intent editProfile_intent = new Intent(this, EditProfile.class);
        startActivity(editProfile_intent);
    }


}
