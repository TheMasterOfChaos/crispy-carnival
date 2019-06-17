package com.galichfactory.souzgruz.activities;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
	Call<Order> call;
	List<String> names = new ArrayList<>();
	Button submitBtn;
	
	
	RecyclerView.Adapter adapter;
	
	TextView
		tvPrice,
		tvDate,
		tvPointNumber,
		tvOrderName,
		tvCash,
		tvCard;
	
	ImageView
		icCard,
		icCash;
	
	SharedPreferences preferences;
	
	OnClickListener
		acceptOrder,
		startOrder;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		int orderId = getIntent().getIntExtra("order", 0);
		int type = getIntent().getIntExtra("type", 0);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		
		
		preferences = getSharedPreferences("user_data", MODE_PRIVATE);
		
		tvPointNumber = findViewById(R.id.tvPointsCount);
		tvDate = findViewById(R.id.tvDate);
		tvPrice =  findViewById(R.id.tvOrderPrice);
		tvOrderName = findViewById(R.id.tvOrderTitle);
		tvCash = findViewById(R.id.tvCashMethod);
		tvCard = findViewById(R.id.tvCardMethod);
		
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
								Server.token,new OrderApplication(
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
		
		call = Server.api.getOrder(orderId, Server.token);
		call.enqueue(new Callback<Order>() {
			@Override
			public void onResponse(@NonNull Call<Order> call, @NonNull Response<Order> response) {
				
				detOrder.setOrder(response.body());
				order.addAll(response.body().getPoints());
				cargo.setCargo(response.body().getCargo());
				tvDate.setText(TimeFormater.format(detOrder.getOrderDateTime()));
				tvPrice.setText(detOrder.getCostDeliverer());
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
				adapter.notifyDataSetChanged();
			}
			
			@Override
			public void onFailure(Call<Order> call, Throwable t) {
				Toast.makeText(getApplicationContext(),"Нет сети",Toast.LENGTH_LONG).show();
				
			}
		});
		Server.api.getDriver(Server.driverID, Server.token).enqueue(new Callback<Driver>() {
			@Override
			public void onResponse(Call<Driver> call, Response<Driver> response) {
				Server.api.getDeliverer(response.body().getDelivererId(), Server.token).enqueue(new Callback<Deliverer>() {
					@Override
					public void onResponse(@NonNull Call<Deliverer> call, @NonNull Response<Deliverer> response) {
						for (Vehicle v:response.body().getVehicles()) {
							if (v.getVehicleType().getId().equals(detOrder.getVehicleType().getId())){
								vehicles.add(v);
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
		if(type == 0) {
			adapter = new DetailOrderAdapter(detOrder, order, cargo);
			submitBtn.setText("Принять заказ");
			submitBtn.setOnClickListener(acceptOrder);
		}
		else  if (type == 1){
			adapter = new FullDetailOrderAdapter(detOrder, order, cargo);
			submitBtn.setOnClickListener(startOrder);
		}
		else {
			adapter = new FullDetailOrderAdapter(detOrder, order, cargo);
			submitBtn.setVisibility(GONE);
		}
		RecyclerView recyclerView = findViewById(R.id.detailRecycler);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setAdapter(adapter);
		
	}
	
	
	public void onBack(View v){
		this.onBackPressed();
	}
}
