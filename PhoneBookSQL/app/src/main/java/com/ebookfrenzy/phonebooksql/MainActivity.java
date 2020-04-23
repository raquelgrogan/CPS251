package com.ebookfrenzy.phonebooksql;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ebookfrenzy.phonebooksql.ui.main.MainFragment;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    MainFragment mf = MainFragment.newInstance();
    //then create the menu_main here and onOptionsSelected
    //make methods that do all the work in MainFragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, mf)
                    .commitNow();
        }
    }

    public void customToast(String mfToastMsg){
        Log.i("errorTag","toastMsg = "+mfToastMsg);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup)findViewById(R.id.toast_root));
        Toast toast = new Toast(getApplicationContext());
        toast.makeText(mf.getContext(),mfToastMsg,Toast.LENGTH_LONG);
        TextView toast_text = layout.findViewById(R.id.toast_text);
        toast_text.setText(mfToastMsg);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setView(layout);
        if(!mfToastMsg.equals("")) {
            toast.show();
        }
        mf.toastMsg="";
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //handle options
        switch (item.getItemId()) {
            case R.id.show_all_contacts:
                // show_all_contacts item was selected
                mf.getAllContacts();
                return true;
            case R.id.add_contact:
                // add_contact item was selected
                mf.addContact();
                return true;
            case R.id.find_contact:
                // find_contact item was selected
                mf.findContact();
                return true;
            case R.id.sort_az:
                // sort_az item was selected
                mf.sort_az();
                return true;
            case R.id.sort_za:
                // sort_za item was selected
                mf.sort_za();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
