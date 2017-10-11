package com.example.luisacfl.tareatabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by luisacfl on 10/10/17.
 */

public class ActivitySplashScreen extends AppCompatActivity{
    public static final String USER_PREFERENCES = "com.iteso.USER_PREFERENCES";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                User user = loadPreferences();
                Intent mainIntent;
                if(user.isLogged())
                    mainIntent = new Intent().setClass(ActivitySplashScreen.this, ActivityMain.class);
                else
                    mainIntent = new Intent().setClass(ActivitySplashScreen.this, ActivityLogin.class);
                startActivity(mainIntent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 3000);
    }
    public User loadPreferences(){
            SharedPreferences sharedPreferences =
                    getSharedPreferences(".CACAHUATE", MODE_PRIVATE);
            User user = new User();
            user.setName(sharedPreferences.getString("USER", null));
            user.setPassword(sharedPreferences.getString("PWD", null));
            user.setLogged(sharedPreferences.getBoolean("LOGGED", false));
            sharedPreferences = null;
            return user;
        }
}
