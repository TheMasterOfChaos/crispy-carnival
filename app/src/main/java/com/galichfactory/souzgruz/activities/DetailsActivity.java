package com.galichfactory.souzgruz.activities;

import android.content.Intent;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.galichfactory.souzgruz.OffersUpdateService;
import com.galichfactory.souzgruz.R;
import com.galichfactory.souzgruz.adapters.AlertVehicleAdapter;
import com.galichfactory.souzgruz.adapters.DetailOrderAdapter;

import com.galichfactory.souzgruz.adapters.FullDetailOrderAdapter;
import com.galichfactory.souzgruz.specialClasses.Cargo;
import com.galichfactory.souzgruz.specialClasses.Deliverer;
import com.galichfactory.souzgruz.specialClasses.Driver;
import com.galichfactory.souzgruz.specialClasses.Order;
import com.galichfactory.souzgruz.specialClasses.OrderApplication;
import com.galichfactory.souzgruz.specialClasses.Point;
import com.galichfactory.souzgruz.specialClasses.Server;
import com.galichfactory.souzgruz.specialClasses.TimeFormater;
import com.galichfactory.souzgruz.specialClasses.User;
import com.galichfactory.souzgruz.specialClasses.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.*;

public class DetailsActivity extends AppCompatActivity {
	List<Point> order = new ArrayList<>();
	List<Vehicle> vehicles = new ArrayList<>();
	Order detOrder = new Order();
	Cargo cargo = new Cargo();
	List<String> names = new ArrayList<>();
	Button submitBtn;
	int applicationId;

	public static final int REQUEST = 3;
	public static final int APPLICATION = 2;
	public static final int ACCEPTED = 1;
	public static final int COMPLETED = 0;



	RecyclerView.Adapter adapter;

	TextView
			tvPrice,
			tvDate,
			tvPointNumber,
			tvOrderName,
			tvCash,
			tvTS,
			tvCard;

	ImageView
			icCard,
			icCash;

	SharedPreferences preferences;

