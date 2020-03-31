package com.ebookfrenzy.jsonphonebookexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button button;
    public static ListView listView;
    //ArrayList <HashMap<String,String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        //contactList = new ArrayList<>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchJson process = new fetchJson();
                process.mainContext(MainActivity.this);
                process.execute();
            }
        });
    }

//    public class fetchJson2 extends AsyncTask<Void, Void, Void> {
//
//        HttpHandler httpHandler = new HttpHandler();
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            String jsonData = httpHandler.makeServiceCall();
//            Log.i("Error","jsonData = "+jsonData);
//            if(jsonData!=null) {
//                try {
//                    JSONObject jsonObject = new JSONObject(jsonData);
//                    JSONArray contacts = jsonObject.getJSONArray("contacts");
//
//                    Log.i("Error","contacts "+contacts);
//
//                    for (int i = 0; i < contacts.length(); i++) {
//                        //get 1st object of json
//                        JSONObject JO = (JSONObject) contacts.get(i);
//                        String name = JO.getString("name");
//                        String phone = JO.getString("phone");
//                        String address = JO.getString("address");
//                        String favorites = JO.getString("favorites");
//                        Log.i("Error","name " + name+" phone "+phone+"address "+address+
//                                " favorites "+favorites);
//
//                        HashMap<String,String> contact = new HashMap<>();
//
//                        contact.put("name",name);
//                        contact.put("phone",phone);
//                        contact.put("address",address);
//                        contact.put("favorites",favorites);
//                        Log.i("Error","contact = "+contact);
//
//                        contactList.add(contact);
//                    }
//                } catch (JSONException e) {
//                    Log.i("Error","Error in fetchJson"+e.getMessage());
//                }
//            }
//
//            return null;
//        }
//
//        @Override
//        protected void onProgressUpdate(Void... values) {
//            super.onProgressUpdate(values);
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//
//            ListAdapter listAdapter = new SimpleAdapter(MainActivity.this, contactList,
//                    R.layout.list_item, new String[]{"name","phone","address","favorites"},
//                    new int[]{R.id.name, R.id.phone, R.id.address,R.id.favorites});
//
//            listView.setAdapter(listAdapter);
//        }
//
//
//    }

}
