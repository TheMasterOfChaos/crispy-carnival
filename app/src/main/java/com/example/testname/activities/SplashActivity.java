package com.example.testname.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.testname.specialClasses.Server;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences("user_data", MODE_PRIVATE);
        Server.getInstance();
        checkAuthStatus();
        onStop();
    }

    private void checkAuthStatus() {
        //TODO проверка статуса аутинтификации, и запуск активности для аутинтификации
        if (!preferences.getBoolean("can_drive", false)){
            Server.token = " Token " + preferences.getString("token", "");
            startActivity(new Intent(this, AuthActivity.class));
        }
        else {
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
