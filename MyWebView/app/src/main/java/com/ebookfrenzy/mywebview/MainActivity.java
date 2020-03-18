package com.ebookfrenzy.mywebview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handleIntent();
    }

    private void handleIntent(){
        Intent intent = getIntent();

        Uri data = intent.getData();
        URL url = null;

        try {
            url = new URL(data.getScheme(),
                    data.getHost(),
                    data.getPath());
        } catch(Exception e){
            e.printStackTrace();
        }

        WebView webView = findViewById(R.id.webView1);
        webView.loadUrl(url.toString());
    }
}
