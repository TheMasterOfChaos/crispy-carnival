package com.galichfactory.souzgruz.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.galichfactory.souzgruz.OffersUpdateService;
import com.galichfactory.souzgruz.specialClasses.NotificationHelper;

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