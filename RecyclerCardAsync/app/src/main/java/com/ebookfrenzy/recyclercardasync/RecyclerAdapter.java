package com.ebookfrenzy.recyclercardasync;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.
        ViewHolder>{
    NameData nameData = new NameData();

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName;

        ViewHolder(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.user_name);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.userName.setText(nameData.names.indexOf(i));
    }

    @Override
    public int getItemCount() {
        return nameData.names.size();
    }

}
