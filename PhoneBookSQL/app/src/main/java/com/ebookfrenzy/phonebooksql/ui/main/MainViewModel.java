package com.ebookfrenzy.phonebooksql.ui.main;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ebookfrenzy.phonebooksql.Contact;
import com.ebookfrenzy.phonebooksql.ContactRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    //allows the ViewModel and ProductRepository to interact
    private ContactRepository repository;
    private LiveData<List<Contact>> allContacts;
    private MutableLiveData<List<Contact>> searchResults;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new ContactRepository(application);
        //^^gives productRepos access to application context
        allContacts = repository.getAllContacts();
        searchResults = repository.getSearchResults();
    }

    MutableLiveData<List<Contact>> getSearchResults(){
        return searchResults;
    }

    LiveData<List<Contact>> getAllContacts(){
        return allContacts;
    }

    public void insertContact(Contact contact){
        repository.insertContact(contact);
    }
    public void findContact(String name){
        repository.findContact(name);
    }
    public void deleteContact(String name){
        repository.deleteContact(name);
    }


}
