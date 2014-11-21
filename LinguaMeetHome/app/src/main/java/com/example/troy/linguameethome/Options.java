package com.example.troy.linguameethome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.app.AlertDialog;
import android.content.Context;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.DialogInterface;


public class Options extends Settings {
    SessionManagement session;
    final Context context = this;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        button = (Button) findViewById(R.id.alertButton);
        // add button listener
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                alertDialogBuilder.setTitle(Html.fromHtml("<font color=#666666>Log Out</font>"));

                alertDialogBuilder
                        .setMessage(Html.fromHtml("<font color=#666666>Are you sure you want to log out?</font>"))
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, close
                                // current activity and start log in activity
                                Intent log_out = new Intent(getApplicationContext(),com.example.troy.linguameethome.Login.class);
                                startActivity(log_out);
                                Options.this.finish();


                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });
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
