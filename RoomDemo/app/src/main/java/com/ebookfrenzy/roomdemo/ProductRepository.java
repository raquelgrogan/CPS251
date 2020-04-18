package com.ebookfrenzy.roomdemo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ProductRepository {

    //used to preform insert, delete and query product records NOT getAllProducts()
    //runs theses operations on different threads using Async class
    private MutableLiveData<List<Product>> searchResults =
            new MutableLiveData<>();

    private LiveData<List<Product>> allProducts;

    private ProductDao productDao;
    // These methods will create and call appropriate AsyncTask instances
    //and pass through a reference to the DAO.
    public ProductRepository(Application application) {
        ProductRoomDatabase db;
        db = ProductRoomDatabase.getDatabase(application);
        productDao = db.productDao();
        allProducts = productDao.getAllProducts();
        //^^each time a change occurs to the database table the UI controller observer will be notified
        //and the RecyclerView can be updated
    }
    public void insertProduct(Product newproduct) {
        InsertAsyncTask task = new InsertAsyncTask(productDao);
        task.execute(newproduct);
    }
    public void deleteProduct(String name) {
        DeleteAsyncTask task = new DeleteAsyncTask(productDao);
        task.execute(name);
    }
    public void findProduct(String name) {
        QueryAsyncTask task = new QueryAsyncTask(productDao);
        task.delegate = this;
        task.execute(name);
    }
    //

    private void asyncFinished(List<Product> results) {
        searchResults.setValue(results);
    }
//These Async classes will preform tasks on a different thread
    private static class QueryAsyncTask extends
            AsyncTask<String, Void, List<Product>> {
        private ProductDao asyncTaskDao;
        private ProductRepository delegate = null;

        QueryAsyncTask(ProductDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected List<Product> doInBackground(final String... params) {
            return asyncTaskDao.findProduct(params[0]);
        }
        @Override
        protected void onPostExecute(List<Product> result) {
            delegate.asyncFinished(result);
        }
    }
    private static class InsertAsyncTask extends AsyncTask<Product, Void, Void> {
        private ProductDao asyncTaskDao;
        InsertAsyncTask(ProductDao dao) {
            asyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final Product... params) {
            asyncTaskDao.insertProduct(params[0]);
            return null;
        }
    }
    private static class DeleteAsyncTask extends AsyncTask<String, Void, Void> {
        private ProductDao asyncTaskDao;
        DeleteAsyncTask(ProductDao dao) {
            asyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final String... params) {
            asyncTaskDao.deleteProduct(params[0]);
            return null;
        }
    }
    //methods to obtain results and product in ViewModel
    public LiveData<List<Product>> getAllProducts() {
        return allProducts;
    }
    public MutableLiveData<List<Product>> getSearchResults() {
        return searchResults;
    }

}
