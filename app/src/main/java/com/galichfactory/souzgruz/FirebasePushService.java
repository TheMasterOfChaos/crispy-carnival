package com.galichfactory.souzgruz;


import android.app.NotificationManager;
import android.content.Context;
import android.media.RingtoneManager;

import androidx.core.app.NotificationCompat;

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

		NotificationManager notificationManager =
				(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

		notificationManager.notify(0, notificationBuilder.build());
		super.onMessageReceived(remoteMessage);
	}
}
