package com.example.testname.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.testname.specialClasses.Server;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

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
		if (!preferences.getBoolean("can_drive", false)) {
			Server.token = " Token " + preferences.getString("token", "");
			Server.id = preferences.getInt("id", 0);
			Server.driverID = preferences.getInt("driver_id", 0);
			startActivity(new Intent(this, AuthActivity.class));
		} else {
			startActivity(new Intent(this, MainActivity.class));
			Server.token = " Token " + preferences.getString("token", "");
		}
	}
	
}


