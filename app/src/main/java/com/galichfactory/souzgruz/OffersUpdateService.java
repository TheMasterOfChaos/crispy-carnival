package com.galichfactory.souzgruz;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.galichfactory.souzgruz.activities.SplashActivity;
import com.galichfactory.souzgruz.specialClasses.GeoPoint;
import com.galichfactory.souzgruz.specialClasses.NotificationHelper;
import com.galichfactory.souzgruz.specialClasses.Order;
import com.galichfactory.souzgruz.specialClasses.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.ResponseBody;
import okhttp3.internal.Version;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OffersUpdateService extends Service {

	static List<Order> orderList = new ArrayList<>();
	static List<Order> acceptedOrderList = new ArrayList<>();
	public static boolean status;
	LocationManager lm;
	String TAG = "TAG";
	LocationListener locationListener;


	public OffersUpdateService() {
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {

		SharedPreferences preferences = getSharedPreferences("user_data", MODE_PRIVATE);
		if (!preferences.getBoolean("can_drive", false)) {
			lm = (LocationManager)
					getSystemService(Context.LOCATION_SERVICE);
			Server.getInstance();
			Server.token = " Token " + preferences.getString("token", "");
			Server.id = preferences.getInt("id", 0);
			Server.driverID = preferences.getInt("driver_id", 0);
				try {
					Log.d(TAG, "onCreate: " + lm.getAllProviders().size());
					locationListener = new LocationListener() {
						@Override
						public void onLocationChanged(final Location location) {
							Log.d("runrunrun", "run: run");
							if (location != null) {
								Log.d("runrunrun", "not null");
								Server.api.postGeoPos(Server.token,
										new GeoPoint(location.getLatitude(), location.getLongitude())).enqueue(new Callback<ResponseBody>() {
									@Override
									public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

									}

									@Override
									public void onFailure(Call<ResponseBody> call, Throwable t) {

									}
								});
							} else Log.d("runrunrun", "onProviderDisabled: ");

						}

						@Override
						public void onProviderDisabled(String provider) {

						}

						@Override
						public void onProviderEnabled(String provider) {
						}

						@Override
						public void onStatusChanged(String provider, int status, Bundle extras) {
						}
					};
					lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 0, locationListener);

					Log.d(TAG, "onCreate: ");
				} catch (SecurityException e){e.printStackTrace();}
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
				NotificationChannel androidChannel = new NotificationChannel("background",
						"обновления", NotificationManager.IMPORTANCE_DEFAULT);
				NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				assert manager != null;
				manager.createNotificationChannel(androidChannel);
				startForeground(1, (new Notification.Builder(this, "background").build()));

			} else {
				startForeground(1, new Notification());
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
			Server.api.getMyOrders(Server.driverID, Server.token).enqueue(new Callback<List<Order>>() {
				@Override
				public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
					acceptedOrderList.addAll(response.body());
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
			new Timer().scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					try {
						Server.api.postGeoPos(Server.token, new GeoPoint(lm.getLastKnownLocation(LocationManager.GPS_PROVIDER))).enqueue(new Callback<ResponseBody>() {
							@Override
							public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

							}

							@Override
							public void onFailure(Call<ResponseBody> call, Throwable t) {

							}
						});
					}
					catch (SecurityException e){e.printStackTrace();}
					catch (NullPointerException e){e.printStackTrace();
					if (status) onDestroy();
					Server.api.getOrders(Server.token).enqueue(new Callback<List<Order>>() {
						@Override
						public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
							if (response.body() != null && response.body().size() > orderList.size()) {
								NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "")
										.setContentIntent(pendingIntent)
										.setContentText("Не забудьте проверить!")
										.setSmallIcon(R.mipmap.ic_launcher)
										.setContentTitle("Новые заказы!")
										.setAutoCancel(true);
								if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
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
										notify(102, builder.build());
							}
							orderList = response.body();
						}

						@Override
						public void onFailure(Call<List<Order>> call, Throwable t) {

						}
					});
					Server.api.getMyOrders(Server.driverID, Server.token).enqueue(new Callback<List<Order>>() {
						@Override
						public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
							if (response.body() != null && response.body().size() > acceptedOrderList.size()) {
								NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "")
										.setContentIntent(pendingIntent)
										.setContentText("Не забудьте проверить!")
										.setSmallIcon(R.mipmap.ic_launcher)
										.setContentTitle("Вы были назначены на заказ!")
										.setAutoCancel(true);
								if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
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
										notify(102, builder.build());
							}
							acceptedOrderList = response.body();
						}

						@Override
						public void onFailure(Call<List<Order>> call, Throwable t) {

						}
					});


				}
			}}, 5000, 30 * 1000);

		}
		super.onCreate();
	}


}
