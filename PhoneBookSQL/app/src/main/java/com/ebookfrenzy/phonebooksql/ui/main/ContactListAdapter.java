package com.ebookfrenzy.phonebooksql.ui.main;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.ebookfrenzy.phonebooksql.Contact;
import com.ebookfrenzy.phonebooksql.R;

import java.util.List;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder> {

    private int contactItemLayout;
    private List<Contact> contactList;
    private Context mFragmentContext;
    onItemClickListner onItemClickListner;

    public List<Contact> getList(){
        return contactList;
    }
    public void setOnItemClickListner(ContactListAdapter.onItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    public interface onItemClickListner{
        void onClick(ImageView image, String cardName);//pass your object types.
    }

    public ContactListAdapter(int layoutId) {
        contactItemLayout = layoutId;
    }
    //gets context for trash image
    public void mFragementContext(Context context){
        mFragmentContext = context;
    }

    public void setContactList(List<Contact> contacts) {
        contactList = contacts;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return contactList == null ? 0 : contactList.size();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                parent.getContext()).inflate(contactItemLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        TextView name = holder.name;
        name.setText(contactList.get(listPosition).getName());
        TextView phone = holder.phone;
        phone.setText(contactList.get(listPosition).getPhone());
        final ImageView trash = holder.trash;
        Resources res = mFragmentContext.getResources();
        Drawable myImage = ResourcesCompat.getDrawable(res, R.drawable.trash, null);
        trash.setImageDrawable(myImage);
        holder.trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("errorTag","List Position in Adapter = "+listPosition);
                Log.i("errorTag","Name in Adapter = "+contactList.get(listPosition).getName());
                onItemClickListner.onClick(trash,contactList.get(listPosition).getName());
            }
        });
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView phone;
        ImageView trash;
        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.contact_name);
            phone = itemView.findViewById(R.id.contact_phone);
            trash = itemView.findViewById(R.id.imageButton);
        }
    }
}
