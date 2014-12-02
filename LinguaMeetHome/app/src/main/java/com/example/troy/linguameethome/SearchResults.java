package com.example.troy.linguameethome;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SearchResults extends Settings {

    public final static String EXTRA_MESSAGE = "com.example.troy.linguameethome";

    List<Map<String, String>> peopleList = new ArrayList<Map<String, String>>();


    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        t1= ((TextView) findViewById(R.id.searchDescription));
        Typeface myCustomFont=Typeface.createFromAsset(getAssets(),"Fonts/CaviarDreams.ttf");
        t1.setTypeface(myCustomFont);

        registerForContextMenu((ListView) findViewById(R.id.listView));

        initList();

        ListView peopleListView = (ListView) findViewById(R.id.listView);
        SimpleAdapter simpleAdpt = new SimpleAdapter(this, peopleList, android.R.layout.simple_list_item_1, new String[] {"person"}, new int[] {android.R.id.text1});
        peopleListView.setAdapter(simpleAdpt);

        peopleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView <?> parentAdapter, View view, int position,
                                    long id) {


                    openProfile(id);
                }
            });
        }

        private void initList() {

            List<Person> people = SessionManagement.getPersonList(this, "people");

            for(Person p: people) {

                peopleList.add(createPerson("person", p));

            }

        }




    private HashMap<String, String> createPerson(String key, Person p) {
        HashMap<String, String> person = new HashMap<String, String>();
        String name = p.getName();
        person.put(key, name);
        return person;
    }

    public void openProfile(long id) {
        Intent intent = new Intent(this, UserProfile.class);
        String message = String.valueOf(id);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_results, menu);
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

    public void userProfile (View view) {

        Intent userProfile_intent = new Intent(this, UserProfile.class);
        startActivity(userProfile_intent);
    }
}
