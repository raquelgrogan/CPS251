package com.ebookfrenzy.jsonrecyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.AdapterViewHolder> {

    private Context mcontext;
    private ArrayList<ExampleItem> mExampleList;

    public RecyclerAdapter(Context context, ArrayList<ExampleItem> exampleList){
        mcontext = context;
        mExampleList=exampleList;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.card_view, parent,false);
        return new AdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);
        String imageUrl = currentItem.getImageURL();
        String name = currentItem.getmName();
        String desc = currentItem.getDesc();
        int phone = currentItem.getPhone();

        holder.mTextViewName.setText(name);
        holder.mTextViewDesc.setText(desc);
        holder.mPhoneTextView.setText("Phone: "+phone);
        Picasso.with(mcontext).load(imageUrl).fit().centerInside().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mTextViewName;
        public TextView mTextViewDesc;
        public TextView mPhoneTextView;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewName = itemView.findViewById(R.id.name_text_view);
            mTextViewDesc = itemView.findViewById(R.id.decs_text_view);
            mPhoneTextView = itemView.findViewById(R.id.phone_text_view);

        }
    }

}
