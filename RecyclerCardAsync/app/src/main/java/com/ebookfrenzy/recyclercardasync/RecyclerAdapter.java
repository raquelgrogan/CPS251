package com.ebookfrenzy.recyclercardasync;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.ebookfrenzy.recyclercardasync.NameData.getName;
import static com.ebookfrenzy.recyclercardasync.NameData.getNamesArr;
import static com.ebookfrenzy.recyclercardasync.NameData.getTime;
import static com.ebookfrenzy.recyclercardasync.NameData.getTimesArr;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.
        ViewHolder>{
    private final String TAG = "ErrorTag";


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName;

        ViewHolder(View itemView) {
            super(itemView);
            Log.i(TAG,"inside ViewHolder");
            userName = itemView.findViewById(R.id.user_name);
        }
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
        Log.i(TAG,"The content of nameArray[i] is: "+getName(i)+" time="+getTime(i));
        if(getNamesArr().isEmpty()||getTimesArr().isEmpty()){
            Log.i(TAG,"There's an empty array in Recycler Adapter!");
        }else {
            viewHolder.userName.setText("The name is "+getName(i)+" and it took "+getTime(i)+" seconds");
        }
    }

    @Override
    public int getItemCount() {
        return getNamesArr().size();
    }

}
