package com.example.troy.linguameethome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Options extends Settings {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options, menu);
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

    public void settings(View view) {
        Intent settings_intent = new Intent(this, Settings.class);
        startActivity(settings_intent);
    }


    public void privacy(View view) {
        Intent privacy_intent = new Intent(this, Privacy.class);
        startActivity(privacy_intent);
    }

    public void logOut(View view) {
        Intent logOut_intent = new Intent(this, Login.class);
        startActivity(logOut_intent);
    }

    public void homeScreen(View view) {

        Intent homeScreen_intent = new Intent(this, HomeScreen.class);
        startActivity(homeScreen_intent);
    }

    public void profile(View view) {

        Intent profile_intent = new Intent(this, Profile.class);
        startActivity(profile_intent);
    }

    public void messages(View view) {

        Intent messages_intent = new Intent(this, Messages.class);
        startActivity(messages_intent);
    }
}
