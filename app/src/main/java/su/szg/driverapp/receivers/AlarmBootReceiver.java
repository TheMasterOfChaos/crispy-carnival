package su.szg.driverapp.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import su.szg.driverapp.OffersUpdateService;
import su.szg.driverapp.specialClasses.NotificationHelper;
import su.szg.driverapp.specialClasses.Server;

public class AlarmBootReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		NotificationHelper.scheduleRepeatingRTCNotification(context);
		Server.getInstance();
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			try {
				context.startForegroundService(new Intent(context, OffersUpdateService.class));
			}
			catch (Exception e){}
		}
		else {
			try {
				context.startService(new Intent(context, OffersUpdateService.class));
			}
			catch (Exception e){}
		}
	}
}