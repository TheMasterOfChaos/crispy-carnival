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
import com.example.testname.specialClasses.User;

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
                Call<User> getDriver = Server.api.getUser(preferences.getInt("id", -1), " Token "
                    + getSharedPreferences("user_data", MODE_PRIVATE).getString("token",""));
                getDriver.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (!response.body().getDriver().getKYCControl().getWorkAccess())
                            fm.beginTransaction().add(R.id.authContainer, thirdFragment).commit();
                        else {
                            preferences.edit().putBoolean("can_work", response.body().getDriver().getKYCControl().getWorkAccess()).apply();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

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
