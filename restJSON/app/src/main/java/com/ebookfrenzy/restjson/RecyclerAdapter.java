package com.ebookfrenzy.restjson;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.AdapterViewHolder> {
    private ArrayList<PersonArray> personList;

    public RecyclerAdapter(ArrayList<PersonArray> pList){
        personList = pList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);

        RecyclerAdapter.AdapterViewHolder viewHolder = new RecyclerAdapter.AdapterViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.AdapterViewHolder holder, int position) {
        PersonArray personArray = personList.get(position);

        holder.mIdNumber.setText(position);

        if(personArray.getGender().equals("female")){
            holder.mImageView.setImageResource(R.drawable.female);
        }else{
            holder.mImageView.setImageResource(R.drawable.male);
        }
        holder.mAge.setText(personArray.getAge());
        holder.mEyeColor.setText(personArray.getEyeColor());
        holder.mName.setText(personArray.getName());
        holder.mCompany.setText(personArray.getCompany());
        holder.mEmail.setText(personArray.getEmail());
        holder.mPhone.setText(personArray.getPhone());
        holder.mAddress.setText(personArray.getAddress());
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mName;
        public TextView mPhone;
        public TextView mAddress;
        public TextView mEmail;
        public TextView mCompany;
        public TextView mAge;
        public TextView mEyeColor;
        public TextView mIdNumber;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mName = itemView.findViewById(R.id.person_name);
            mPhone = itemView.findViewById(R.id.person_phone);
            mAddress = itemView.findViewById(R.id.person_address);
            mEmail = itemView.findViewById(R.id.person_email);
            mCompany = itemView.findViewById(R.id.person_company);
            mAge = itemView.findViewById(R.id.person_age);
            mEyeColor = itemView.findViewById(R.id.person_eye_color);
            mIdNumber = itemView.findViewById(R.id.id_number);

        }
    }
}
