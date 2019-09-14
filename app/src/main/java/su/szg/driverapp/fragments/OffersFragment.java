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
import su.szg.driverapp.adapters.OffersAdapter;
import su.szg.driverapp.specialClasses.Order;
import su.szg.driverapp.specialClasses.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class OffersFragment extends Fragment {
	
	
	public static List<Order> orderList = new ArrayList<>();
	OffersAdapter adapter;
	SwipeRefreshLayout refreshLayout;
	SwipeRefreshLayout.OnRefreshListener listener;
	
	
	
	
	
	
	public OffersFragment() {
		// Required empty public constructor
	}
	
	
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		orderList = new ArrayList<>();
		return inflater.inflate(R.layout.fragment_offers, container, false);
	}
	
	public void update() {
		
		Call<List<Order>> getOrder = Server.api.getOrders(Server.token);
		
		getOrder.enqueue(new Callback<List<Order>>() {
			@Override
			public void onResponse(Call<List<Order>> call, @NonNull Response<List<Order>> response) {
				orderList.clear();
				assert response.body() != null;
				for (Order order: response.body()) {
					if (order.getDriver() == null) {
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
	}
	
	@Override
	public void onResume() {
		super.onResume();
		getActivity().runOnUiThread(() -> refreshLayout.setRefreshing(true));
		listener.onRefresh();
	}
	
	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		RecyclerView recyclerView = view.findViewById(R.id.offers_view);
		
		recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
		refreshLayout =  view.findViewById(R.id.refresh);
		refreshLayout.setColorSchemeResources(R.color.blueMiddle);
		
		listener = () -> (new Timer()).scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				
				update();
				getActivity().runOnUiThread(() -> refreshLayout.setRefreshing(false));
				this.cancel();
			}
			
			@Override
			public boolean cancel() {
				return super.cancel();
			}
		},3000, 5000);
		refreshLayout.setOnRefreshListener(listener);
		adapter = new OffersAdapter(orderList);
		update();
		
		recyclerView.setAdapter(adapter);
	}
	
	
	
}
