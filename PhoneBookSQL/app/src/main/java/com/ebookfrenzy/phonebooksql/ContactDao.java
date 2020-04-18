package com.ebookfrenzy.phonebooksql;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactDao {
    //insert find and delete records from database
    @Insert
    void insertContact(Contact contact);

    @Query("SELECT * FROM contacts WHERE contactName = :name")
    List<Contact> findContact(String name);

    @Query("DELETE FROM contacts WHERE contactName = :name")
    void deleteContact(String name);

    //returns LiveData Object containing all database records
    //keeps RecyclerView synced with database
    @Query("SELECT * FROM contacts")
    LiveData<List<Contact>> getAllContacts();

    @Query("SELECT * FROM contacts")
    List<Contact> listOfContacts();
}
