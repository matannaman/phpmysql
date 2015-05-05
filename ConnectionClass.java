package com.example.matan_naman.phpmysql;

import android.annotation.TargetApi;
import android.os.Build;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by matan_naman on 04/05/2015.
 */
public class ConnectionClass {
    String query;
    String Servlet;
    public ConnectionClass(String query,String Servlet){
        this.query=query;
        this.Servlet=Servlet;
    }
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public String GetJsonArray()
    {
        String appType="2";
        String r_obj="";
        String line="";
        String url="http://10.0.2.2:8081/Sameat/"+Servlet;
        String charset="UTF-8";

        try {
            URLConnection connection= new URL(url).openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Accept-Charset", charset);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
            try(OutputStream output=connection.getOutputStream()) {
                output.write(query.getBytes(charset));
            }
            InputStream response=connection.getInputStream();


            BufferedReader br=new BufferedReader(new InputStreamReader(response));
            while((line=br.readLine()) != null) {
                r_obj+=line;
            }

            System.out.println(r_obj);


        } catch (MalformedURLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return  r_obj;
    }
    public HashMap jsonToMap(String t) throws JSONException {

        HashMap<String, String> map = new HashMap<String, String>();
        JSONObject jObject = new JSONObject(t);
        Iterator<?> keys = jObject.keys();

        while( keys.hasNext() ){
            String key = (String)keys.next();
            String value = jObject.getString(key);
            map.put(key, value);

        }

        return map;
    }
    }
