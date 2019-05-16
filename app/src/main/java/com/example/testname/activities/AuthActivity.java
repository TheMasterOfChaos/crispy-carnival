package com.example.testname.activities;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.testname.R;
import com.example.testname.fragments.FirstAuthFragment;
import com.example.testname.fragments.ThirdAuthFragment;
import com.example.testname.specialClasses.Driver;
import com.example.testname.specialClasses.Server;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthActivity extends AppCompatActivity {

    final FirstAuthFragment firstFragment = new FirstAuthFragment();
    final ThirdAuthFragment thirdFragment = new ThirdAuthFragment();
    public final FragmentManager fm = getSupportFragmentManager();
    public String curNumber;
    private SharedPreferences preferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences("user_data", MODE_PRIVATE);
        setContentView(R.layout.activity_auth);
        if (!preferences.contains("id")){
            fm.beginTransaction().add(R.id.authContainer, firstFragment).commit();
        }
        else {
            if(!preferences.getBoolean("can_work", true)) {
                Call<Driver> getDriver = Server.api.getDriver(preferences.getInt("id", -1));
                getDriver.enqueue(new Callback<Driver>() {
                    @Override
                    public void onResponse(Call<Driver> call, Response<Driver> response) {
                        if (!response.body().getCanWork())
                            fm.beginTransaction().add(R.id.authContainer, thirdFragment).commit();
                        else {
                            preferences.edit().putBoolean("can_work", response.body().getCanWork()).apply();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                    }

                    @Override
                    public void onFailure(Call<Driver> call, Throwable t) {

                    }
                });
            }
            else {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }

        }
    }

    @Override
    public void onBackPressed() {

    }

    public void stop() {
        onStop();
    }
}
