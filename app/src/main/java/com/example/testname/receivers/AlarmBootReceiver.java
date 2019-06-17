package com.example.testname;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.testname.specialClasses.NotificationHelper;

public class AlarmBootReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		NotificationHelper.scheduleRepeatingRTCNotification(context);
	}
}