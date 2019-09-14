package su.szg.driverapp.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import su.szg.driverapp.R;
import su.szg.driverapp.activities.DetailsActivity;
import su.szg.driverapp.adapters.MyOrdersAdapter;
import su.szg.driverapp.specialClasses.Order;
import su.szg.driverapp.specialClasses.Server;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


public class CompletedOrdersFragment extends Fragment {
	private List<Order> orderList;
	private MyOrdersAdapter adapter;
	private int sum;
	private TextView sumtv,
		staticTv;
	private ImageView img;
	
	
	
	public CompletedOrdersFragment() {
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
		staticTv = view.findViewById(R.id.tvMoneySumStatic);
		img = view.findViewById(R.id.imageView4);

		RecyclerView recyclerView = view.findViewById(R.id.completed_orders_view);
		recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
		orderList = new ArrayList<>();
		update();
		
		adapter = new MyOrdersAdapter(orderList, DetailsActivity.COMPLETED);
		recyclerView.setAdapter(adapter);
	}
	
	public void update() {
		sum = 0;
		SharedPreferences preferences = getContext()
			.getSharedPreferences("user_data", MODE_PRIVATE);
		Call<List<Order>> getOrder = Server.api
			.getCompletedOrders(Server.driverID, Server.token);
		getOrder.enqueue(new Callback<List<Order>>() {
			@Override
			public void onResponse(Call<List<Order>> call, @NonNull Response<List<Order>> response) {
				orderList.clear();
				for (Order order: response.body()) {
					if (order.getCostDeliverer() != null)
						sum += Float.valueOf(order.getCostDeliverer()).intValue();
					orderList.add(order);
				}
				sumtv.setText(sum + " \u20BD");
				try{
					if (orderList.get(0).getCostDeliverer() == null)
					{
						img.setVisibility(View.GONE);
						sumtv.setVisibility(View.GONE);
						staticTv.setVisibility(View.GONE);
					}
				}
				catch (Exception ignored){
					img.setVisibility(View.GONE);
					sumtv.setVisibility(View.GONE);
					staticTv.setVisibility(View.GONE);
				}
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
