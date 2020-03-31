package com.ebookfrenzy.recyclercardasync;

import android.os.AsyncTask;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Random;

import static com.ebookfrenzy.recyclercardasync.NameData.clear;
import static com.ebookfrenzy.recyclercardasync.NameData.addName;
import static com.ebookfrenzy.recyclercardasync.NameData.names;
import static com.ebookfrenzy.recyclercardasync.NameData.times;


public class MainActivity extends AppCompatActivity {

    //NameData nameData = new NameData();
    EditText nameTextView;
    String name;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private final String TAG = "ErrorTag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //creating the linear layout
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //setting up an adapter connected to recyclerView
        //adapter = new RecyclerAdapter();
        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addName(View view){
        AsyncTask task = new MyTask().execute(name);
    }

    public void clearList(View view){
        clear();
        adapter.notifyDataSetChanged();
    }

    private class MyTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            nameTextView = findViewById(R.id.name_text);
            name = nameTextView.getText().toString();
        }

        @Override
        protected String doInBackground(String... strings) {
            int random = new Random().nextInt(11);
            String randomString = Integer.toString(random);
            int i =0;
            while(i<=random) {
                try {
                    Thread.sleep(1000);
                    i++;

                } catch (InterruptedException e) {
                    Log.i(TAG, "Caught thread sleep error");
                }
            }
            publishProgress(name, randomString);
            return "Button Pressed";
        }

        protected void onProgressUpdate(String... values) {
            names.add(values[0]);
            times.add(values[1]);
            adapter.notifyDataSetChanged();
            Log.i(TAG,"Name Text = "+values[0]+", the wait was: "+values[1]);

        }

        @Override
        protected void onPostExecute(String s) {
        }
    }
}
