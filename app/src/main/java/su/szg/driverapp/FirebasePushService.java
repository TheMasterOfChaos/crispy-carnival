package su.szg.driverapp;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.RingtoneManager;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import su.szg.driverapp.R;

import su.szg.driverapp.specialClasses.NotificationHelper;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Objects;

public class FirebasePushService extends FirebaseMessagingService {
	@Override
	public void onMessageReceived(RemoteMessage remoteMessage) {
		NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, "channel_id")
				.setContentTitle(Objects.requireNonNull(remoteMessage.getNotification()).getTitle())
				.setContentText(remoteMessage.getNotification().getBody())
				.setPriority(NotificationCompat.PRIORITY_HIGH)
				.setStyle(new NotificationCompat.BigTextStyle())
				.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
				.setSmallIcon(R.mipmap.ic_launcher)
				.setAutoCancel(true);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			String channelId = "second";
			NotificationChannel channel = new NotificationChannel(
					channelId,
					"Заказы",
					NotificationManager.IMPORTANCE_HIGH);
			NotificationHelper.getNotificationManager(getApplicationContext()).createNotificationChannel(channel);
			notificationBuilder.setChannelId(channelId);
		}
		((NotificationManager) getApplicationContext().
				getSystemService(Context.NOTIFICATION_SERVICE)).
				notify(0, notificationBuilder.build());
		super.onMessageReceived(remoteMessage);
	}
}
