package com.ebookfrenzy.phonebooksql;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContactRepository{
    //used to preform insert, delete and query contact records NOT getAllContacts()
    //runs theses operations on different threads using Async class
    private MutableLiveData<List<Contact>> searchResults =
            new MutableLiveData<>();

    private LiveData<List<Contact>> allContacts;

    private ContactDao contactDao;

    // These methods will create and call appropriate AsyncTask instances
    //and pass through a reference to the DAO.
    public ContactRepository(Application application) {
        ContactRoomDatabase db;
        db = ContactRoomDatabase.getDatabase(application);
        contactDao = db.contactDao();
        allContacts = contactDao.getAllContacts();
        //^^each time a change occurs to the database table the UI controller observer will be notified
        //and the RecyclerView can be updated
    }

    public void insertContact(Contact newcontact) {
        InsertAsyncTask task = new InsertAsyncTask(contactDao);
        task.execute(newcontact);
    }
    public void deleteContact(String name) {
        DeleteAsyncTask task = new DeleteAsyncTask(contactDao);
        task.execute(name);
    }
    public void findContact(String name) {
        QueryAsyncTask task = new QueryAsyncTask(contactDao);
        task.delegate = this;
        task.execute(name);
    }

    private void asyncFinished(List<Contact> results) {
        Log.i("errorTag","result is "+ results);
        searchResults.setValue(results);
    }


    //These Async classes will preform tasks on a different thread
    private static class QueryAsyncTask extends
            AsyncTask<String, Void, List<Contact>> {
        private ContactDao asyncTaskDao;
        private ContactRepository delegate = null;

        QueryAsyncTask(ContactDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected List<Contact> doInBackground(final String... params) {
            return asyncTaskDao.findContact(params[0]);
        }
        @Override
        protected void onPostExecute(List<Contact> result) {
            delegate.asyncFinished(result);
        }
    }
    private static class InsertAsyncTask extends AsyncTask<Contact, Void, Void> {
        private ContactDao asyncTaskDao;
        InsertAsyncTask(ContactDao dao) {
            asyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final Contact... params) {
            asyncTaskDao.insertContact(params[0]);
            return null;
        }
    }
    private static class DeleteAsyncTask extends AsyncTask<String, Void, Void> {
        private ContactDao asyncTaskDao;
        DeleteAsyncTask(ContactDao dao) {
            asyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final String... param) {
            asyncTaskDao.deleteContact(param[0]);
            return null;
        }
    }



    //methods to obtain results and contact in ViewModel
    public LiveData<List<Contact>> getAllContacts() {
        return allContacts;
    }
    public MutableLiveData<List<Contact>> getSearchResults() {
        return searchResults;
    }



}
