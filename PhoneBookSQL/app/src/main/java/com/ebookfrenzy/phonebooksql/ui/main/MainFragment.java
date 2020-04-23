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
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.ebookfrenzy.phonebooksql.Contact;
import com.ebookfrenzy.phonebooksql.MainActivity;
import com.ebookfrenzy.phonebooksql.R;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private ContactListAdapter adapter;

    private EditText contactName;
    private EditText contactPhone;

    public String toastMsg="";
    private List<Contact> allContacts;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
        contactName = getView().findViewById(R.id.contactName);
        contactPhone = getView().findViewById(R.id.contactPhone);
        observerSetup();
        recyclerSetup();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public static class ByName implements Comparator<Contact> {
        @Override
        public int compare(Contact name1, Contact name2) {
            return name1.getName().toLowerCase().compareTo(name2.getName().toLowerCase());
        }
    }

    public void getAllContacts(){
        adapter.setContactList(allContacts);
        Log.i("errorTag","allContacts= "+allContacts);
    }
    public void addContact(){
        String name = contactName.getText().toString();
        String phone = contactPhone.getText().toString();
        if ((!name.equals("") && !phone.equals("")) && (!name.equals(null) && !phone.equals(null))) {
            Contact contact = new Contact(name,
                    phone);
            mViewModel.insertContact(contact);
            clearFields();
        } else {
            toastMsg = "Incomplete Information";
            ((MainActivity)getActivity()).customToast(toastMsg);
        }
    }
    public void findContact(){
        if (contactName.getText().toString().equals("")){
            toastMsg="Please enter a name/partial name";
            ((MainActivity)getActivity()).customToast(toastMsg);
        }
        else {
            mViewModel.findContact(contactName.getText().toString());
        }
    }
    public void sort_az(){
        Log.i("errorTag", "getListContacts = " + adapter.getList());
        Collections.sort(adapter.getList(), new MainFragment.ByName());
        adapter.notifyDataSetChanged();
        //Toast.makeText(getContext(), "sort contacts a-z", Toast.LENGTH_SHORT).show();
    }
    public void sort_za(){
        Collections.sort(adapter.getList(), new MainFragment.ByName().reversed());
        adapter.notifyDataSetChanged();
        //Toast.makeText(getContext(), "sort contacts z-a", Toast.LENGTH_SHORT).show();
    }

    private void clearFields() {
        contactName.setText("");
        contactPhone.setText("");
    }

    public void observerSetup() {
        mViewModel.getAllContacts().observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(@Nullable final List<Contact> contacts) {
                adapter.setContactList(contacts);
                allContacts = contacts;
            }
        });
        mViewModel.getSearchResults().observe(this,
                new Observer<List<Contact>>() {
                    @Override
                    public void onChanged(@Nullable final List<Contact> contacts) {
                        if (contacts.size() > 0) {
                            adapter.setContactList(contacts);
                        } else {
                            //SET UP TOAST MSG
                            adapter.setContactList(allContacts);
                            toastMsg = "No contacts found";
                            ((MainActivity)getActivity()).customToast(toastMsg);
                            //mainActivity.customToast(toastMsg);
                            //Toast.makeText(getContext(), "No contacts found", Toast.LENGTH_SHORT).show();
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
                mViewModel.deleteContact(cardName);
                clearFields();
            }
        });
    }

}
