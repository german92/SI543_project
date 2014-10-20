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

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class HomeScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
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
}