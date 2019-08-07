package com.galichfactory.souzgruz.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.galichfactory.souzgruz.OffersUpdateService;
import com.galichfactory.souzgruz.R;
import com.galichfactory.souzgruz.specialClasses.NotificationHelper;
import com.galichfactory.souzgruz.specialClasses.Server;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class SplashActivity extends AppCompatActivity {
	
	SharedPreferences preferences;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
			preferences.edit()
					.clear()
					.apply();
			try {
				stopService(new Intent(this, OffersUpdateService.class));
			}
			catch (Exception ignored){}
			thread.interrupt();
			finishAffinity();
		});
		FirebaseApp.initializeApp(this);
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
			startActivity(new Intent(this, AuthActivity.class));
		} else {

			startActivity(new Intent(this, MainActivity.class));

			Server.driverID = preferences.getInt("driver_id", 0);
			Server.id = preferences.getInt("id", 0);
			Server.token = " Token " + preferences.getString("token", "");
		}
	}
	
}


