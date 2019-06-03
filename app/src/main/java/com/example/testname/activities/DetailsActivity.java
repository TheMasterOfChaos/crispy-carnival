package com.example.testname.activities;

import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
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

import com.example.testname.R;
import com.example.testname.adapters.DetailOrderAdapter;

import com.example.testname.adapters.FullDetailOrderAdapter;
import com.example.testname.specialClasses.Cargo;
import com.example.testname.specialClasses.Order;
import com.example.testname.specialClasses.Point;
import com.example.testname.specialClasses.Server;
import com.example.testname.specialClasses.User;

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
	Order detOrder = new Order();
	Cargo cargo = new Cargo();
	Call<Order> call;
	
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
		
		tvPointNumber = ((TextView) findViewById(R.id.tvPointsCount));
		tvDate = ((TextView) findViewById(R.id.tvDate));
		tvPrice = ((TextView) findViewById(R.id.tvOrderPrice));
		tvOrderName = ((TextView) findViewById(R.id.tvOrderTitle));
		tvCash = ((TextView) findViewById(R.id.tvCashMethod));
		tvCard = ((TextView) findViewById(R.id.tvCardMethod));
		
		icCard = ((ImageView) findViewById(R.id.cardIc));
		icCash = ((ImageView) findViewById(R.id.cashIc));
		submitBtn = findViewById(R.id.submitButton);
		
		acceptOrder = v -> {
			Call<User> getDriver = Server.api.getUser(Server.id, Server.token);
			getDriver.enqueue(new Callback<User>() {
				@Override
				public void onResponse(Call<User> call, Response<User> response) {
					detOrder.setDriver(response.body().getDriver());
					Call<String> r = Server.api.changeOrder(detOrder.getId(), Server.token, detOrder);
					r.enqueue(new Callback<String>() {
						@Override
						public void onResponse(Call<String> call, Response<String> response) {
						
						}
						
						@Override
						public void onFailure(Call<String> call, Throwable t) {
						
						}
					});
				}
				
				@Override
				public void onFailure(Call<User> call, Throwable t) {
				
				}
			});
			onBackPressed();
			
		};
		startOrder = v -> {
			HashMap<String, String> id = new HashMap<>();
			id.put("order_id", orderId + "");
			Call<ResponseBody> r = Server.api.nextPoint(id, Server.token);
			r.enqueue(new Callback<ResponseBody>() {
				@Override
				public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
				
				}
				
				@Override
				public void onFailure(Call<ResponseBody> call, Throwable t) {
				
				}
			});
			onBackPressed();
			
		};
		
		call = Server.api.getOrder(orderId, Server.token);
		call.enqueue(new Callback<Order>() {
			@Override
			public void onResponse(Call<Order> call, Response<Order> response) {
				
				Log.wtf("tag", "onResponse: " + response.body().getPoints().get(0).toString());
				detOrder.setOrder(response.body());
				order.addAll(response.body().getPoints());
				cargo.setCargo(response.body().getCargo());
				Log.wtf("tag", "onResponse: " + response.body().getCargo().toString());
				tvDate.setText(detOrder.getBeginDateTime());
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
		
		Log.wtf("tag", "onCreate: " + detOrder.toString());
		if(type == 0) {
			adapter = new DetailOrderAdapter(detOrder, order, cargo);
			submitBtn.setText("Принять заказ");
			submitBtn.setOnClickListener(acceptOrder);
		}
		else {
			adapter = new FullDetailOrderAdapter(detOrder, order, cargo);
			submitBtn.setOnClickListener(startOrder);
		}
		RecyclerView recyclerView = findViewById(R.id.detailRecycler);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setAdapter(adapter);
		
	}
	
	
	public void onBack(View v){
		this.onBackPressed();
	}
}
