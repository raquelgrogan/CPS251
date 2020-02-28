package com.ebookfrenzy.addnamesavedataproject.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.ebookfrenzy.addnamesavedataproject.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private ListView myListView;
    private EditText nameText;
    private TextView errorValue;
    private Button addNameButton;
    ArrayList<String> listNames = new ArrayList<String>();
    ArrayAdapter<String> adapter;


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.main_fragment, container, false);
        final View view = inflater.inflate(R.layout.main_fragment, container, false);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
//        //initialize variables
        myListView = view.findViewById(R.id.listView);
        nameText = view.findViewById(R.id.nameValue);
        addNameButton = view.findViewById(R.id.addNameButton);
        errorValue = view.findViewById(R.id.errorValue);

        //adapter prints back listNames array
        adapter = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_list_item_1,listNames);
        myListView.setAdapter(adapter);

        addNameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(nameText.getText().toString().equals("")){ //IF BLANK
                    errorValue.setTextColor(Color.RED);
                    errorValue.setText("Please Enter A Name");
                }
                else {
                    errorValue.setText("Clicked");//set to blank later
                    String name = nameText.getText().toString();
                    // Call addNames() from MainViewModel
                    //listNames = mViewModel.addNames(name);
                    listNames.add(name);
                    //notify change
                    adapter.notifyDataSetChanged();
                    Log.d("this is my array", "arr: " + Arrays.toString(new ArrayList[]{listNames}));
                }
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);





    }

}
