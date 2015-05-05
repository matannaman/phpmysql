package com.example.matan_naman.phpmysql;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText usernameField,passwordField,IdField;
    private TextView status,role,method;
    String username,password,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameField = (EditText)findViewById(R.id.usernametxt);
        passwordField = (EditText)findViewById(R.id.passwordtxt);
        IdField = (EditText)findViewById(R.id.idtxt);
        role = (TextView)findViewById(R.id.role);
        

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void login(View view)  {
        username = usernameField.getText().toString();
        password = passwordField.getText().toString();
        id = IdField.getText().toString();
        if(CheckValidation())
            return;

        new SigninActivity(usernameField,passwordField,IdField,role).execute(username,password,id);

    }
    public boolean CheckTextLength(EditText editText,String str,String message) {
        if (str.length() == 0) {
            editText.requestFocus();
            editText.setError(message + " cannot be empty");
            return true;
        }
        return false;
    }
     public boolean CheckValidation(){
         if (CheckTextLength(usernameField, username, "User name")||
                 CheckTextLength(passwordField, password, "Password")||
         CheckTextLength(IdField, id, "ID")
                 )
          return true;
        return false;


    }
    }




