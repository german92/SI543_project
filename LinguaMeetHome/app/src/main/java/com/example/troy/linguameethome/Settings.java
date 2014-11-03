package com.example.troy.linguameethome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;


public class Settings extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        themeUtils.onActivityCreateSetTheme(this);

        findViewById(R.id.custom1).setOnClickListener(this);

        findViewById(R.id.custom2).setOnClickListener(this);

        findViewById(R.id.custom3).setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings, menu);
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
    @Override

    public void onClick(View v)

    {

        switch (v.getId())

        {
            case R.id.custom1:

                themeUtils.changeToTheme(this, themeUtils.Custom1);

                break;

            case R.id.custom2:

                themeUtils.changeToTheme(this, themeUtils.Custom2);

                break;

        }

    }
}
