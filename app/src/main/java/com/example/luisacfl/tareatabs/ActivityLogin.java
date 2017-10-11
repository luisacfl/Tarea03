package com.example.luisacfl.tareatabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by luisacfl on 10/10/17.
 */

public class ActivityLogin extends AppCompatActivity {

    public EditText username;
    public EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.activity_login_username);
        password = (EditText) findViewById(R.id.activity_login_pwd);
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.activity_login_signin:
                savePreferences();
                Intent intent = new Intent(this, ActivityMain.class);
                startActivity(intent);
                break;
        }
    }
    public void savePreferences(){
        User user = new User();
        user.setName(username.getText().toString());
        user.setPassword(password.getText().toString());
        user.setLogged(true);
        SharedPreferences sharedPreferences = getSharedPreferences(".CACAHUATE", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("USER", user.getName());
        editor.putString("PWD", user.getPassword());
        editor.putBoolean("LOGGED", user.isLogged());
        editor.apply();
    }
}
