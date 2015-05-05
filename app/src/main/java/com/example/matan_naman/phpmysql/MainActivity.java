package com.example.matan_naman.phpmysql;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText usernameField,passwordField;
    private TextView status,role,method;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameField = (EditText)findViewById(R.id.usernametxt);
        passwordField = (EditText)findViewById(R.id.passwordtxt);
        role = (TextView)findViewById(R.id.Statelog);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void login(View view){
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        new SigninActivity(this,role).execute(username,password);

    }

}