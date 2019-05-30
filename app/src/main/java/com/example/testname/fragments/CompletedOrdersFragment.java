package com.example.testname.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testname.R;
import com.example.testname.adapters.MyOrdersAdapter;
import com.example.testname.specialClasses.Order;
import com.example.testname.specialClasses.Server;

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
    
    private void update() {
        Log.wtf("tag", "update: ");
        SharedPreferences preferences = getContext()
            .getSharedPreferences("user_data", MODE_PRIVATE);
        Call<List<Order>> getOrder = Server.api
	        .getCompletedOrders(preferences.getInt("driver_id", -1)," Token "
            + preferences.getString("token",""));
        getOrder.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, @NonNull Response<List<Order>> response) {
                orderList.clear();
                for (Order order: response.body()) {
                	    sum += Integer.valueOf(order.getCostDeliverer());
                        orderList.add(order);
                }
                sumtv.setText(sum + " \u20BD");
                adapter.notifyDataSetChanged();
            }
            
            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
