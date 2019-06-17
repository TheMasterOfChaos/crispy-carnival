package com.example.testname.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.testname.OffersUpdateService;
import com.example.testname.specialClasses.NotificationHelper;
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
		if (!preferences.getBoolean("can_drive", false)) {
			Server.token = " Token " + preferences.getString("token", "");
			Server.id = preferences.getInt("id", 0);
			Server.driverID = preferences.getInt("driver_id", 0);
			NotificationHelper.scheduleRepeatingRTCNotification(getApplicationContext());
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
				getApplicationContext().startForegroundService(new Intent(getApplicationContext(), OffersUpdateService.class));
			}
			else {
				getApplicationContext().startService(new Intent(getApplicationContext(), OffersUpdateService.class));
			}
			startActivity(new Intent(this, AuthActivity.class));
		} else {
			startActivity(new Intent(this, MainActivity.class));
			
			Server.token = " Token " + preferences.getString("token", "");
		}
	}
	
}


