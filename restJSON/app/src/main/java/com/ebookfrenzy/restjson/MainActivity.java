package com.ebookfrenzy.restjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    //private RequestQueue mRequestQ;
    //private Gson gson;
    final String TAG = "errorTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.persons_rv);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);


        final Gson gson = new Gson();
        RequestQueue mRequestQ = Volley.newRequestQueue(this);
        //parseJSON();
    //}

    //private void parseJSON() {
        String url = "http://198.199.80.235/cps276/cps276_examples/datasources/names_json_251v2.json";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i(TAG, "response: " + response.toString());
                        PersonArray personArray = gson.fromJson(response.toString(), PersonArray.class);
                        Log.i(TAG, "personArray: " + personArray.getPersonArray());
                        ArrayList<PersonArray> personList = personArray.getPersonArray();
                        Log.i(TAG, "personList: " + personList.toString());
                        Log.i(TAG, "personArray: " + personArray.getAddress());
                        RecyclerAdapter adapter = new RecyclerAdapter(personList);
                        mRecyclerView.setAdapter(adapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAG, "Error= "+error.getMessage());
                    }
                }
        );
        mRequestQ.add(jsonObjectRequest);
    }
}
