package com.galichfactory.souzgruz.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.galichfactory.souzgruz.R;
import com.galichfactory.souzgruz.fragments.CompletedOrdersFragment;
import com.galichfactory.souzgruz.fragments.CurrentOrderFragment;
import com.galichfactory.souzgruz.fragments.MyOrdersFragment;
import com.galichfactory.souzgruz.fragments.OffersFragment;


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
	
	public void logout(View view) {
		preferences.edit()
			.clear()
			.apply();
		
		startActivity(new Intent(this, AuthActivity.class));
		onStop();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	
}
