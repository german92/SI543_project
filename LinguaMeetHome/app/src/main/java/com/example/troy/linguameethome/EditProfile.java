package com.example.troy.linguameethome;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class EditProfile extends Settings {

    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        t1= ((TextView) findViewById(R.id.homeTextViewCustomFont));
        Typeface myCustomFont=Typeface.createFromAsset(getAssets(),"Fonts/CaviarDreams.ttf");
        t1.setTypeface(myCustomFont);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.edit_profile, menu);
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

    public void updateProfile(View view) {
        Intent updateProfile_intent = new Intent(this, Profile.class);
        startActivity(updateProfile_intent);
    }

    public void onStart(){
        super.onStart();
        TextView tv=(TextView)findViewById(R.id.editText2);
        tv.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            public void onFocusChange(View view, boolean hasfocus){
                if(hasfocus){

                    view.setBackgroundResource(R.drawable.focus_border_style);
                }
                else{
                    view.setBackgroundResource(R.drawable.lost_focus_style);
                }
            }
        });

    }
}
