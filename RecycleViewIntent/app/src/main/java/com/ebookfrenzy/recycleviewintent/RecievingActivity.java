package com.ebookfrenzy.recycleviewintent;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class RecievingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieving);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("Msg","Bundle is null");
            return;
        }

        String titleText = extras.getString("titleText");
        String detailText = extras.getString("detailText");
        //int imageID = extras.getInt("imageID");
        //
        byte[] b = extras.getByteArray("picture");
        Bitmap bmp = BitmapFactory.decodeByteArray(b, 0, b.length);
        //

        final TextView title = findViewById(R.id.titleText);
        title.setText(titleText);
        final TextView detail = findViewById(R.id.descriptionText);
        detail.setText(detailText);
        final ImageView image = findViewById(R.id.imageView);
        //image.setImageResource(imageID);
        image.setImageBitmap(bmp);
    }
}
