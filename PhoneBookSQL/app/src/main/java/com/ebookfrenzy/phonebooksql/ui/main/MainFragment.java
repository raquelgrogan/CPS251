package com.ebookfrenzy.phonebooksql.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ebookfrenzy.phonebooksql.Contact;
import com.ebookfrenzy.phonebooksql.R;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private ContactListAdapter adapter;

    private EditText contactName;
    private EditText contactPhone;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.i("errorTag","Inside onCreateView");
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
        contactName = getView().findViewById(R.id.contactName);
        contactPhone = getView().findViewById(R.id.contactPhone);
        Log.i("errorTag","Inside onActivityCreated");
        observerSetup();
        recyclerSetup();
    }

    public static class ByName implements Comparator<Contact> {
        @Override
        public int compare(Contact name1, Contact name2) {
            return name1.getName().compareTo(name2.getName());
        }
    }

    public void getAllContacts(){
        observerSetup();
        Toast.makeText(getContext(), "show all contacts", Toast.LENGTH_SHORT).show();
    }
    public void addContact(){
        String name = contactName.getText().toString();
        String phone = contactPhone.getText().toString();
        if (!name.equals("") && !phone.equals("")) {
            Contact contact = new Contact(name,
                    phone);
            mViewModel.insertContact(contact);
            clearFields();
        } else {
            Toast.makeText(getContext(), "Incomplete Information", Toast.LENGTH_SHORT).show();
        }
    }
    public void findContact(){
        mViewModel.findContact(contactName.getText().toString());
        Toast.makeText(getContext(), "Find Contact", Toast.LENGTH_SHORT).show();
    }
    public void sort_az(){
        Log.i("errorTag", "getListContacts = " + adapter.getList());
        Collections.sort(adapter.getList(), new MainFragment.ByName());
        adapter.notifyDataSetChanged();
        Toast.makeText(getContext(), "sort contacts a-z", Toast.LENGTH_SHORT).show();
    }
    public void sort_za(){
        Collections.sort(adapter.getList(), new MainFragment.ByName().reversed());
        adapter.notifyDataSetChanged();
        Toast.makeText(getContext(), "sort contacts z-a", Toast.LENGTH_SHORT).show();
    }

    private void clearFields() {
        contactName.setText("");
        contactPhone.setText("");
    }

    public void observerSetup() {
        mViewModel.getAllProducts().observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(@Nullable final List<Contact> products) {
                adapter.setContactList(products);
            }
        });
        mViewModel.getSearchResults().observe(this,
                new Observer<List<Contact>>() {
                    @Override
                    public void onChanged(@Nullable final List<Contact> contacts) {
                        if (contacts.size() > 0) {
                            contactName.setText(contacts.get(0).getName());
                            contactPhone.setText(contacts.get(0).getPhone());
                        } else {
                            //SET UP TOAST MSG
                            Toast.makeText(getContext(), "No contacts found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void recyclerSetup() {
        RecyclerView recyclerView;
        adapter = new ContactListAdapter(R.layout.contact_card_view);
        //send context to adapter
        Context context = getContext();
        adapter.mFragementContext(context);
        //
        recyclerView = getView().findViewById(R.id.contact_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListner(new ContactListAdapter.onItemClickListner() {
            @Override
            public void onClick(ImageView image, String cardName) {
                Log.i("errorTag", "cardName in main is: " + cardName);
                mViewModel.deleteContact(cardName);
                clearFields();
                Toast.makeText(getContext(), "onClickImage Delete", Toast.LENGTH_LONG).show();
            }
        });
    }

}
