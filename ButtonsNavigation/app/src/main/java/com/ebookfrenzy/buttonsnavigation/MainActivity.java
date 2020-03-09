package com.ebookfrenzy.buttonsnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.net.Uri;

public class MainActivity extends AppCompatActivity implements secondFragment.
        OnFragmentInteractionListener,
        thirdFragment.OnFragmentInteractionListener,
        fourthFragment.OnFragmentInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }
}
