// Troy Leonard

//Go! button starts SearchActivity
//store input data from text edit for SearchActivity
//Settings icon starts SettingsActivity
//MyLM button starts UserProfileActivity
//Chat icon starts MessagesActivity
/*import current location data to show current location on Google Maps API (I could not get
the Google Maps API functioning properly, so imagine a map will be displayed right below the Go!
button
 */


package com.example.troy.linguameethome;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;


public class HomeScreen extends Settings {
    AlertDialogManager alert = new AlertDialogManager();
    SessionManagement session;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        t1= ((TextView) findViewById(R.id.homeTextViewCustomFont));
        Typeface myCustomFont=Typeface.createFromAsset(getAssets(),"Fonts/CaviarDreams.ttf");
        t1.setTypeface(myCustomFont);
        session = new SessionManagement(getApplicationContext());
        session.checkLogin();

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();
        String name = user.get(SessionManagement.KEY_NAME);
        String email = user.get(SessionManagement.KEY_PASSWORD);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen, menu);
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
    public void searchResults(View view) {

        Intent searchResults_intent = new Intent(this, SearchResults.class);
        startActivity(searchResults_intent);
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
}
