package com.ebookfrenzy.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.icu.util.LocaleData;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    private static final String TAG = "ServiceExample";

    private class SrvTask extends AsyncTask<Integer, Integer, String> {
        @Override
        protected String doInBackground(Integer... parms) {
            int startId = parms[0];
            int i=0;
            while(i<=3){

                publishProgress(parms[0]);
                try{
                    Thread.sleep(10000);
                    i++;
                }catch(Exception e){}
            }
            return("Service complete "+startId);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i(TAG,"Service Running "+ values[0]);
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onPostExecute(String result) {
            Log.i(TAG, result);
        }
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "Service onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        AsyncTask task = new SrvTask().executeOnExecutor(
                AsyncTask.THREAD_POOL_EXECUTOR, startId);

        return Service.START_STICKY;
    }



    @Override
    public IBinder onBind(Intent arg0) {
        Log.i(TAG,"Service onBind");
        return null;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "Service onDestroy");
    }
}
