package com.example.troy.linguameethome;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;


public class UserProfile extends Settings {
    int personId;
    List<Person> peopleList;
    public final static String EXTRA_MESSAGE = "com.example.troy.linguameethome";
    SessionManagement session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        session = new SessionManagement(getApplicationContext());
        session.checkLogin();
        initList();

        // Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(SearchResults.EXTRA_MESSAGE);

        personId = (int) Long.parseLong(message);

        // Create the text view
        TextView textView = (TextView) findViewById(R.id.userNameTxtV);
        textView.setText(peopleList.get(personId).getName());
        TextView textView2 = (TextView) findViewById(R.id.descripView);
        textView2.setText("Bio: " + peopleList.get(personId).getDescription());
        textView2.setMovementMethod(new ScrollingMovementMethod());
        Button sndMsg = (Button) findViewById((R.id.send_a_msg));
        sndMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMsg(personId);
            }
        });



    }

    // initList is a helper method that grabs our "team data" and associates it with the correct id
    // based on its position in the list
    // in a real application, this would be where we query the database and fetch the data associated
    // with the teams
    // we can perform some shared preferences data storing for now
    private void initList() {

        peopleList = SessionManagement.getPersonList(this, "people");
    }

    public void sendMsg(long id) {
        Intent intent = new Intent(this, SendMessages.class);
        String message = String.valueOf(id);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user_profile, menu);
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

    public void send_messages(View view) {

        Intent messages_intent = new Intent(this, SendMessages.class);
        startActivity(messages_intent);
    }
}
