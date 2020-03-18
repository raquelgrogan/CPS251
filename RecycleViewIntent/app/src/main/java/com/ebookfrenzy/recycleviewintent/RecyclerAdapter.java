package com.ebookfrenzy.recycleviewintent;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.
        ViewHolder> {
    Data data = new Data();
    private final int max = 7;
    private final int min = 0;
    MainActivity mainActivity = new MainActivity();


    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemTitle;
        TextView itemDetail;

        ViewHolder(final View itemView){
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemDetail = itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) { //takes care of when the card is clicked
                    int position = getAdapterPosition();
                    Snackbar.make(v, "Click detected on item"+position,
                            Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    mainActivity.openActivity();
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int random = new Random().nextInt((max-min)-1)-min;
        holder.itemTitle.setText(data.getTitles()[random]);
        holder.itemDetail.setText(data.getDetails()[random]);
        holder.itemImage.setImageResource(data.getImages()[random]);
    }

    @Override
    public int getItemCount() {
        return data.getTitles().length;
    }
}