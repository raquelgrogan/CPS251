package com.ebookfrenzy.navigationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ebookfrenzy.navigationdemo.ui.main.MainFragment;
import android.net.Uri;

public class MainActivity extends AppCompatActivity implements SecondFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        //deleted the code to launch main_fragment.xml at runtime
    }
    //communication bw fragment and activity
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