	OnClickListener
			delOrder,
			acceptOrder,
			startOrder;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
			preferences.edit()
					.clear()
					.apply();
			try {
				stopService(new Intent(this, OffersUpdateService.class));
			} catch (Exception ignored) {
			}
			thread.interrupt();
			finishAffinity();
		});
		int orderId = getIntent().getIntExtra("order", 0);
		int type = getIntent().getIntExtra("type", 0);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);


		preferences = getSharedPreferences("user_data", MODE_PRIVATE);

		tvPointNumber = findViewById(R.id.tvPointsCount);
		tvDate = findViewById(R.id.tvDate);
		tvPrice = findViewById(R.id.tvOrderPrice);
		tvOrderName = findViewById(R.id.tvOrderTitle);
		tvCash = findViewById(R.id.tvCashMethod);
		tvCard = findViewById(R.id.tvCardMethod);
		tvTS = findViewById(R.id.tvTS);


		icCard = findViewById(R.id.cardIc);
		icCash = findViewById(R.id.cashIc);
		submitBtn = findViewById(R.id.submitButton);

		acceptOrder = v -> {
			AlertDialog.Builder builder = new AlertDialog.Builder(DetailsActivity.this);
			builder.setTitle("Выберете транспорт")
					.setAdapter(new AlertVehicleAdapter(this, vehicles), (dialog, which) -> {
						Call<User> getDriver = Server.api.getUser(Server.id, Server.token);
						getDriver.enqueue(new Callback<User>() {
							@Override
							public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
								assert response.body() != null;
								detOrder.setDriver(response.body().getDriver());
								detOrder.setVehicle(vehicles.get(which));
								Call<String> r = Server.api.changeOrder(
										Server.token, new OrderApplication(
												new Driver(response.body().getDriver().getId()),
												new Order(detOrder.getId()),
												new Vehicle(vehicles.get(which).getId())));
								r.enqueue(new Callback<String>() {
									@Override
									public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
									}

									@Override
									public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {

									}
								});
							}

							@Override
							public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {

							}
						});
						onBackPressed();
					});
			AlertDialog alert = builder.create();
			alert.show();


		};
		startOrder = v -> {
			HashMap<String, String> id = new HashMap<>();
			id.put("order_id", orderId + "");
			Call<ResponseBody> r = Server.api.nextPoint(id, Server.token);
			r.enqueue(new Callback<ResponseBody>() {
				@Override
				public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {

				}

				@Override
				public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {

				}
			});
			onBackPressed();

		};
		delOrder = v -> {
			int id = getIntent().getIntExtra("orderAppId", 0);
			Call<String> r = Server.api.deleteOrder(Server.token, id);
			r.enqueue(new Callback<String>() {
				@Override
				public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {

				}

				@Override
				public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {

				}
			});
			onBackPressed();

		};

		Server.api.getOrder(orderId, Server.token).enqueue(new Callback<Order>() {
			@Override
			public void onResponse(@NonNull Call<Order> call, @NonNull Response<Order> response) {

				detOrder.setOrder(response.body());
				order.addAll(response.body().getPoints());
				cargo.setCargo(response.body().getCargo());
				tvDate.setText(TimeFormater.format(detOrder.getOrderDateTime()));

				tvTS.setText(detOrder.getVehicleType().getName());
				tvPointNumber.setText("" + detOrder.getPoints().size());
				tvOrderName.setText(detOrder.getCargo().getName());
				if (detOrder.getCustomer().getPaymentType() == 3) {
					icCard.setImageDrawable(getDrawable(R.drawable.ic_card_grey));
					tvCard.setTextColor(ContextCompat.getColor(getApplicationContext(),
							R.color.greyMiddle));

					icCash.setImageDrawable(getDrawable(R.drawable.ic_cash_active));
					tvCash.setTextColor(ContextCompat.getColor(getApplicationContext(),
							R.color.blueDark));
				}
				if (detOrder.getCustomer().getPaymentType() == 1) {
					if (detOrder.getCostDelivererVat() != null) {
						tvPrice.setText(detOrder.getCostDelivererVat() + " \u20BD");
					} else tvPrice.setText("");
				} else {
					if (detOrder.getCostDeliverer() != null) {
						tvPrice.setText(detOrder.getCostDeliverer() + " \u20BD");
					} else tvPrice.setText("");
				}

				adapter.notifyDataSetChanged();
			}

			@Override
			public void onFailure(Call<Order> call, Throwable t) {
				Toast.makeText(getApplicationContext(), "Нет сети", Toast.LENGTH_LONG).show();

			}
		});

		Server.api.getDriver(Server.driverID, Server.token).enqueue(new Callback<Driver>() {
			@Override
			public void onResponse(Call<Driver> call, Response<Driver> response) {
				Server.api.getDeliverer(response.body().getDelivererId(), Server.token).enqueue(new Callback<Deliverer>() {
					@Override
					public void onResponse(@NonNull Call<Deliverer> call, @NonNull Response<Deliverer> response) {
						for (Vehicle v : response.body().getVehicles()) {
							try {
								if (v.getVehicleType().getId().equals(detOrder.getVehicleType().getId())) {
									vehicles.add(v);
								}
							} catch (Exception ignored) {
							}
						}
						Log.d("tag", "onResponse: " + names.size());
					}

					@Override
					public void onFailure(Call<Deliverer> call, Throwable t) {
					}
				});
			}

			@Override
			public void onFailure(Call<Driver> call, Throwable t) {

			}
		});
		switch (type) {
			case COMPLETED: {
				adapter = new FullDetailOrderAdapter(detOrder, order, cargo);
				submitBtn.setVisibility(GONE);
				break;
			}
			case ACCEPTED: {
				adapter = new FullDetailOrderAdapter(detOrder, order, cargo);
				submitBtn.setOnClickListener(startOrder);
				break;
			}
			case APPLICATION: {
				adapter = new DetailOrderAdapter(detOrder, order, cargo);
				submitBtn.setText("Принять заказ");
				submitBtn.setOnClickListener(acceptOrder);
				break;
			}
			case REQUEST:{
				adapter = new DetailOrderAdapter(detOrder, order, cargo);
				submitBtn.setText("Отменить заявку");
				submitBtn.setOnClickListener(delOrder);
				break;
			}
		}

		RecyclerView recyclerView = findViewById(R.id.detailRecycler);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setAdapter(adapter);
	}


	public void onBack(View v) {
		this.onBackPressed();
	}
}
