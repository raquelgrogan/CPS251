package com.ebookfrenzy.recyclercardasync;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.
        ViewHolder>{
    private final String TAG = "ErrorTag";
    NameData nameData = new NameData();
    ArrayList<String> nameDataArray;

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName;

        ViewHolder(View itemView) {
            super(itemView);
            Log.i(TAG,"inside ViewHolder");
            userName = itemView.findViewById(R.id.user_name);
        }
    }

    public RecyclerAdapter(ArrayList<String> nameArray){
        nameDataArray = nameArray;
        Log.i(TAG, "in RecyclerAdapter constructor");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Log.i(TAG,"inside onCreateViewHolder");
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Log.i(TAG,"The content of nameArray[i] is: "+nameDataArray.indexOf(i));
        if(nameDataArray.isEmpty()){
            Log.i(TAG,"There's an empty array in Recycler Adapter!");
        }else {
            viewHolder.userName.setText(nameDataArray.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return nameData.getNames().size();
    }

}
