package com.ebookfrenzy.recycleviewintent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.Random;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.
        ViewHolder> {
    Data data = new Data();
    private final int max = 7;
    private final int min = 0;

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
                    //int position = getAdapterPosition();
                    Intent i = new Intent(v.getContext(), RecievingActivity.class);
                    String titleText = itemTitle.getText().toString();
                    String detailText = itemDetail.getText().toString();
                    //
                    Drawable drawable=itemImage.getDrawable();
                    Bitmap bitmap= ((BitmapDrawable)drawable).getBitmap();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                    byte[] b = baos.toByteArray();
                    //
//                    int imageID = itemImage.getId();
//                    Log.i("image", "image # = "+imageID);
                    //i.putExtra("imageID", imageID);
                    i.putExtra("picture", b);
                    i.putExtra("titleText", titleText);
                    i.putExtra("detailText", detailText);
                    v.getContext().startActivity(i); //must startActivity() in the context of the card view, not RecAd.class
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
        random = new Random().nextInt((max-min)-1)-min;
        holder.itemDetail.setText(data.getDetails()[random]);
        random = new Random().nextInt((max-min)-1)-min;
        holder.itemImage.setImageResource(data.getImages()[random]);
    }

    @Override
    public int getItemCount() {
        return data.getTitles().length;
    }
}