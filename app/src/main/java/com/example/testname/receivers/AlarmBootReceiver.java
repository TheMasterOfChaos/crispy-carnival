package com.example.testname.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import com.example.testname.OffersUpdateService;
import com.example.testname.specialClasses.NotificationHelper;

public class AlarmBootReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		NotificationHelper.scheduleRepeatingRTCNotification(context);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			context.startForegroundService(new Intent(context, OffersUpdateService.class));
		}
		else {
			context.startService(new Intent(context, OffersUpdateService.class));
		}
	}
}