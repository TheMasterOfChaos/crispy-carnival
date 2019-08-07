package com.galichfactory.souzgruz.activities;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.galichfactory.souzgruz.OffersUpdateService;
import com.galichfactory.souzgruz.R;
import com.galichfactory.souzgruz.fragments.CompletedOrdersFragment;
import com.galichfactory.souzgruz.fragments.CurrentOrderFragment;
import com.galichfactory.souzgruz.fragments.MyOrdersFragment;
import com.galichfactory.souzgruz.fragments.OffersFragment;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;


public class MainActivity extends AppCompatActivity {
	
	final OffersFragment offersFragment = new OffersFragment();
	final MyOrdersFragment myOrdersFragment = new MyOrdersFragment();
	final CurrentOrderFragment currentOrderFragment = new CurrentOrderFragment();
	final CompletedOrdersFragment completedOrdersFragment = new CompletedOrdersFragment();
	final FragmentManager fm = getSupportFragmentManager();
	public static Fragment active;
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

		FirebaseInstanceId.getInstance().getInstanceId()
				.addOnCompleteListener(task -> {
					if (!task.isSuccessful()) {
						Log.w("tag", "getInstanceId failed", task.getException());
						return;
					}

					// Get new Instance ID token
					String token = task.getResult().getToken();

					// Log and toast
					Log.d("tag", token);
					Toast.makeText(getApplicationContext(), token, Toast.LENGTH_SHORT).show();
				});
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			startForegroundService(new Intent(this, OffersUpdateService.class));
		}
		else{
			startService(new Intent(this, OffersUpdateService.class));
		}
		if (ContextCompat.checkSelfPermission(getApplicationContext(),
				Manifest.permission.READ_CONTACTS)
				!= PackageManager.PERMISSION_GRANTED) {
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
				requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
			}
		}
		setContentView(R.layout.activity_main);
		active = offersFragment;
		preferences = getSharedPreferences("user_data", MODE_PRIVATE);
		
		fm.beginTransaction().add(R.id.main_container, currentOrderFragment, "3")
			.hide(currentOrderFragment).commit();
		fm.beginTransaction().add(R.id.main_container, completedOrdersFragment, "3")
			.hide(completedOrdersFragment).commit();
		fm.beginTransaction().add(R.id.main_container, myOrdersFragment, "2")
			.hide(myOrdersFragment).commit();
		fm.beginTransaction().add(R.id.main_container, offersFragment, "1").commit();

		BottomNavigationView mainNavigationView = findViewById(R.id.main_navigation_view);
		BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
			menuItem -> {
				switch (menuItem.getItemId()){
					case R.id.offersItem:
						fm.beginTransaction().hide(active).show(offersFragment).commit();
						active = offersFragment;
						offersFragment.update();
						return true;
					
					case R.id.myOrdersItem:
						fm.beginTransaction().hide(active).show(myOrdersFragment).commit();
						active = myOrdersFragment;
						myOrdersFragment.update();
						return true;
						
					case R.id.currentOrderItem:
						fm.beginTransaction().hide(active).show(currentOrderFragment).commit();
						currentOrderFragment.cpv.init();
						active = currentOrderFragment;
						return true;
						
					case R.id.completedOrdersItem:
						fm.beginTransaction().hide(active).show(completedOrdersFragment).commit();
						completedOrdersFragment.update();
						
						active = completedOrdersFragment;
						return true;
					
				}
				return false;
			};
		mainNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
	}
	
	
	@Override
	public void onBackPressed() {
	}
	
	public void logout(View view) throws Exception {
		preferences.edit()
			.clear()
			.apply();
		stopService(new Intent(this, OffersUpdateService.class));
		startActivity(new Intent(this, AuthActivity.class));
		onStop();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	
}
