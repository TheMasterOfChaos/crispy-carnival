package su.szg.driverapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;


import su.szg.driverapp.activities.SplashActivity;
import su.szg.driverapp.specialClasses.GeoPoint;
import su.szg.driverapp.specialClasses.Order;
import su.szg.driverapp.specialClasses.Server;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
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
							if (location != null && location.getAccuracy() < 500) {
								Server.api.postGeoPos(Server.token,
										new GeoPoint(location.getLatitude(), location.getLongitude())).enqueue(new Callback<ResponseBody>() {
									@Override
									public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

									}

									@Override
									public void onFailure(Call<ResponseBody> call, Throwable t) {

									}
								});
							}

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


			Intent intentToRepeat = new Intent(getApplicationContext(), SplashActivity.class);
			//настроим флаг для перезапуска приложения
			intentToRepeat.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			PendingIntent pendingIntent =
					PendingIntent.getActivity(getApplicationContext(), 0, intentToRepeat,
							PendingIntent.FLAG_CANCEL_CURRENT);


		}
		super.onCreate();
	}


}
