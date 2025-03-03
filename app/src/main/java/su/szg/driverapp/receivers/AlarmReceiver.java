package su.szg.driverapp.receivers;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;

import su.szg.driverapp.R;
import su.szg.driverapp.activities.SplashActivity;
import su.szg.driverapp.specialClasses.NotificationHelper;

public class AlarmReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		
		//Intent для вызова приложения по клику.
		//Мы хотим запустить наше приложение (главную активность) при клике на уведомлении
		Intent intentToRepeat = new Intent(context, SplashActivity.class);
		//настроим флаг для перезапуска приложения
		intentToRepeat.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		PendingIntent pendingIntent =
			PendingIntent.getActivity(context, 0, intentToRepeat, PendingIntent.FLAG_CANCEL_CURRENT);
		//Создаём уведомление
		Notification repeatedNotification = buildLocalNotification(context, pendingIntent).build();
		//Отправляем уведомление
		NotificationHelper.getNotificationManager(context).notify(101, repeatedNotification);
	}
	
	public NotificationCompat.Builder buildLocalNotification(Context context, PendingIntent pendingIntent) {
		NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"")
				.setContentIntent(pendingIntent)
				.setContentText("Не забывайте нас")
				.setSmallIcon(R.mipmap.icon)
				.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
				.setContentTitle("Доброе утро!")
				.setAutoCancel(true);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
		{
			String channelId = "Your_channel_id";
			NotificationChannel channel = new NotificationChannel(
				channelId,
				"morning",
				NotificationManager.IMPORTANCE_HIGH);
			NotificationHelper.getNotificationManager(context).createNotificationChannel(channel);
			builder.setChannelId(channelId);
		}

		return builder;
	}
}