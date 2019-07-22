package com.galichfactory.souzgruz.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.galichfactory.souzgruz.OffersUpdateService;
import com.galichfactory.souzgruz.specialClasses.NotificationHelper;
import com.galichfactory.souzgruz.specialClasses.Server;

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
				startForegroundService(new Intent(this, OffersUpdateService.class));
			}
			else{
				startService(new Intent(this, OffersUpdateService.class));
			}
			startActivity(new Intent(this, AuthActivity.class));
		} else {
			startActivity(new Intent(this, MainActivity.class));
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
				startForegroundService(new Intent(this, OffersUpdateService.class));
			}
			else{
				startService(new Intent(this, OffersUpdateService.class));
			}
			Server.driverID = preferences.getInt("driver_id", 0);
			Server.id = preferences.getInt("id", 0);
			Server.token = " Token " + preferences.getString("token", "");
		}
	}
	
}


