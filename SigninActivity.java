package com.example.matan_naman.phpmysql;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public class SigninActivity  extends AsyncTask<String,Void,String>{
    private EditText usernameField,passwordField,IdField;
    private TextView roleField;
    private int byGetOrPost = 0;
    //flag 0 means get and 1 means post.(By default it is get.)
    public SigninActivity(EditText usernameField,EditText passwordField,EditText IdField,
                          TextView roleField) {

        this.roleField = roleField;
        this.usernameField=usernameField;
        this.passwordField=passwordField;
        this.IdField=IdField;
    }

    protected void onPreExecute(){

    }

    @SuppressLint("NewApi")
    @Override
    protected String doInBackground(String... arg0){
       String username = (String) arg0[0];
        String password = (String) arg0[1];
        String id = (String) arg0[2];


        //String    username="Aadmin";
        // String id = "400000000";
      //  String   password="fthrones5!E";
        HashMap<String, String> map = new HashMap<String, String>();
        String charset="UTF-8";
        String query="";
        String Json="";

        try {
            query = String.format("username=%s&id=%s&password=%s&appType=%s",
                    URLEncoder.encode(username, charset),
                    URLEncoder.encode(id, charset),
                    URLEncoder.encode(password, charset),
                    URLEncoder.encode("2", charset));
        } catch (UnsupportedEncodingException e) {
            return "Error";
        }

        ConnectionClass loginobj =new ConnectionClass(query,"Login");
        Json=loginobj.GetJsonArray();
        if (Json.length()==2)
            return "no";
        try {
            map=loginobj.jsonToMap(Json);
        } catch (JSONException e) {
            return "Error";

        }
        User user = new User();
        user.SetValue(map);

        return  "yes";
    }

    @Override
    protected void onPostExecute(String result){

        if(result.equals("yes"))
            this.roleField.setText("User Connected");
        else  if(result.equals("no"))

        {
            this.roleField.setText("Please Try again");
            usernameField.setText("");
            passwordField.setText("");
           IdField.setText("");
        }
        else
            this.roleField.setText("error occurred");

    }
}

