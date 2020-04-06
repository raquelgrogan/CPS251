package com.ebookfrenzy.restjson2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterName extends RecyclerView.Adapter<RecyclerViewAdapterName.ViewHolder> {
    private ArrayList<Names> namesArrayList;

    public RecyclerViewAdapterName(ArrayList<Names> nLst) {
        namesArrayList = nLst;
    }

    @Override
    public RecyclerViewAdapterName.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.name_card, parent, false);

        RecyclerViewAdapterName.ViewHolder viewHolder = new RecyclerViewAdapterName.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        //WE GET THE POSITION OF THE COUPON LIST AND THEN CAN GET THE VALUE OF ALL THE COUPONS FROM
        //THE ARRAYLIST
        Names names = namesArrayList.get(position);
        Log.i("errorTag","position = "+position);
        viewHolder.mIdNumber.setText(String.valueOf(position));

        if(names.getGender().equals("female")){
            viewHolder.mImageView.setImageResource(R.drawable.female);
        }else{
            viewHolder.mImageView.setImageResource(R.drawable.male);
        }
        viewHolder.mAge.setText(names.getAge());
        viewHolder.mEyeColor.setText(names.getEyeColor());
        viewHolder.mName.setText(names.getName());
        viewHolder.mCompany.setText(names.getCompany());
        viewHolder.mEmail.setText(names.getEmail());
        viewHolder.mPhone.setText(names.getPhone());
        viewHolder.mAddress.setText(names.getAddress());

    }
    @Override
    public int getItemCount() {
        //WE ARE USING AN ARRAY LIST SO WE USE THE SIZE METHOD NOT LENGTH FROM THE ARRAY
        return namesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mName;
        public TextView mPhone;
        public TextView mAddress;
        public TextView mEmail;
        public TextView mCompany;
        public TextView mAge;
        public TextView mEyeColor;
        public TextView mIdNumber;

        public ViewHolder(View view) {
            super(view);
            mImageView = view.findViewById(R.id.imageView);
            mName = view.findViewById(R.id.person_name);
            mPhone = view.findViewById(R.id.person_phone);
            mAddress = view.findViewById(R.id.person_address);
            mEmail = view.findViewById(R.id.person_email);
            mCompany = view.findViewById(R.id.person_company);
            mAge = view.findViewById(R.id.person_age);
            mEyeColor = view.findViewById(R.id.person_eye_color);
            mIdNumber = view.findViewById(R.id.id_number);

        }

    }
}
