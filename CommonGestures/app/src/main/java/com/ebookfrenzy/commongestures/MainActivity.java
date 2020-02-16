package com.ebookfrenzy.commongestures;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.TextView;
import android.view.MotionEvent;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GestureDetectorCompat;


public class MainActivity extends AppCompatActivity
        implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener
{
    private TextView gestureText;
    public TextView scrollText;
    private GestureDetectorCompat gDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestureText = findViewById(R.id.gestureStatusText);
        scrollText = findViewById(R.id.scrollText);
        this.gDetector = new GestureDetectorCompat(this,this);
        gDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        gestureText.setText ("onDown");
        return true;
    }
    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        gestureText.setText("onFling");
        return true;
    }
    @Override
    public void onLongPress(MotionEvent event) {
        gestureText.setText("onLongPress");
    }
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2,
                            float distanceX, float distanceY) {
        gestureText.setText("onScroll");
        scrollText.setTextColor(Color.CYAN);
        scrollText.setTextSize(64);
        scrollText.setText("SCROLL!");
        return true;
    }
    @Override
    public void onShowPress(MotionEvent event) {
        gestureText.setText("onShowPress");
    }
    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        gestureText.setText("onSingleTapUp");
        scrollText.setText("");
        return true;
    }
    @Override
    public boolean onDoubleTap(MotionEvent event) {
        gestureText.setText("onDoubleTap");
        ConstraintLayout myLayout = findViewById(R.id.cLayout);
        myLayout.setBackgroundColor(Color.GREEN);
        return true;
    }
    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        gestureText.setText("onDoubleTapEvent");
        return true;
    }
    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        gestureText.setText("onSingleTapConfirmed");
        return true;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }
}
