package com.example.matan_naman.phpmysql;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class SigninActivity  extends AsyncTask<String,Void,String>{

    private TextView roleField;
    private Context context;
    private int byGetOrPost = 0;
    //flag 0 means get and 1 means post.(By default it is get.)
    public SigninActivity(Context context,
                          TextView roleField) {
        this.context = context;

        this.roleField = roleField;
    }

    protected void onPreExecute(){

    }
    @Override
    protected String doInBackground(String... arg0) {
            try {
                String username = (String) arg0[0];
                String password = (String) arg0[1];
                String link = "http://sameat.light-era.net/login.php?username="
                        + username + "&password=" + password;
                URL url = new URL(link);
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(link));
                HttpResponse response = client.execute(request);
                BufferedReader in = new BufferedReader
                        (new InputStreamReader(response.getEntity().getContent()));

                StringBuffer sb = new StringBuffer("");
                String line = "";
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    break;
                }
                in.close();
                return sb.toString();
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }



    @Override
    protected void onPostExecute(String result){

        if(result.equals("yes"))
        this.roleField.setText("User Connected");
        else
            this.roleField.setText("Try again");

    }
}
