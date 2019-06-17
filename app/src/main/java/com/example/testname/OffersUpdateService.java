package com.example.testnae;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.testname.specialClasses.Order;

import java.util.ArrayList;
import java.util.List;

public class OffersUpdateService extends Service {
	
	List<Order> orderList = new ArrayList<>();
	
	public OffersUpdateService() {
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		
		super.onCreate();
	}
}
