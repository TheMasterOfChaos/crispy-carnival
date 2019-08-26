package com.galichfactory.souzgruz.specialClasses;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.util.AttributeSet;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.galichfactory.souzgruz.R;

import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrentPointView extends ConstraintLayout {
	
	TextView
		date,
		address,
		mass,
		height,
		width,
		length,
		notes,
		number,
		title,
		phone,
		name,
		cargoName,
		pointsCount,
		price,
		allDate;
	
	Button button;
	
	Order order;
	
	public CurrentPointView(Context context) {
		super(context);
		init();
	}
	
	public CurrentPointView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	public CurrentPointView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}
	
	
	public void init() {
		removeAllViewsInLayout();
		
		Call<List<Order>> call = Server.api.getCurrentOrder(Server.driverID, Server.token);
		call.enqueue(new Callback<List<Order>>() {
			@Override
			public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
				if((response.body() != null ? response.body().size() : 0) != 0){
					order = response.body().get(0);
					if (order.getNextPoint() == order.getPoints().size())
						changeButton();
					else
						fetchOrder();
				}
				else {
					fetchNoOrder();
				}
			}
			
			@Override
			public void onFailure(Call<List<Order>> call, Throwable t) {
			
			}
		});
		
	}
	
	private void changeButton() {
		
		inflate(getContext(), R.layout.current_order_view, this);
		Cargo cargo = order.getCargo();
		List<Point> pointList = order.getPoints();
		int i = order.getNextPoint() - 1;
		name = findViewById(R.id.tvPerson);
		phone = findViewById(R.id.tvPhone);
		number = findViewById(R.id.tvPointNumber);
		date = findViewById(R.id.tvDate);
		address = findViewById(R.id.tvAddress);
		mass = findViewById(R.id.tvMass);
		height = findViewById(R.id.tvHeight);
		width = findViewById(R.id.tvWidth);
		length = findViewById(R.id.tvLength);
		notes = findViewById(R.id.tvNotes);
		title = findViewById(R.id.tvWhyWeNeedThis);
		allDate = findViewById(R.id.tvOrdersDate);
		cargoName = findViewById(R.id.tvCurrentOrderName);
		pointsCount = findViewById(R.id.tvPointsCount);
		price = findViewById(R.id.tvOrderPrice);
		button = findViewById(R.id.button3);
		length.setText(cargo.getLength());
		width.setText(cargo.getWidth());
		height.setText(cargo.getHeight());
		mass.setText(cargo.getMass());
		date.setText(pointList.get(i).getArriveDateTime());
		address.setText(pointList.get(i).getLocation());
		number.setText(Integer.valueOf(i + 1).toString() + "");
		title.setText("Пункт №" + (i + 1));
		phone.setText(pointList.get(i).getPhoneNumber());
		name.setText(order.getCustomer().getName());
		notes.setText(order.getComment());
		if (order.getCustomer().getPaymentType() == 1) {
			if (order.getCostDelivererVat() != null) {
				price.setText(order.getCostDelivererVat() + " \u20BD");
			}
			else price.setText("");
		}
		else{
			if (order.getCostDeliverer() != null) {
				price.setText(order.getCostDeliverer() + " \u20BD");
			}
			else price.setText("");
		}		pointsCount.setText(order.getPoints().size() + "");
		cargoName.setText(cargo.getName());
		button.setBackgroundResource(R.drawable.red_gradient);
		
		button.setText("Завершить заказ");
		button.setOnClickListener(v ->{
			HashMap<String, String> id = new HashMap<>();
			id.put("order_id", order.getId() + "");
			Call<ResponseBody> r = Server.api.nextPoint(id, Server.token);
			r.enqueue(new Callback<ResponseBody>() {
				@Override
				public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
					init();
				}
				
				@Override
				public void onFailure(Call<ResponseBody> call, Throwable t) {
					Toast.makeText(getContext(),"Нет сети",Toast.LENGTH_LONG).show();
				}
			});
			
			
		});
	}
	
	private void fetchOrder() {
		inflate(getContext(), R.layout.current_order_view, this);
		Cargo cargo = order.getCargo();
		List<Point> pointList = order.getPoints();
		int i = order.getNextPoint();
		name = findViewById(R.id.tvPerson);
		phone = findViewById(R.id.tvPhone);
		number = findViewById(R.id.tvPointNumber);
		date = findViewById(R.id.tvDate);
		address = findViewById(R.id.tvAddress);
		mass = findViewById(R.id.tvMass);
		height = findViewById(R.id.tvHeight);
		width = findViewById(R.id.tvWidth);
		length = findViewById(R.id.tvLength);
		notes = findViewById(R.id.tvNotes);
		title = findViewById(R.id.tvWhyWeNeedThis);
		allDate = findViewById(R.id.tvOrdersDate);
		cargoName = findViewById(R.id.tvCurrentOrderName);
		pointsCount = findViewById(R.id.tvPointsCount);
		price = findViewById(R.id.tvOrderPrice);
		button = findViewById(R.id.button3);
		button.setBackgroundResource(R.drawable.round_gradient);
		
		length.setText(cargo.getLength());
		width.setText(cargo.getWidth());
		height.setText(cargo.getHeight());
		mass.setText(cargo.getMass());
		date.setText(TimeFormater.format(order.getOrderDateTime()));
		address.setText(pointList.get(i).getLocation());
		number.setText(Integer.valueOf(i + 1).toString() + "");
		title.setText("Пункт №" + (i + 1));
		phone.setText(pointList.get(i).getPhoneNumber());
		name.setText(order.getCustomer().getName());
		notes.setText(order.getComment());
		if (order.getCustomer().getPaymentType() == 1) {
			if (order.getCostDelivererVat() != null) {
				price.setText(order.getCostDelivererVat() + " \u20BD");
			}
			else price.setText("");
		}
		else{
			if (order.getCostDeliverer() != null) {
				price.setText(order.getCostDeliverer() + " \u20BD");
			}
			else price.setText("");
		}
		pointsCount.setText(order.getPoints().size() + "");
		cargoName.setText(cargo.getName());
		button.setOnClickListener(v ->{
			HashMap<String, String> id = new HashMap<>();
			id.put("order_id", order.getId() + "");
			Call<ResponseBody> r = Server.api.nextPoint(id, Server.token);
			button.setText("Уехал с точки");
			button.setBackgroundResource(R.drawable.green_gradient);
			r.enqueue(new Callback<ResponseBody>() {
				@Override
				public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

				}

				@Override
				public void onFailure(Call<ResponseBody> call, Throwable t) {
					Toast.makeText(getContext(),"Нет сети",Toast.LENGTH_LONG).show();
				}});
			r = Server.api.leavePoint(id, Server.token);
			Call<ResponseBody> finalR = r;
			button.setOnClickListener(view ->
				finalR.enqueue(new Callback<ResponseBody>() {
					@Override
					public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
						init();
					}

					@Override
					public void onFailure(Call<ResponseBody> call, Throwable t) {
						Toast.makeText(getContext(),"Нет сети",Toast.LENGTH_LONG).show();
					}

			}));

		});
	}
	
	void fetchNoOrder(){
		inflate(getContext(), R.layout.no_order_layout, this);
		
	}
}
