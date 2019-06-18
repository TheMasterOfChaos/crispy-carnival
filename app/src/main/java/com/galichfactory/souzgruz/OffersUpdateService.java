package com.galichfactory.souzgruz;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.galichfactory.souzgruz.activities.SplashActivity;
import com.galichfactory.souzgruz.specialClasses.NotificationHelper;
import com.galichfactory.souzgruz.specialClasses.Order;
import com.galichfactory.souzgruz.specialClasses.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public  class OffersUpdateService extends Service {
	
	static List<Order> orderList = new ArrayList<>();
	public static boolean status;
	
	public OffersUpdateService() {
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
				NotificationChannel androidChannel = new NotificationChannel("background",
					"обновления", NotificationManager.IMPORTANCE_DEFAULT);
				NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				assert manager != null;
				manager.createNotificationChannel(androidChannel);
				startForeground(1, (new Notification.Builder(this, "background").build()));
				
			}
		else {
			startForeground(1,new Notification());
			}
		Server.api.getOrders(Server.token).enqueue(new Callback<List<Order>>() {
			@Override
			public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
				orderList.addAll(Objects.requireNonNull(response.body()));
			}
			
			@Override
			public void onFailure(Call<List<Order>> call, Throwable t) {
			
			}
		});
		Intent intentToRepeat = new Intent(getApplicationContext(), SplashActivity.class);
		//настроим флаг для перезапуска приложения
		
		intentToRepeat.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		PendingIntent pendingIntent =
			PendingIntent.getActivity(getApplicationContext(), 0, intentToRepeat,
				PendingIntent.FLAG_CANCEL_CURRENT);
		Log.d("tagtagtag", "run: 1234");
		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if (status) onDestroy();
				Server.api.getOrders(Server.token).enqueue(new Callback<List<Order>>() {
					@Override
					public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
						Log.d("tagtagtag", "onResponse: " + response.body().size() + " " + orderList.size());
						if(response.body().size() > orderList.size()){
							NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),"")
								.setContentIntent(pendingIntent)
								.setContentText("Не забудьте проверить!")
								.setSmallIcon(R.mipmap.ic_launcher)
								.setContentTitle("Новые заказы!")
								.setAutoCancel(true);
							if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
							{
								String channelId = "second";
								NotificationChannel channel = new NotificationChannel(
									channelId,
									"orders",
									NotificationManager.IMPORTANCE_DEFAULT);
								NotificationHelper.getNotificationManager(getApplicationContext()).createNotificationChannel(channel);
								builder.setChannelId(channelId);
							}
							((NotificationManager) getApplicationContext().
								getSystemService(Context.NOTIFICATION_SERVICE)).
								notify(102,builder.build());
						}
						orderList = response.body();
					}
					
					@Override
					public void onFailure(Call<List<Order>> call, Throwable t) {
					
					}
				});
			}
		},1000, 60 * 1000);
		super.onCreate();
	}
	
	
}
