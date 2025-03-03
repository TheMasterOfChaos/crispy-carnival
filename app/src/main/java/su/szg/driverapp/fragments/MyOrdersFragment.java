package su.szg.driverapp.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import su.szg.driverapp.R;
import su.szg.driverapp.activities.DetailsActivity;
import su.szg.driverapp.adapters.MyOrdersAdapter;
import su.szg.driverapp.specialClasses.Order;
import su.szg.driverapp.specialClasses.OrderApplication;
import su.szg.driverapp.specialClasses.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MyOrdersFragment extends Fragment {
	
	SwipeRefreshLayout refreshLayout;
	List<Order> orderList = new ArrayList<>();
	List<Order> orders = new ArrayList<>();
	List<OrderApplication> orderApplications = new ArrayList<>();

	MyOrdersAdapter adapter;
	MyOrdersAdapter applicationAdapter;
	SwipeRefreshLayout.OnRefreshListener listener;
	
	
	
	public MyOrdersFragment() {
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		update();
		return inflater.inflate(R.layout.fragment_my_orders, container, false);
	}
	
	public void update() {
		Call<List<Order>> getOrder = Server.api.getMyOrders(Server.driverID, Server.token);
		getOrder.enqueue(new Callback<List<Order>>() {
			@Override
			public void onResponse(Call<List<Order>> call, @NonNull Response<List<Order>> response) {
				orderList.clear();
				for (Order order: response.body()) {
					if (order.getDriver() != null) {
						orderList.add(order);
					}
				}
				
				getActivity().runOnUiThread(() -> adapter.notifyDataSetChanged());
			}
			
			@Override
			public void onFailure(Call<List<Order>> call, Throwable t) {
				Toast.makeText(getContext(),"Нет сети",Toast.LENGTH_LONG).show();
				
				t.printStackTrace();
			}
		});

		Call<List<OrderApplication>> getApplications = Server.api.getOrdersApplications(Server.token, Server.driverID);
		getApplications.enqueue(new Callback<List<OrderApplication>>() {
			@Override
			public void onResponse(Call<List<OrderApplication>> call, @NonNull Response<List<OrderApplication>> response) {
				orderApplications.clear();
				orders.clear();
				orderApplications.addAll(response.body());
				for (OrderApplication orderApplication: orderApplications) {
					Order order =orderApplication.getOrder();
					order.setAppId(orderApplication.getId());
					orders.add(order);
				}
				getActivity().runOnUiThread(() -> applicationAdapter.notifyDataSetChanged());
			}

			@Override
			public void onFailure(Call<List<OrderApplication>> call, Throwable t) {
				Toast.makeText(getContext(),"Нет сети",Toast.LENGTH_LONG).show();

				t.printStackTrace();
			}
		});


	}
	
	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		RecyclerView recyclerView = view.findViewById(R.id.my_orders_view);
		RecyclerView applicationView = view.findViewById(R.id.application_view);
		applicationView.setLayoutManager(new LinearLayoutManager(getContext()));
		recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
		refreshLayout =  view.findViewById(R.id.refresh);
		refreshLayout.setColorSchemeResources(R.color.blueMiddle);
		listener = () -> (new Timer()).scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				update();
				getActivity().runOnUiThread(() ->refreshLayout.setRefreshing(false));
				this.cancel();
			}
			
			@Override
			public boolean cancel() {
				return super.cancel();
			}
		},1000, 5000);

		refreshLayout.setOnRefreshListener(listener);
		adapter = new MyOrdersAdapter(orderList, DetailsActivity.ACCEPTED);
		applicationAdapter  = new MyOrdersAdapter(orders, DetailsActivity.REQUEST);
		applicationView.setAdapter(applicationAdapter);
		recyclerView.setAdapter(adapter);
		
	}

	@Override
	public void onResume() {
		super.onResume();
		refreshLayout.setRefreshing(true);
		listener.onRefresh();
	}
	
}
