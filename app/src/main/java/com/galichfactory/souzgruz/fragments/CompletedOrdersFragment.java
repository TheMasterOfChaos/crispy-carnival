package com.galichfactory.souzgruz.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.galichfactory.souzgruz.R;
import com.galichfactory.souzgruz.adapters.MyOrdersAdapter;
import com.galichfactory.souzgruz.specialClasses.Order;
import com.galichfactory.souzgruz.specialClasses.Server;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


public class CompletedOrdersFragment extends Fragment {
	List<Order> orderList;
	MyOrdersAdapter adapter;
	int sum;
	TextView sumtv;
	
	
	
	public CompletedOrdersFragment() {
		// Required empty public constructor
	}
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sum = 0;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		
		
		return inflater.inflate(R.layout.fragment_completed_orders, container, false);
	}
	
	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		sumtv = view.findViewById(R.id.tvMoneySum);
		RecyclerView recyclerView = view.findViewById(R.id.completed_orders_view);
		recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
		orderList = new ArrayList<>();
		update();
		
		adapter = new MyOrdersAdapter(orderList);
		recyclerView.setAdapter(adapter);
	}
	
	public void update() {
		sum = 0;
		Log.wtf("tag", "update: ");
		SharedPreferences preferences = getContext()
			.getSharedPreferences("user_data", MODE_PRIVATE);
		Call<List<Order>> getOrder = Server.api
			.getCompletedOrders(Server.driverID, Server.token);
		getOrder.enqueue(new Callback<List<Order>>() {
			@Override
			public void onResponse(Call<List<Order>> call, @NonNull Response<List<Order>> response) {
				orderList.clear();
				for (Order order: response.body()) {
					sum += Float.valueOf(order.getCostDeliverer()).intValue();
					orderList.add(order);
				}
				sumtv.setText(sum + " \u20BD");
				adapter.notifyDataSetChanged();
			}
			
			@Override
			public void onFailure(Call<List<Order>> call, Throwable t) {
				Toast.makeText(getContext(),"Нет сети",Toast.LENGTH_LONG).show();
				
				t.printStackTrace();
			}
		});
	}
}
