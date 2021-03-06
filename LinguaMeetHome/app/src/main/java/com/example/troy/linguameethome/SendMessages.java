package com.example.troy.linguameethome;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import java.util.List;


public class SendMessages extends Settings {
    int personId;
    List<Person> peopleList;
    SessionManagement session;
    TextView message;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Message = "messageKey";

    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_messages);
        initList();
        session = new SessionManagement(getApplicationContext());
        session.checkLogin();

        // Get the message from the intent
        Intent intent = getIntent();
        String message2 = intent.getStringExtra(UserProfile.EXTRA_MESSAGE);

        personId = (int) Long.parseLong(message2);

        // Create the text view
        TextView textView = (TextView) findViewById(R.id.userNameMsg);
        textView.setText(peopleList.get(personId).getName());



        message = (TextView) findViewById(R.id.editTextMessage);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);



    }

    public void run(View view) {
        String m = message.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Message, m);
        editor.commit();
        messages();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.send_messages, menu);
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
    private void initList() {

        peopleList = SessionManagement.getPersonList(this, "people");
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

    public void messages() {

        Intent messages_intent = new Intent(this, Messages.class);
        startActivity(messages_intent);
    }
}
