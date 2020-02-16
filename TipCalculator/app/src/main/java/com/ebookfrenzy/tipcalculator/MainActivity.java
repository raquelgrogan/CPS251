package com.ebookfrenzy.tipcalculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private String LOG_TAG = "DemoObserver";
    public float tip;
    public String status, tenTipString, fifteenTipString, twentyTipString;
    TextView statusText, tenTipText, fifteenTipText, twentyTipText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            //tip = savedInstanceState.getFloat("tip");
            status = savedInstanceState.getString("statusText");
            statusText = findViewById(R.id.statusText);
            statusText.setText(status);

            tenTipString = savedInstanceState.getString("tenPercent");
            tenTipText = findViewById(R.id.tenTipText);
            tenTipText.setText(tenTipString);

            fifteenTipString = savedInstanceState.getString("fifteenPercent");
            fifteenTipText = findViewById(R.id.fifteenTipText);
            fifteenTipText.setText(fifteenTipString);

            twentyTipString = savedInstanceState.getString("twentyPercent");
            twentyTipText = findViewById(R.id.twentyTipText);
            twentyTipText.setText(twentyTipString);
        }
    }
    public void evaluateTip(View view) {
        EditText tipAmount = findViewById(R.id.tipAmount);

        if(tipAmount.getText().toString().equals("")){
            statusText = findViewById(R.id.statusText);
            statusText.setText("Enter a tip to calculate");
            status = statusText.getText().toString();
        }//throw in else if if needed for added checking
        else{
            //pass tip to methods
            statusText = findViewById(R.id.statusText);
            statusText.setText("The tip amount is: ");
            status = statusText.getText().toString();
            tip = Float.valueOf(tipAmount.getText().toString());
            tenPercent(tip);
            fifteenPercent(tip);
            twentyPercent(tip);
        }
    }
    private void tenPercent(float tip){
        // calculate 10% and edit text view
        tenTipText = findViewById(R.id.tenTipText);
        //tenTipText.setText("Ten Tip");
        float calcTip = tip * .1F;
        String resultString = "10% tip is: "+calcTip;
        tenTipText.setText(resultString);
        tenTipString = tenTipText.getText().toString();

    }
    private void fifteenPercent(float tip){
        // calculate 15% and edit text view
        fifteenTipText = findViewById(R.id.fifteenTipText);
        //fifteenTipText.setText("Fifteen Tip");
        float calcTip = tip * .15F;
        String resultString = "15% tip is: "+calcTip;
        fifteenTipText.setText(resultString);
        fifteenTipString = fifteenTipText.getText().toString();
    }
    private void twentyPercent(float tip){
        // calculate 20% and edit text view
        twentyTipText = findViewById(R.id.twentyTipText);
        //twentyTipText.setText("Twenty Tip");
        float calcTip = tip * .2F;
        String resultString = "20% tip is: "+calcTip;
        twentyTipText.setText(resultString);
        twentyTipString = twentyTipText.getText().toString();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //outState.putFloat("tip",tip);
        //Log.i(LOG_TAG, "tip = " + tip);

        outState.putString("statusText",status);
        //Log.i(LOG_TAG, "status = " + status);

        outState.putString("tenPercent", tenTipString);
        //Log.i(LOG_TAG, "tenTipString = " + tenTipString);

        outState.putString("fifteenPercent", fifteenTipString);
        //Log.i(LOG_TAG, "fifteenTipString = " + fifteenTipString);

        outState.putString("twentyPercent", twentyTipString);
        //Log.i(LOG_TAG, "twentyTipString = " + twentyTipString);
    }


}
