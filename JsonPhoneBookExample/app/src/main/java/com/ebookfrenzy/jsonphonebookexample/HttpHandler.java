package com.ebookfrenzy.jsonphonebookexample;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpHandler {
    public String makeServiceCall(){
        String responce = null;

        try {
            URL url = new URL("https://api.myjson.com/bins/kw7uk");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = new BufferedInputStream(connection.getInputStream());
            responce = convertStreamToString(inputStream);
        } catch (MalformedURLException e) {
            Log.i("Error","MalformedURLException");
        } catch (ProtocolException e) {
            Log.i("Error","ProtocolException");
        } catch (IOException e) {
            Log.i("Error","IOException makeServiceCall");
        }
        return responce;
    }

    private String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder strBuilder = new StringBuilder();

        String line;
        try {
            while((line = bufferedReader.readLine()) != null){
                //line = bufferedReader.readLine();
                strBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
                e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            }catch (IOException e) {
                Log.i("Error","IOException converStreamtoString");
            }
        }
        return strBuilder.toString();
    }
}
